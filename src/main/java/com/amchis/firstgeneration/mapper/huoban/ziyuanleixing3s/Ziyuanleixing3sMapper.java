package com.amchis.firstgeneration.mapper.huoban.ziyuanleixing3s;

import com.amchis.firstgeneration.bean.huoban.ziyuanleixing3s.Ziyuanleixing3s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ziyuanleixing3sMapper extends BaseMapper<Ziyuanleixing3s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Ziyuanleixing3s record);

    int insertSelective(Ziyuanleixing3s record);

    Ziyuanleixing3s selectByPrimaryKey(Integer id);

    List<Ziyuanleixing3s> getAll();

    int updateByPrimaryKeySelective(Ziyuanleixing3s record);

    int updateByPrimaryKey(Ziyuanleixing3s record);
}