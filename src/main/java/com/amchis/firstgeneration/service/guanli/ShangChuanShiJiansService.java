package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShangChuanShiJians;
import com.amchis.firstgeneration.mapper.guanli.shangchuanshijians.ShangChuanShiJiansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShangChuanShiJiansService  {

    @Autowired
    private ShangChuanShiJiansMapper shangChuanShiJiansMapper;

    public int deleteByPrimaryKey(Integer id) {
        return shangChuanShiJiansMapper.deleteByPrimaryKey(id);
    }

    public int insert(ShangChuanShiJians record) {
        return shangChuanShiJiansMapper.insert(record);
    }

    public int insertSelective(ShangChuanShiJians record) {
        return shangChuanShiJiansMapper.insertSelective(record);
    }

    public ShangChuanShiJians selectByPrimaryKey(Integer id) {
        return shangChuanShiJiansMapper.selectByPrimaryKey(id);
    }



    public int updateByPrimaryKeySelective(ShangChuanShiJians record) {
        return shangChuanShiJiansMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ShangChuanShiJians record) {
        return shangChuanShiJiansMapper.updateByPrimaryKey(record);
    }
}
