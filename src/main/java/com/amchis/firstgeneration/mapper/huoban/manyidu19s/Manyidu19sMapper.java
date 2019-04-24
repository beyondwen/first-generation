package com.amchis.firstgeneration.mapper.huoban.manyidu19s;

import com.amchis.firstgeneration.bean.huoban.manyidu19s.Manyidu19s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Manyidu19sMapper extends BaseMapper<Manyidu19s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Manyidu19s record);

    int insertSelective(Manyidu19s record);

    Manyidu19s selectByPrimaryKey(Integer id);

    List<Manyidu19s> getAll();

    int updateByPrimaryKeySelective(Manyidu19s record);

    int updateByPrimaryKey(Manyidu19s record);
}