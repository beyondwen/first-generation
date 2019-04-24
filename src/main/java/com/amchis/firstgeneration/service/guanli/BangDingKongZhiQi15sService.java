package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangDingKongZhiQi15sService {

    @Autowired
    private BangDingKongZhiQi15sMapper bangDingKongZhiQi15sMapper;

    public int deleteByPrimaryKey(Integer id) {
        return bangDingKongZhiQi15sMapper.deleteByPrimaryKey(id);
    }

    public int insert(BangDingKongZhiQi15s record) {
        return bangDingKongZhiQi15sMapper.insert(record);
    }

    public int insertSelective(BangDingKongZhiQi15s record) {
        return bangDingKongZhiQi15sMapper.insertSelective(record);
    }

    public BangDingKongZhiQi15s selectByPrimaryKey(Integer id) {
        return bangDingKongZhiQi15sMapper.selectByPrimaryKey(id);
    }

    public BangDingKongZhiQi15s selectByPhone(String shoujihao) {
        return bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
    }

    public int updateByPrimaryKeySelective(BangDingKongZhiQi15s record) {
        return bangDingKongZhiQi15sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(BangDingKongZhiQi15s record) {
        return bangDingKongZhiQi15sMapper.updateByPrimaryKey(record);
    }

    public List<BangDingKongZhiQi15s> getAll() {
        return bangDingKongZhiQi15sMapper.getAll();
    }
}
