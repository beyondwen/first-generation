package com.amchis.firstgeneration.mapper.guanli.jiyinjiance20s;

import com.amchis.firstgeneration.bean.guanli.jiyinjiance20s.JiYinJianCe20s;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiYinJianCe20sMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiYinJianCe20s record);

    int insertSelective(JiYinJianCe20s record);

    JiYinJianCe20s selectByPrimaryKey(Integer id);

    List<JiYinJianCe20s> selectJiYinJianCe();

    int updateByPrimaryKeySelective(JiYinJianCe20s record);

    int updateByPrimaryKey(JiYinJianCe20s record);
}