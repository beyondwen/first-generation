package com.amchis.firstgeneration.mapper.guanli.kehuyaowu18s;

import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18;
import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHuYaoWu18sMapper extends BaseMapper<Kehuyaowu18s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Kehuyaowu18s record);

    int insertSelective(Kehuyaowu18s record);

    Kehuyaowu18s selectByPrimaryKey(Integer id);

    String ChaxunGerenZuixinYaowu(@Param("waijian") String waijian);

    List<Kehuyaowu18s> ChaxunGerenZuixinYaowu1(@Param("shujuriqi") String shujuriqi, @Param("waijian") String waijian);

    List<Kehuyaowu18s> ChaxunAppKehuyaowu(@Param("waijian") String waijian);
    List<Kehuyaowu18> ChaxunAppKehuyaowu4kehuyaowu(@Param("waijian") String waijian);

    List<Kehuyaowu18s> selectByYonghuwaijian(String yonghuwaijian);

    int updateByPrimaryKeySelective(Kehuyaowu18s record);

    int updateByPrimaryKey(Kehuyaowu18s record);

    List<Kehuyaowu18s> getAll();
}