package com.amchis.firstgeneration.mapper.huoban.tijian5s;

import com.amchis.firstgeneration.bean.huoban.tijian5s.Tijian5s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tijian5sMapper extends BaseMapper<Tijian5s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Tijian5s record);

    int insertSelective(Tijian5s record);

    Tijian5s selectByPrimaryKey(Integer id);

    Tijian5s selectByshujuriAndWaijian(@Param("shujuriqi") String shujuriqi,@Param("waijian") String waijian);

    List<Tijian5s> getAll();

    String ChaxunGerenZuizaoTijian(@Param("waijian") String waijian);

    int updateByPrimaryKeySelective(Tijian5s record);

    int updateByPrimaryKey(Tijian5s record);
}