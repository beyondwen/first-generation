package com.amchis.firstgeneration.mapper.huoban.jiankangwenjuan7s;

import com.amchis.firstgeneration.bean.huoban.jiankangwenjuan7s.JianKangWenJuan7s;
import com.amchis.firstgeneration.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JianKangWenJuan7sMapper extends BaseMapper<JianKangWenJuan7s> {
    int deleteByPrimaryKey(Integer id);

    int insert(JianKangWenJuan7s record);

    int insertSelective(JianKangWenJuan7s record);

    JianKangWenJuan7s selectByPrimaryKey(Integer id);

    List<JianKangWenJuan7s> getAll();

    int updateByPrimaryKeySelective(JianKangWenJuan7s record);

    int updateByPrimaryKey(JianKangWenJuan7s record);
}