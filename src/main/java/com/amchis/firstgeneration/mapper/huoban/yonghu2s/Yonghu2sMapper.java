package com.amchis.firstgeneration.mapper.huoban.yonghu2s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.amchis.firstgeneration.bean.huoban.yonghu2s.Yonghu2s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Yonghu2sMapper extends BaseMapper<Yonghu2s> {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghu2s record);

    int insertSelective(Yonghu2s record);

    Yonghu2s selectByPrimaryKey(Integer id);

    List<Yonghu2s> ChaxunZhuguanKehu();

    List<Yonghu2s> ChaxunGuanjiayonghu(@Param("guanjiawaijian") String guanjiawaijian, @Param("shoujihao") String shoujihao);
    Yonghu2s ChaxunGuanjiayonghuByWaijian(@Param("guanjiawaijian") String guanjiawaijian);

    List<Yonghu2s> getAll();

    int updateByPrimaryKeySelective(Yonghu2s record);

    int updateByPrimaryKey(Yonghu2s record);
}