package com.amchis.firstgeneration.mapper.huoban.richang6s;

import com.amchis.firstgeneration.bean.huoban.richang6s.Richang6s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Richang6sMapper extends BaseMapper<Richang6s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Richang6s record);

    int insertSelective(Richang6s record);

    Richang6s selectByPrimaryKey(Integer id);

    List<Richang6s> getAll();

    int updateByPrimaryKeySelective(Richang6s record);

    int updateByPrimaryKey(Richang6s record);
}