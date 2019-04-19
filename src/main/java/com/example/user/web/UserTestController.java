package com.example.user.web;

import com.example.user.domain.DTO.UserInfoDTO;
import com.example.user.domain.po.UserTestBase;
import com.example.user.domain.vo.UserTestRoleVo;
import com.example.user.domain.vo.UserVo;
import com.example.user.exception.BusinessException;
import com.example.user.exception.Message;
//import com.example.user.exception.Timeget;
import com.example.user.service.UserTestService;
import com.example.user.service.UserTestRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leaves
 * @version 1.0.0
 * @date 2017/11/13
 */
@RestController
public class UserTestController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserTestService testService;

//    @Autowired
//    private IUserTestMapper userTestMapper;

    @Autowired
    private UserTestRoleService testServiceRole;

//    @Autowired
//    private UserTestRoleVo userTestRoleVo;




//    测试多表查询
   @ApiOperation(value = "根据用户id返回用户信息以及角色信息")
    @RequestMapping(value = "/user/test/selectInfo/{userId}", method = RequestMethod.GET)
    public Message userSelectInfoAdm(@PathVariable(value = "userId") Integer userId){
        /*
         * new Message 的第一个参数 是code  第二个是data
         * */
       return new Message(BusinessException.CODE_SUCCESS,testService.selectUserInfo(userId));
    }

    /*
    * 给用户设置角色
    * */
    @ApiOperation(value = "给用户设置角色")
    @RequestMapping(value = "/user/test/setRole/", method = RequestMethod.POST)
    public Message userSetRoleAdm(@RequestBody UserTestRoleVo vo){
        /*
         * new Message 的第一个参数 是code  第二个是data
         * */
        testService.setUserRole(vo);
        logger.info(vo.getRole_name()+vo.getRole_department()+vo.getUserID());
        return new Message(BusinessException.CODE_SUCCESS,testService.selectUserInfo(vo.getUserID()));  //返回的消息code为当前员工的信息
    }

   // @Timeget
    @ApiOperation(value = "用户存储或更新操作")
    @RequestMapping(value = "/user/test/addUser", method = RequestMethod.POST)
    public Message userAddOrUpdate(@RequestBody UserInfoDTO vo)
            throws BusinessException{
        if (vo != null) {
             testService.saveOfUpdate(vo);
            return new Message(Message.CODE_SUCCESS);
        } else {
            throw new BusinessException(BusinessException.CODE_PARAM_NULL,"please input Illage userInfo");
        }
    }

    /*
    * 分页查询
    * */
    @ApiOperation(value = "分页查询 每页条数10条")
    @RequestMapping(value = "/user/test/selectByPage/{pageId}" ,method = RequestMethod.GET)
    public Message selectByPage(@PathVariable(value = "pageId") Integer pageId){
        PageInfo<UserTestBase> list = testService.selectByPage(pageId);
        return new Message(Message.CODE_SUCCESS,list);

    }



/*
* 修改登录密码
* */
//@ApiOperation(value = " 修改登录密码")
//@RequestMapping(value = "/senthink/test/updatePass", method = RequestMethod.POST)
//public Message updatePass(@RequestBody UserVo vo) throws BusinessException {
//    testService.updatePass(vo);
//    return new Message(Message.CODE_SUCCESS);
//}

/*
 * 删除用户   根据id删除
 * */
    @ApiOperation(value = " 删除用户根据id")
    @RequestMapping(value = "/user/test/delete/{id}", method = RequestMethod.GET)
    public Message userDeleteAdminUser(@PathVariable(value = "id") Integer id) {
        return testService.deleteByadmin(id) ? new Message(Message.CODE_SUCCESS) : new Message(Message.CODE_ERROR);

    }

    /*
     * 批量添加用户  测试用
     * */
//    @ApiOperation(value = " 批量添加用户测试用")
//    @RequestMapping(value = "/user/test/addManyTest/{num}", method = RequestMethod.GET)
//    public Message userAddManyUser(@PathVariable(value = "num") Integer num) {
//        return testService.addManyUser(num)? new Message(Message.CODE_SUCCESS) : new Message(Message.CODE_ERROR);
//
//    }

//    @ApiOperation(value = "单表查询role删除")
//    @RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.GET)
//    public Message userSelectInfo(@PathVariable(value = "userId") Integer userId) {
//     // return new Message(Message.CODE_SUCCESS,testServiceRole.selectById(id)); // mybatis的查询有问题
//        return new Message(Message.CODE_SUCCESS,"userId:"+testServiceRole.deleteByUserId(userId));   // 自己写的sql语句正常
//    }
//    @ApiOperation(value ="通过userid查询role信息")
//    @RequestMapping(value = "/user/selectByUserId/{id}", method = RequestMethod.GET)
//    public Message userSelectInfoByUserId(@PathVariable(value = "id") Integer id) {
//        // return new Message(Message.CODE_SUCCESS,testServiceRole.selectById(id)); // mybatis的查询有问题
//        return new Message(Message.CODE_SUCCESS,testServiceRole.userRoleByUserId(id));   // 自己写的sql语句正常
//    }


//    @ApiOperation(value = "单表查询user信息")
//    @RequestMapping(value = "/user/selectUser/{id}", method = RequestMethod.GET)
//    public Message selectUser(@PathVariable(value = "id") Integer id) {
//        return new Message(Message.CODE_SUCCESS,testService.selectById(id));
//    }
//    @ApiOperation(value = "单表添加user信息")
//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public Message addUser(@RequestBody UserVo vo) {
//        return new Message(Message.CODE_SUCCESS,testService.addUser(vo));   // 添加user
//    }
//    @ApiOperation(value = "单表删除user信息")
//    @RequestMapping(value = "/user/deleteUser/{id}", method = RequestMethod.GET)
//    public Message deleteUser(@PathVariable(value = "id") Integer id) {
//        return new Message(Message.CODE_SUCCESS,testService.deleteUserById(id));   //删除user
//    }
//    @ApiOperation(value = "单表修改user信息")
//    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
//    public Message updateUser(@RequestBody UserVo vo) {
//        return new Message(Message.CODE_SUCCESS,testService.addUser(vo));   // 添加user
//    }


}
