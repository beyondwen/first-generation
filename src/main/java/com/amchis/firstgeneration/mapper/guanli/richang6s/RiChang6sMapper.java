package com.amchis.firstgeneration.mapper.guanli.richang6s;

import com.amchis.firstgeneration.bean.guanli.richang6s.RiChang6s;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiChang6sMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RiChang6s record);

    int insertSelective(RiChang6s record);

    RiChang6s selectByPrimaryKey(Integer id);

    List<RiChang6s> ChaxunAppSuoyouRichangRiqi(String yonghuwaijian);

    int updateByPrimaryKeySelective(RiChang6s record);

    int updateByPrimaryKey(RiChang6s record);
}