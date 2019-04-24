package com.amchis.firstgeneration.mapper.guanli.user;

import com.amchis.firstgeneration.bean.guanli.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByName(String gonghao);

    User findByPhone(String shoujihao);




}