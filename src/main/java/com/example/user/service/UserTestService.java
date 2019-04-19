package com.example.user.service;

import com.baomidou.framework.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.user.dao.IUserTestMapper;
import com.example.user.dao.IUserTestRoleMapper;
import com.example.user.domain.DTO.UserInfoDTO;
import com.example.user.domain.po.*;
import com.example.user.domain.vo.UserTestRoleVo;
import com.example.user.domain.vo.UserVo;
import com.example.user.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserTestService extends ServiceImpl<IUserTestMapper, UserTestBase> {


    private Logger logger = LoggerFactory.getLogger(UserTestService.class);


    @Autowired
    private IUserTestMapper testMapper;
    @Autowired
    private IUserTestRoleMapper testRoleMapper;

//public void

    /*
     * 根据id查询用户角色
     * */
    public UserTestBase selectById(Integer id) {

        return testMapper.selectUserById(id);
    }

    /*
     * 添加用户  id为自动增长 赋值null
     * */
    public Integer addUser(UserVo user) {

        testMapper.addUserById(user.getId(), user.getName(), user.getPassword());

        return user.getId();
    }

    /*
     * 根据id删除用户
     * */
    public Integer deleteUserById(Integer id) {

        return testMapper.deleteUserById(id);
    }


    /*
     * 根据id查role
     * */
    public UserInfoDTO selectUserInfo(Integer id) {
        UserInfoDTO dto = new UserInfoDTO();
        try {
            // 兴建一个UserInfoDto

            dto.setUser_id(testMapper.selectUserById(id).getId());
            dto.setUser_name(testMapper.selectUserById(id).getName());
            dto.setUser_password(testMapper.selectUserById(id).getPassword());
            dto.setRole_id(testRoleMapper.getRoleByUserId(id).get(0).getRoleId());
            dto.setRole_name(testRoleMapper.getRoleByUserId(id).get(0).getRoleName());
            dto.setRole_dep(testRoleMapper.getRoleByUserId(id).get(0).getRoleDepartment());
//            dto.setUser_id(testRoleMapper.getRoleByUserId(id).get(0).getRoleUserID());


            //  logger.info("role_name="+user.getRole_name()+"role_department="+user.getRole_department()+"usetid="+user.getUserID());
        } catch (Exception e) {
            logger.info(e.toString());
        }


        return dto;
    }

    public Integer setUserRole(UserTestRoleVo vo) {
        UserRoleTestBase uo = new UserRoleTestBase();
        UserRoleTestBase uotest = new UserRoleTestBase();

        if (vo.getUserID() != null) {

            try {
                // 检查该用户是否已经有role  没有的insert 否则 alter
//                try {
//                    uotest = testRoleMapper.getRoleByUserId(vo.getUserID()).get(0);
//                }catch (IndexOutOfBoundsException e){
//
//                }


                if (testRoleMapper.getRoleByUserId(vo.getUserID()).get(0).getRoleName() != null) {
                    // alter
                    logger.info("开始更改角色");
//                    uo.setRoleId(null);
//                    uo.setRoleName(vo.getRole_name());
//                    uo.setRoleDepartment(vo.getRole_department());
//                    uo.setRoleUserID(vo.getUserID());
//                    testRoleMapper.updateById(uo);
                    /*
                     * 参数传递
                     * */
                    testRoleMapper.updateUserRole(vo.getRoleId(), vo.getRole_name(), vo.getRole_department(), vo.getUserID());

                    logger.info("更改角色完毕");
                } else {
                    // insert
                    logger.info("开始插入角色");
//                    uo.setRoleId(null);
//                    uo.setRoleName(vo.getRole_name());
//                    uo.setRoleDepartment(vo.getRole_department());
//                    uo.setRoleUserID(vo.getUserID());
//                    //传递对象
//                    testRoleMapper.insert(uo);
                    testRoleMapper.setUserRole(vo.getRoleId(), vo.getRole_name(), vo.getRole_department(), vo.getUserID());
                    logger.info("插入角色完毕");
                }


            } catch (Exception e) {


                // role 表里面没有该元素 插入元素
                logger.info(e.toString());
                logger.info("开始插入角色");
//                    uo.setRoleId(null);
//                    uo.setRoleName(vo.getRole_name());
//                    uo.setRoleDepartment(vo.getRole_department());
//                    uo.setRoleUserID(vo.getUserID());
//                    //传递对象
//                    testRoleMapper.insert(uo);
                testRoleMapper.setUserRole(vo.getRoleId(), vo.getRole_name(), vo.getRole_department(), vo.getUserID());
                logger.info("插入角色完毕");
            }

        }


        return null;
    }


//	*/
//	* 增加用户或者修改用户
//	*

    public void saveOfUpdate(UserInfoDTO dto) {
        //创建一个user的po和role的po
        UserTestBase upo = new UserTestBase();
        UserRoleTestBase rpo = new UserRoleTestBase();
        // 先判断User中有没有这个user  有的话update 没有则 insert
        try {
            Integer id = testMapper.selectUserByName(dto.getUser_name()).getId();  // 查询是否有该用户的id
            logger.info("查询结果为" + id);
            if (id != null) {
                //  有用户  则修改
                logger.info("用户已经存在正在修改");
//                upo.setName(dto.getUser_name());
//                upo.setPassword(dto.getUser_password());
                testMapper.updateUser(id,dto.getUser_name(),dto.getUser_password());  //id 是根据用户名查出来的id
                //判断是否包含role信息  如果是设置role，如果不是则不设置role
                if(dto.getRole_name()!=null&&dto.getRole_dep()!=null){
                    logger.info("正在修改role为"+dto.getRole_name()+"----"+dto.getRole_dep());
                 testRoleMapper.updateUserRole(dto.getRole_id(),dto.getRole_name(),dto.getRole_dep(),id);
                }
                //upo.setName();

            }
        } catch (NullPointerException e) {
            // 没有该用户则insert
                logger.info("用户不存在 添加用户");
                testMapper.addUserById(dto.getUser_id(),dto.getUser_name(),dto.getUser_password());
            //判断是否包含role信息  如果是设置role，如果不是则不设置role
            if(dto.getRole_name()!=null&&dto.getRole_dep()!=null) {

                /*
                * 插入一个新用户的role 需要先获得该role的userid即user的id

                *  */
                Integer userId = testMapper.selectUserByName(dto.getUser_name()).getId();  // 根据name 获取该用户的id

                testRoleMapper.setUserRole(dto.getRole_id(), dto.getRole_name(), dto.getRole_dep(),userId);// 根据id插入到数据库
            }
                logger.info(e.toString());
        }


//        if (dto.getUser_id() != null) {
////		testMapperDao.updateById(user);
//        } else {
//
////		testMapperDao.insert(user);
//        }
    }

    /*
     * 修改密码
     * */

    /**
     * 修改登录密码
     *
     * @param vo
     * @throws BusinessException
     */

    public void updatePass(UserVo vo) throws BusinessException {
        if (vo == null) {
            throw new BusinessException(BusinessException.CODE_PARAM_NULL);
        }
        try {
            UserTestBase ub = new UserTestBase(); //创建一个用户的实体类
            logger.info("创建实体类成功");
            ub.setName(vo.getName());    // 设置名字为当前名字
            logger.info("给实体类赋值成功实体类的名字为" + ub.getName());
            ub = this.selectOne(new EntityWrapper<>(ub)); //  通过实体查询
            logger.info("根据ub的实体查询结果为" + ub.getName() + ub.getPassword());
            ub.setPassword(BCrypt.hashpw(ub.getPassword(), BCrypt.gensalt()));
            logger.info("ub加密以后的password为" + ub.getPassword());
            if (BCrypt.checkpw(vo.getPassword(), ub.getPassword()) == false) {
                logger.info("vo-p" + vo.getPassword() + "uo-p" + ub.getPassword());
                ub.setName(vo.getName()); //设置名字和密码
                //ub.setPassword(BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt(5)));
                ub.setPassword(vo.getPassword());
                boolean flag = this.updateById(ub);  // 写入数据库
                if (flag) {
                    logger.info("更新密码成功");
                } else {
                    logger.info("更新密码失败");

                    throw new BusinessException(BusinessException.CODE_ERROR);
                }
            } else {
                logger.info("修改后密码和之前密码相同，请重新设置");
                throw new BusinessException(BusinessException.CODE_PASSWORD_ERROR);
            }
        } catch (BusinessException e) {
            logger.error(e.toString());
            throw new BusinessException(e.getErrCode(), e.getErrMsg());
        } catch (Exception e) {
            logger.info("vo信息为" + vo.getName() + vo.getId().toString() + vo.getPassword());
            logger.error(e.toString());
            throw new BusinessException(BusinessException.CODE_PASSWORD_UPDATE_ERROR);
        }
    }
    /*
     * 删除用户
     * */

	@Transactional(rollbackFor = { Exception.class })
	public Boolean deleteByadmin(Integer id) {
        testMapper.deleteUserById(id);
        testRoleMapper.deleteRoleByUserId(id);


	    return false;
	}

	public boolean addManyUser(Integer num){

        for (Integer i = 0; i < num; i++) {
            testMapper.addUserById(null,"user"+i.toString(),i.toString()+"pass");
        }
    return true;
    }

    /*
    * 分页查询
    * */
    public PageInfo<UserTestBase> selectByPage(Integer pageId){

        //设置查询的页数 和 每页的数量
        PageHelper.startPage(pageId, 10);
       List<UserTestBase> userList =  testMapper.selectAllUser();
        PageInfo<UserTestBase> pageInfo = new PageInfo<UserTestBase>(userList);
        return pageInfo;
    }


}
