package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.jiyinjiance20s.JiYinJianCe20s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.jiyinjiance20s.JiYinJianCe20sMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiYinJianCe20sService extends BaseApiService<JiYinJianCe20s> {

    @Autowired
    private JiYinJianCe20sMapper jiYinJianCe20sMapper;

    public int deleteByPrimaryKey(Integer id) {
        return jiYinJianCe20sMapper.deleteByPrimaryKey(id);
    }

    public int insert(JiYinJianCe20s record) {
        return jiYinJianCe20sMapper.insert(record);
    }

    public int insertSelective(JiYinJianCe20s record) {
        return jiYinJianCe20sMapper.insertSelective(record);
    }

    public JiYinJianCe20s selectByPrimaryKey(Integer id) {
        return jiYinJianCe20sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo selectJiYinJianCe(String jueseBianma) {
        if (!"JIYIN_JIANCE".equals(jueseBianma)) {
            return setResult("0", "WUQUAN_CHAKAN", "您无权查看基因检测结果");
        } else {
            List<JiYinJianCe20s> jiYinJianCe20s = jiYinJianCe20sMapper.selectJiYinJianCe();
            return setResult("1", jiYinJianCe20s);
        }
    }

    public int updateByPrimaryKeySelective(JiYinJianCe20s record) {
        return jiYinJianCe20sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(JiYinJianCe20s record) {
        return jiYinJianCe20sMapper.updateByPrimaryKey(record);
    }
}
