package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.Register.RegisterBean;
import com.amchis.firstgeneration.bean.guanli.jwtbean.Jwtbean;
import com.amchis.firstgeneration.bean.guanli.loginbean.LoginBean;
import com.amchis.firstgeneration.bean.guanli.password.Password;
import com.amchis.firstgeneration.bean.guanli.role.Role;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.password.PasswordMapper;
import com.amchis.firstgeneration.mapper.guanli.role.RoleMapper;
import com.amchis.firstgeneration.mapper.guanli.user.UserMapper;
import com.amchis.firstgeneration.utils.DateUtils;
import com.amchis.firstgeneration.utils.GetTime;
import com.amchis.firstgeneration.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService extends BaseApiService<User> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordMapper passwordMapper;

    @Autowired
    private RoleMapper roleMapper;

    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }


    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }


    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public ReponseVo findByName(LoginBean loginBean) {
        if (loginBean == null) {
            return setResult("0", "QINGLURU_DENGLUXINGXI", "请录入登录信息");
        } else {
            String gonghao = loginBean.getGonghao();
            if (StringUtils.isEmpty(gonghao)) {
                return setResult("0", "QINGLURU_GONGHAO", "请录入工号");
            }
            String mima = loginBean.getMima();
            if (StringUtils.isEmpty(mima)) {
                return setResult("0", "QINGLURU_MIMA", "请录入密码");
            }
            //根据工号查询用户是否存在
            User user = userMapper.findByName(gonghao);
            if (user != null) {
                return getPassword(mima, user);
            } else {
                return setResult("0", "YONGHU_BUCUNZAI", "用户不存在");
            }
        }
    }

    public ReponseVo findByName4Register(RegisterBean registerBean) {
        //根据工号查询用户是否存在
        User user = userMapper.findByName(registerBean.getGonghao());
        if (user != null) {
            return setResult("0", "YONGHU_YICUNZAI", "用户存在");
        } else {
            String mingcheng = registerBean.getMingcheng();
            String shoujihao = registerBean.getShoujihao();
            user.setWaijian(GetTime.getGuid());
            user.setMingcheng(mingcheng);
            user.setShoujihao(shoujihao);
            user.setLuruduan("LIULANQI");
            user.setShixiao("0");
            user.setRiqi(DateUtils.getDay());
            int i = userMapper.insertSelective(user);
            if (toDaoResult(i)) {
                return setResult("1", "LURU_CHENGGONG", "录入成功");
            } else {
                return setResult("1", "LURU_SHIBAI", "录入失败");
            }
        }
    }

    private ReponseVo getPassword(String mima, User user) {
        //根据用户外键查询密码
        Password password = passwordMapper.selectByPasswordAndWaijian(user.getWaijian(), mima);
        if (password != null) {
            //密码正确根据用户外键查询角色
            Role role = roleMapper.selectRoleByYonghuwaijian(user.getWaijian());
            if (role != null) {
                if (StringUtils.isEmpty(role.getBianma())) {
                    return setResult("0", "JUESE_WEIFENPEI", "角色未分配");
                }
                Jwtbean jwtbean = new Jwtbean(user.getWaijian(), user.getShoujihao(), user.getGonghao(), role.getBianma());
                String token = JwtUtil.createJWT(jwtbean);
                String[] tokenarr = {token};
                return setResult("1", tokenarr);
            } else {
                return setResult("0", "JUESE_WEIFENPEI", "角色未分配");
            }
        } else {
            return setResult("0", "YONGHU_MIMACUOWU", "用户密码错误");
        }
    }
}
