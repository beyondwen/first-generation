package com.amchis.firstgeneration.mapper.huoban.gl12he13s;

import com.amchis.firstgeneration.bean.huoban.gl12he13s.Gl12He13s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gl12He13sMapper extends BaseMapper<Gl12He13s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Gl12He13s record);

    int insertSelective(Gl12He13s record);

    Gl12He13s selectByPrimaryKey(Integer id);

    List<Gl12He13s> getAll();

    int updateByPrimaryKeySelective(Gl12He13s record);

    int updateByPrimaryKey(Gl12He13s record);
}