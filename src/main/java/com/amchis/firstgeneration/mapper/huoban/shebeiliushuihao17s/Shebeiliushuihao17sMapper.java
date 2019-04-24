package com.amchis.firstgeneration.mapper.huoban.shebeiliushuihao17s;

import com.amchis.firstgeneration.bean.huoban.shebeiliushuihao17s.Shebeiliushuihao17s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Shebeiliushuihao17sMapper extends BaseMapper<Shebeiliushuihao17s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiliushuihao17s record);

    int insertSelective(Shebeiliushuihao17s record);

    Shebeiliushuihao17s selectByPrimaryKey(Integer id);

    List<Shebeiliushuihao17s> getAll();

    int updateByPrimaryKeySelective(Shebeiliushuihao17s record);

    int updateByPrimaryKey(Shebeiliushuihao17s record);
}