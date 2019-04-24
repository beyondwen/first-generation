package com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s;

import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BangDingKongZhiQi15sMapper extends BaseMapper<BangDingKongZhiQi15s> {
    int deleteByPrimaryKey(Integer id);

    int insert(BangDingKongZhiQi15s record);

    int insertSelective(BangDingKongZhiQi15s record);

    BangDingKongZhiQi15s selectByPrimaryKey(Integer id);

    BangDingKongZhiQi15s selectByPhone(String shoujihao);

    List<BangDingKongZhiQi15s> getAll();

    int updateByPrimaryKeySelective(BangDingKongZhiQi15s record);

    int updateByPrimaryKey(BangDingKongZhiQi15s record);
}