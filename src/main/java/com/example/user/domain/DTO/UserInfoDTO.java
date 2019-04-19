package com.example.user.domain.DTO;

public class UserInfoDTO {

    /*
    * 用户信息
    * */
    private Integer user_id;
    private String user_name;
    private String user_password;
    /*
    * 角色信息  里面的userid  对应用户信息里面的 user_id
    * */
    private Integer role_id;
    private String role_name;
    private String role_dep;
  //  private Integer userId;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_dep() {
        return role_dep;
    }

    public void setRole_dep(String role_dep) {
        this.role_dep = role_dep;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
}
