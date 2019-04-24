package com.amchis.firstgeneration.mapper.huoban.gl13he13s;

import com.amchis.firstgeneration.bean.huoban.gl13he13s.Gl13He13s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gl13He13sMapper extends BaseMapper<Gl13He13s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Gl13He13s record);

    int insertSelective(Gl13He13s record);

    Gl13He13s selectByPrimaryKey(Integer id);

    List<Gl13He13s> getAll();

    int updateByPrimaryKeySelective(Gl13He13s record);

    int updateByPrimaryKey(Gl13He13s record);
}