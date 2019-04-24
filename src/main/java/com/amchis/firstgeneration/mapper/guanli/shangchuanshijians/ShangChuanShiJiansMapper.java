package com.amchis.firstgeneration.mapper.guanli.shangchuanshijians;

import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShangChuanShiJians;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShangChuanShiJiansMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShangChuanShiJians record);

    int insertSelective(ShangChuanShiJians record);

    ShangChuanShiJians selectByPrimaryKey(Integer id);
    List<ShangChuanShiJians>  selectByXuliehao(String s);

    int updateByPrimaryKeySelective(ShangChuanShiJians record);

    int updateByPrimaryKey(ShangChuanShiJians record);
}