package com.amchis.firstgeneration.mapper.huoban.kehuyaowu18s;

import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Kehuyaowu18sMapper extends BaseMapper<Kehuyaowu18s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Kehuyaowu18s record);

    int insertSelective(Kehuyaowu18s record);

    Kehuyaowu18s selectByPrimaryKey(Integer id);

    List<Kehuyaowu18s> getAll();

    int updateByPrimaryKeySelective(Kehuyaowu18s record);

    int updateByPrimaryKey(Kehuyaowu18s record);
}