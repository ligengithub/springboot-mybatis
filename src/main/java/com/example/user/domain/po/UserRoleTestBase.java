package com.example.user.domain.po;


import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("ligen_test_role")
public class UserRoleTestBase {



    @TableId(type= IdType.AUTO)
    private Integer roleId;

    @TableField("role_name")
    private String roleName;

    @TableField("role_department")
    private String roleDepartment;

    @TableField("userid")
    private Integer roleUserID;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDepartment() {
        return roleDepartment;
    }

    public void setRoleDepartment(String roleDepartment) {
        this.roleDepartment = roleDepartment;
    }

    public Integer getRoleUserID() {
        return roleUserID;
    }

    public void setRoleUserID(Integer roleUserID) {
        this.roleUserID = roleUserID;
    }
}
