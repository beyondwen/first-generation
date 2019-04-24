package com.amchis.firstgeneration.mapper.huoban.jiaoyan10s;

import com.amchis.firstgeneration.bean.huoban.jiaoyan10s.JiaoYan10s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiaoYan10sMapper extends BaseMapper<JiaoYan10s> {
    int deleteByPrimaryKey(Integer id);

    int insert(JiaoYan10s record);

    int insertSelective(JiaoYan10s record);

    JiaoYan10s selectByPrimaryKey(Integer id);

    List<JiaoYan10s> getAll();

    int updateByPrimaryKeySelective(JiaoYan10s record);

    int updateByPrimaryKey(JiaoYan10s record);
}