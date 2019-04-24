package com.amchis.firstgeneration.mapper.huoban.mokuai13s;

import com.amchis.firstgeneration.bean.huoban.mokuai13s.Mokuai13s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mokuai13sMapper extends BaseMapper<Mokuai13s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Mokuai13s record);

    int insertSelective(Mokuai13s record);

    Mokuai13s selectByPrimaryKey(Integer id);

    List<Mokuai13s> getAll();

    int updateByPrimaryKeySelective(Mokuai13s record);

    int updateByPrimaryKey(Mokuai13s record);
}