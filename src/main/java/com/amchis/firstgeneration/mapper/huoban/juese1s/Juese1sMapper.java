package com.amchis.firstgeneration.mapper.huoban.juese1s;

import com.amchis.firstgeneration.bean.huoban.juese1s.Juese1s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Juese1sMapper extends BaseMapper<Juese1s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Juese1s record);

    int insertSelective(Juese1s record);

    Juese1s selectByPrimaryKey(Integer id);

    List<Juese1s> getAll();

    int updateByPrimaryKeySelective(Juese1s record);

    int updateByPrimaryKey(Juese1s record);
}