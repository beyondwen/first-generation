package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.richang6s.RiChang6s;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.richang6s.RiChang6sMapper;
import com.amchis.firstgeneration.mapper.guanli.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiChang6sService extends BaseApiService<RiChang6s> {

    @Autowired
    private RiChang6sMapper riChang6sMapper;

    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {
        return riChang6sMapper.deleteByPrimaryKey(id);
    }

    public int insert(RiChang6s record) {
        return riChang6sMapper.insert(record);
    }

    public int insertSelective(RiChang6s record) {
        return riChang6sMapper.insertSelective(record);
    }

    public RiChang6s selectByPrimaryKey(Integer id) {
        return riChang6sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo ChaxunAppSuoyouRichangRiqi(String Shoujihao, String yonghuwaijian) {
        //根据工号查询用户是否存在
        User user = userMapper.findByPhone(Shoujihao);
        if (user == null) {
            return setResult("0", "YONGHU_BUCUNZAI", "用户不存在");
        } else {
            List<RiChang6s> riChang6s = riChang6sMapper.ChaxunAppSuoyouRichangRiqi(yonghuwaijian);
            if (riChang6s.size() > 0) {
                return setResult("1", riChang6s);
            } else {
                return setResult("0", "RICHANG_WEITIANXIE", "您没有填写过日常数据");
            }
        }
    }

    public int updateByPrimaryKeySelective(RiChang6s record) {
        return riChang6sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RiChang6s record) {
        return riChang6sMapper.updateByPrimaryKey(record);
    }
}