package com.amchis.firstgeneration.mapper.guanli.password;

import com.amchis.firstgeneration.bean.guanli.password.Password;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer id);

    Password selectByPasswordAndWaijian(String yonghuwaijian,String jiaoyanzhi);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);
}