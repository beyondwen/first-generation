package com.amchis.firstgeneration.mapper;

import com.amchis.firstgeneration.bean.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseMapperImpl<T extends BaseBean> {

    @Autowired
    private BaseMapper<T> baseMapper;

    public int deleteByPrimaryKey(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int insert(T record) {
        return baseMapper.insert(record);
    }

    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    public BaseBean selectByPrimaryKey(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    public List<T> getAll() {
        return baseMapper.getAll();
    }

    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}
