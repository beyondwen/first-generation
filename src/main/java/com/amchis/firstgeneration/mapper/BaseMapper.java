package com.amchis.firstgeneration.mapper;

import com.amchis.firstgeneration.bean.BaseBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseMapper<T extends BaseBean> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    BaseBean selectByPrimaryKey(Integer id);

    List<T> getAll();

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
