package com.example.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.user.domain.po.UserRoleTestBase;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface IUserTestRoleMapper extends BaseMapper<UserRoleTestBase> {


    public UserRoleTestBase getRole(Integer id);    //根据role_id拿到role
    public ArrayList<UserRoleTestBase> getRoleByUserId(Integer id);  // 根据Userid拿到role

    public void setUserRole(@Param("roleId") Integer role_id, @Param("roleName") String role_name,
                            @Param("roleDep") String role_department, @Param("userId") Integer userID);

    public void setUserRoleObj(UserRoleTestBase userRole);
    public void updateUserRole(@Param("roleId") Integer role_id, @Param("roleName") String role_name,
                               @Param("roleDep") String role_department, @Param("userId") Integer userID);

    public void deleteRoleByUserId(Integer userId);
}
