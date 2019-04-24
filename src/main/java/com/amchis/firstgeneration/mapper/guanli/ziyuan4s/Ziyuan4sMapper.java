package com.amchis.firstgeneration.mapper.guanli.ziyuan4s;

import com.amchis.firstgeneration.bean.guanli.ziyuan4s.Ziyuan4s;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ziyuan4sMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ziyuan4s record);

    int insertSelective(Ziyuan4s record);

    Ziyuan4s selectByPrimaryKey(Integer id);

    List<Ziyuan4s> selectZyByYonghuwaijian(String yonghuwaijian);

    int updateByPrimaryKeySelective(Ziyuan4s record);

    int updateByPrimaryKey(Ziyuan4s record);
}