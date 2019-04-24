package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.appbanben21s.AppBanBen21s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.appbanben21s.AppBanBen21sMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppBanBen21sService extends BaseApiService<AppBanBen21s> {

    @Autowired
    private AppBanBen21sMapper appBanBen21sMapper;

    public int deleteByPrimaryKey(Integer id) {
        return appBanBen21sMapper.deleteByPrimaryKey(id);
    }

    public int insert(AppBanBen21s record) {
        return appBanBen21sMapper.insert(record);
    }

    public int insertSelective(AppBanBen21s record) {
        return appBanBen21sMapper.insertSelective(record);
    }

    public AppBanBen21s selectByPrimaryKey(Integer id) {
        return appBanBen21sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo getAppUpdate() {
        AppBanBen21s appUpdate = appBanBen21sMapper.getAppUpdate();
        List<AppBanBen21s> appBanBen21s = new ArrayList<>();
        return setResult("1",appBanBen21s);
    }

    public int updateByPrimaryKeySelective(AppBanBen21s record) {
        return appBanBen21sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AppBanBen21s record) {
        return appBanBen21sMapper.updateByPrimaryKey(record);
    }
}
