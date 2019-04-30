package com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s;

import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sforBindUser;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BangDingKongZhiQi15sMapper extends BaseMapper<BangDingKongZhiQi15s> {
    int deleteByPrimaryKey(Integer id);

    int insert(BangDingKongZhiQi15s record);

    int insertSelective(BangDingKongZhiQi15s record);

    int insertSelective4BindUser(BangDingKongZhiQi15sforBindUser record);

    BangDingKongZhiQi15s selectByPrimaryKey(Integer id);

    BangDingKongZhiQi15s selectBySnOrWifiName(@Param("deviceSn") String deviceSn, @Param("wifiName") String wifiName);

    BangDingKongZhiQi15s selectByPhone(@Param("shoujihao") String shoujihao);

    List<BangDingKongZhiQi15s> getAll();

    List<BangDingKongZhiQi15s> ChaxunYibangding(@Param("biaoji") String biaoji);

    BangDingKongZhiQi15s ChaxunGuanjiaWifi(@Param("biaoji") String biaoji, @Param("WifimingChaxun") String WifimingChaxun, @Param("LiushuihaoChaxun") String LiushuihaoChaxun);

    BangDingKongZhiQi15s getByWifiNameOrSN(@Param("WifimingChaxun") String WifimingChaxun, @Param("LiushuihaoChaxun") String LiushuihaoChaxun, @Param("shoujihao") String shoujihao);

    int updateByPrimaryKeySelective(BangDingKongZhiQi15s record);

    int updateByPrimaryKeySelective4BindUser(BangDingKongZhiQi15sforBindUser record);

    int updateByPrimaryKey(BangDingKongZhiQi15s record);


}