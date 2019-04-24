package com.amchis.firstgeneration.mapper.huoban.gl1he4s;

import com.amchis.firstgeneration.bean.huoban.gl1he4s.Gl1He4s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gl1He4sMapper extends BaseMapper<Gl1He4s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Gl1He4s record);

    int insertSelective(Gl1He4s record);

    Gl1He4s selectByPrimaryKey(Integer id);

    List<Gl1He4s> getAll();

    int updateByPrimaryKeySelective(Gl1He4s record);

    int updateByPrimaryKey(Gl1He4s record);
}