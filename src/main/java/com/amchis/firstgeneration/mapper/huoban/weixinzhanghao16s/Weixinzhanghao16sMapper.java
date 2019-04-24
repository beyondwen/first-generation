package com.amchis.firstgeneration.mapper.huoban.weixinzhanghao16s;

import com.amchis.firstgeneration.bean.huoban.weixinzhanghao16s.Weixinzhanghao16s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Weixinzhanghao16sMapper extends BaseMapper<Weixinzhanghao16s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Weixinzhanghao16s record);

    int insertSelective(Weixinzhanghao16s record);

    Weixinzhanghao16s selectByPrimaryKey(Integer id);

    List<Weixinzhanghao16s> getAll();

    int updateByPrimaryKeySelective(Weixinzhanghao16s record);

    int updateByPrimaryKey(Weixinzhanghao16s record);
}