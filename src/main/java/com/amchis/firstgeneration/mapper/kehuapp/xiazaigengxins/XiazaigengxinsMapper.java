package com.amchis.firstgeneration.mapper.kehuapp.xiazaigengxins;

import com.amchis.firstgeneration.bean.kehuapp.xiazaigengxins.Xiazaigengxins;
import org.springframework.stereotype.Repository;

@Repository
public interface XiazaigengxinsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiazaigengxins record);

    int insertSelective(Xiazaigengxins record);

    Xiazaigengxins selectByPrimaryKey(Integer id);
    Xiazaigengxins selectByXuliehao(String xuliehao);

    int updateByPrimaryKeySelective(Xiazaigengxins record);

    int updateByPrimaryKey(Xiazaigengxins record);
}