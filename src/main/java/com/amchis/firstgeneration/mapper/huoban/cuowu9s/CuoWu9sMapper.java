package com.amchis.firstgeneration.mapper.huoban.cuowu9s;

import com.amchis.firstgeneration.bean.huoban.cuowu9s.CuoWu9s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuoWu9sMapper extends BaseMapper<CuoWu9s> {
    int deleteByPrimaryKey(Integer id);

    int insert(CuoWu9s record);

    int insertSelective(CuoWu9s record);

    CuoWu9s selectByPrimaryKey(Integer id);

    List<CuoWu9s> getAll();

    int updateByPrimaryKeySelective(CuoWu9s record);

    int updateByPrimaryKey(CuoWu9s record);
}