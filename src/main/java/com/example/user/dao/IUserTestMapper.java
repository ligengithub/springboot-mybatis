package com.example.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.user.domain.po.UserTestBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserTestMapper extends BaseMapper<UserTestBase> {

//    public UserTestBase getUserById(Integer id);
//   // public void InsertUser(UserTestBase user);
   public Integer deleteUserById(Integer id);
   public UserTestBase selectUserById(Integer id);
   public UserTestBase selectUserByName(String name);   // 根据名字查询
   public void  addUserById(@Param("Id") Integer id,@Param("name") String name, @Param("password")String password); //错误写法
   public void updateUser(@Param("userId") Integer id, @Param("userName") String loggin_name,
                              @Param("userPassword") String loggin_password);
   public List<UserTestBase> selectAllUser();

}
