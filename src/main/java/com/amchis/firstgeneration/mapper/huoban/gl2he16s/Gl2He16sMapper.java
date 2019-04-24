package com.amchis.firstgeneration.mapper.huoban.gl2he16s;

import com.amchis.firstgeneration.bean.huoban.gl2he16s.Gl2He16s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gl2He16sMapper extends BaseMapper<Gl2He16s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Gl2He16s record);

    int insertSelective(Gl2He16s record);

    Gl2He16s selectByPrimaryKey(Integer id);

    List<Gl2He16s> getAll();

    int updateByPrimaryKeySelective(Gl2He16s record);

    int updateByPrimaryKey(Gl2He16s record);
}