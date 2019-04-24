package com.amchis.firstgeneration.mapper.guanli.role;

import com.amchis.firstgeneration.bean.guanli.role.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role selectRoleByYonghuwaijian(String yonghuwaijian);
}