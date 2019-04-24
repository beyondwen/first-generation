package com.amchis.firstgeneration.mapper.guanli.appbanben21s;

import com.amchis.firstgeneration.bean.guanli.appbanben21s.AppBanBen21s;
import org.springframework.stereotype.Repository;

@Repository
public interface AppBanBen21sMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppBanBen21s record);

    int insertSelective(AppBanBen21s record);

    AppBanBen21s selectByPrimaryKey(Integer id);
    AppBanBen21s getAppUpdate();

    int updateByPrimaryKeySelective(AppBanBen21s record);

    int updateByPrimaryKey(AppBanBen21s record);
}