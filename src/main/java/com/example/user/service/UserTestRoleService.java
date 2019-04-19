package com.example.user.service;

import com.baomidou.framework.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.user.dao.IUserTestRoleMapper;
import com.example.user.domain.po.UserRoleTestBase;
import com.example.user.domain.vo.UserTestRoleVo;
import org.hibernate.validator.constraints.SafeHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTestRoleService extends ServiceImpl<IUserTestRoleMapper, UserRoleTestBase> {
	Logger logger = LoggerFactory.getLogger(UserTestRoleService.class);

	@Autowired
	private IUserTestRoleMapper testRoleMapper;


	/*
	*
	* 查询角色
	* */
	public UserRoleTestBase selectRoleById(Integer id){
		return testRoleMapper.getRole(id);
	}

	/*
	* 根据userid查询角色
	* */
	public ArrayList<UserRoleTestBase> userRoleByUserId(Integer id){
		logger.info("user id ======"+id.toString());
		return testRoleMapper.getRoleByUserId(id);
	}


	/*
	* 设置角色
	* */
	public void setRole1(UserTestRoleVo user){
	if (user.getRole_name()!=null){

		try {
			UserRoleTestBase userRole = new UserRoleTestBase();
			userRole.setRoleName(user.getRole_name());
			userRole = this.selectOne(new EntityWrapper<>(userRole)); //返回一个实体对象
			//userRole.setRoleID(user.getRoleID());
			userRole.setRoleDepartment(user.getRole_department());
			userRole.setRoleUserID(user.getUserID());
			userRole.setRoleId(user.getRoleId());
			userRole.setRoleName(user.getRole_name());
//			baseMapper.insert(userRole);             //通过mybatis的方式插入数据库
			logger.info("roleID"+user.getRoleId()+"roleName"+user.getRole_name()+"role_department"+user.getRole_department()+"userID"+user.getUserID());
			//testRoleMapper.setUserRole(user.getRoleId(),user.getRole_name(),user.getRole_department(),user.getUserID());
            testRoleMapper.setUserRoleObj(userRole);
		}catch(Exception e){
			logger.error(e.toString());
		}
	}
}
    /*
     * 根据userId删除Role
     */
    public Integer deleteByUserId(Integer userId){
    testRoleMapper.deleteRoleByUserId(userId);

    return userId;
    }

}
