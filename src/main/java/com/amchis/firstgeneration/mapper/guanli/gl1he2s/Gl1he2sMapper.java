package com.amchis.firstgeneration.mapper.guanli.gl1he2s;

import com.amchis.firstgeneration.bean.guanli.gl1he2s.Gl1he2s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gl1he2sMapper extends BaseMapper<Gl1he2s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Gl1he2s record);

    int insertSelective(Gl1he2s record);

    Gl1he2s selectByPrimaryKey(Integer id);
    
    List<Gl1he2s> getAll();

    int updateByPrimaryKeySelective(Gl1he2s record);

    int updateByPrimaryKey(Gl1he2s record);
}