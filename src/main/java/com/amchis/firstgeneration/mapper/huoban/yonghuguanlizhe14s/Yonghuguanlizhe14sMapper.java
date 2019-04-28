package com.amchis.firstgeneration.mapper.huoban.yonghuguanlizhe14s;

import com.amchis.firstgeneration.bean.huoban.yonghuguanlizhe14s.Yonghuguanlizhe14s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Yonghuguanlizhe14sMapper extends BaseMapper<Yonghuguanlizhe14s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghuguanlizhe14s record);

    int insertSelective(Yonghuguanlizhe14s record);

    Yonghuguanlizhe14s selectByPrimaryKey(Integer id);

    Yonghuguanlizhe14s selectByWaijianAndGuanjiaWaijian(@Param("waijian") String waijian,@Param("guanjiawaijian") String guanjiawajian);

    List<Yonghuguanlizhe14s> getAll();

    int updateByPrimaryKeySelective(Yonghuguanlizhe14s record);

    int updateByPrimaryKey(Yonghuguanlizhe14s record);
}