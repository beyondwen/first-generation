package com.amchis.firstgeneration.mapper.huoban.ziyuan4s;

import com.amchis.firstgeneration.bean.huoban.ziyuan4s.Ziyuan4s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ziyuan4sMapper extends BaseMapper<Ziyuan4s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Ziyuan4s record);

    int insertSelective(Ziyuan4s record);

    Ziyuan4s selectByPrimaryKey(Integer id);

    List<Ziyuan4s> getAll();

    int updateByPrimaryKeySelective(Ziyuan4s record);

    int updateByPrimaryKey(Ziyuan4s record);
}