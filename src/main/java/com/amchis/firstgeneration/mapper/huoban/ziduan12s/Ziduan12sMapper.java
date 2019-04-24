package com.amchis.firstgeneration.mapper.huoban.ziduan12s;

import com.amchis.firstgeneration.bean.huoban.ziduan12s.Ziduan12s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ziduan12sMapper extends BaseMapper<Ziduan12s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Ziduan12s record);

    int insertSelective(Ziduan12s record);

    Ziduan12s selectByPrimaryKey(Integer id);

    List<Ziduan12s> getAll();

    int updateByPrimaryKeySelective(Ziduan12s record);

    int updateByPrimaryKey(Ziduan12s record);
}