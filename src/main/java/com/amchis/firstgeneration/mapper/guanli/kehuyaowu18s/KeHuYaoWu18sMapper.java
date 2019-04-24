package com.amchis.firstgeneration.mapper.guanli.kehuyaowu18s;

import com.amchis.firstgeneration.bean.guanli.kehuyaowu18s.KeHuYaoWu18s;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHuYaoWu18sMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeHuYaoWu18s record);

    int insertSelective(KeHuYaoWu18s record);

    KeHuYaoWu18s selectByPrimaryKey(Integer id);

    List<KeHuYaoWu18s> selectByYonghuwaijian(String yonghuwaijian);

    int updateByPrimaryKeySelective(KeHuYaoWu18s record);

    int updateByPrimaryKey(KeHuYaoWu18s record);
}