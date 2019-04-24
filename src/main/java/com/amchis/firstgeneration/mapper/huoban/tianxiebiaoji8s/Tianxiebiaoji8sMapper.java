package com.amchis.firstgeneration.mapper.huoban.tianxiebiaoji8s;

import com.amchis.firstgeneration.bean.huoban.tianxiebiaoji8s.Tianxiebiaoji8s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tianxiebiaoji8sMapper extends BaseMapper<Tianxiebiaoji8s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Tianxiebiaoji8s record);

    int insertSelective(Tianxiebiaoji8s record);

    Tianxiebiaoji8s selectByPrimaryKey(Integer id);

    List<Tianxiebiaoji8s> getAll();

    int updateByPrimaryKeySelective(Tianxiebiaoji8s record);

    int updateByPrimaryKey(Tianxiebiaoji8s record);
}