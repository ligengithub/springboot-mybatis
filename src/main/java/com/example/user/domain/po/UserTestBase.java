package com.example.user.domain.po;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

//  测试  用户
@TableName("ligen_test")
public class UserTestBase {
	/** 主键 */
	@TableId(type = IdType.AUTO)
	private Integer id;



    @TableField(value = "login_name")
    private String name;



    @TableField(value = "login_password")
    private String password;



    private UserRoleTestBase userRoleTestBase;

    public UserRoleTestBase getUserRoleTestBase() {
        return userRoleTestBase;
    }

    public void setUserRoleTestBase(UserRoleTestBase userRoleTestBase) {
        this.userRoleTestBase = userRoleTestBase;
    }

    public Integer getId() {
        return id;
    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
