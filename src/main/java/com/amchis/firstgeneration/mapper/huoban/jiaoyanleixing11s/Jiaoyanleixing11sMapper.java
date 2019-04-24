package com.amchis.firstgeneration.mapper.huoban.jiaoyanleixing11s;

import com.amchis.firstgeneration.bean.huoban.jiaoyanleixing11s.Jiaoyanleixing11s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Jiaoyanleixing11sMapper extends BaseMapper<Jiaoyanleixing11s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaoyanleixing11s record);

    int insertSelective(Jiaoyanleixing11s record);

    Jiaoyanleixing11s selectByPrimaryKey(Integer id);

    List<Jiaoyanleixing11s> getAll();

    int updateByPrimaryKeySelective(Jiaoyanleixing11s record);

    int updateByPrimaryKey(Jiaoyanleixing11s record);
}