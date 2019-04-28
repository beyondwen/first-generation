package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.bean.huoban.richang6s.Richang6s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.user.UserMapper;
import com.amchis.firstgeneration.mapper.huoban.richang6s.Richang6sMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiChang6sService extends BaseApiService<Richang6s> {

    @Autowired
    private Richang6sMapper riChang6sMapper;

    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {
        return riChang6sMapper.deleteByPrimaryKey(id);
    }

    public int insert(Richang6s record) {
        return riChang6sMapper.insert(record);
    }

    public int insertSelective(Richang6s record) {
        return riChang6sMapper.insertSelective(record);
    }

    public Richang6s selectByPrimaryKey(Integer id) {
        return riChang6sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo ChaxunAppSuoyouRichangRiqi(String Shoujihao, String yonghuwaijian) {
        //根据工号查询用户是否存在
        User user = userMapper.findByPhone(Shoujihao);
        if (user == null) {
            return setResult("0", "YONGHU_BUCUNZAI", "用户不存在");
        } else {
            List<Richang6s> riChang6s = riChang6sMapper.ChaxunAppSuoyouRichangRiqi(yonghuwaijian);
            if (riChang6s.size() > 0) {
                return setResult("1", riChang6s);
            } else {
                return setResult("0", "RICHANG_WEITIANXIE", "您没有填写过日常数据");
            }
        }
    }

    public int updateByPrimaryKeySelective(Richang6s record) {
        return riChang6sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Richang6s record) {
        return riChang6sMapper.updateByPrimaryKey(record);
    }
}