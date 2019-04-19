package com.example.user.exception;

import java.util.HashMap;
import java.util.Map;

public class BusinessException extends Exception {
    // private static MessageSource messageSource =
    private static final long serialVersionUID = -238091758285157331L;

    private String errCode;
    private String errMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String _errCode) {
        this.errCode = _errCode;
        // this.errMsg = messageSource.getMessage(getMsgByCode(_errCode), null,
        // LocaleContextHolder.getLocale());
        this.errMsg = getMsgByCode(_errCode);

    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    // region 公共返回码
    public static final String CODE_SUCCESS = "8001";
    public static final String MSG_SUCCESS = "操作成功";
    public static final String CODE_ERROR = "4001";
    public static final String MSG_ERROR = "操作失败";
    public static final String CODE_AUTH_ERROR = "4000";
    public static final String MSG_AUTH_ERROR = "权限不足";
    public static final String CODE_IDEMPOTENT_ERROR = "4002";
    public static final String MSG_IDEMPOTENT_ERROR = "Header缺少参数: 'Idempotent'";
    public static final String CODE_UNKNOWN_ERROR = "4003";
    public static final String MSG_UNKNOWN_ERROR = "系统小妹不知道发生了什么，请与我们的工程师联系";
    public static final String CODE_SYSTEM_BUSY_ERROR = "4004";
    public static final String MSG_SYSTEM_BUSY_ERROR = "服务器繁忙，请再试一次";
    public static final String CODE_TELEPHONE_ERROR = "4005";
    public static final String MSG_TELEPHONE_ERROR = "电话格式错误";
    // endregion

    // region 数据相关
    public static final String CODE_SIGN_ERROR = "4101";
    public static final String MSG_SIGN_ERROR = "数据签名错误";
    public static final String CODE_PARAM_NULL = "4102";
    public static final String MSG_PARAM_NULL = "请求参数有误";
    public static final String CODE_SQL_ERROR = "4103";
    public static final String MSG_SQL_ERROR = "SQL异常";
    public static final String CODE_INSERT_ERROR = "4104";
    public static final String MSG_INSERT_ERROR = "添加失败";
    public static final String CODE_DELETE_ERROR = "4105";
    public static final String MSG_DELETE_ERROR = "删除失败";
    public static final String CODE_UPDATE_ERROR = "4106";
    public static final String MSG_UPDATE_ERROR = "更新失败";
    public static final String CODE_NULL_ERROR = "4107";
    public static final String MSG_NULL_ERROR = "数据不存在";
    public static final String CODE_DATE_REPEAT_ERROR = "4108";
    public static final String MSG_DATE_REPEAT_ERROR = "服务类目名称已存在";
    public static final String CODE_DATE_TOO_LONG_ERROR = "4109";
    public static final String MSG_DATE_TOO_LONG_ERROR = "数据长度过长";
    public static final String CODE_INVALID_FORMAT_ERROR = "4110";
    public static final String MSG_INVALID_FORMAT_ERROR = "数据格式有误";

    // endregion

    // region 其他常见错误
    public static final String CODE_LOGIN_OUT_OF_TIME = "4201";
    public static final String MSG_LOGIN_OUT_OF_TIME = "登录过期";
    public static final String CODE_ERROR_REMOTE = "4202";
    public static final String MSG_ERROR_REMOTE = "远程调用失败";
    public static final String CODE_IMG_UPLOAD_ERROR = "4203";
    public static final String MSG_IMG_UPLOAD_ERROR = "图片关联失败";
    public static final String CODE_INTERFACE_EXCEPTION = "4204";
    public static final String MSG_INTERFACE_EXCEPTION = "接口调用异常";
    public static final String CODE_ERROR_DATE_FORMAT = "4205";
    public static final String MSG_ERROR_DATE_FORMAT = "日期格式错误";
    public static final String CODE_ERROR_DATE_RANGE = "4206";
    public static final String MSG_ERROR_DATE_RANGE = "超出搜索时间范围";
	public static final String CODE_ERROR_PASSWORD = "4207";
	public static final String MSG_ERROR_PASSWORD = "密码错误";
	public static final String CODE_ERROR_DVCNO_USER_NOT_BIND = "4208";
	public static final String MSG_ERROR_DVCNO_USER_NOT_BIND = "该车辆未被用户绑定，无法设置";
	public static final String CODE_ERROR_DVCNO_USER_NOT_USED = "4209";
	public static final String MSG_ERROR_DVCNO_USER_NOT_USED = "该车辆没有正在使用的车辆";
    // endregion

    public static final String CODE_ERROR_NOT_EXIST_USER = "5001";
    public static final String MSG_ERROR_NOT_EXIST_USER = "该用户不存在";

    public static final String CODE_ERROR_EN_NOT_NULL = "5002";
    public static final String MSG_ERROR_EN_NOT_NULL = "组织架构英文名不能为空";

    public static final String CODE_ERROR_QUERY_SQL = "5003";
    public static final String MSG_ERROR_QUERY_SQL = "查询失败";

    public static final String CODE_DATA_FORMAT_ERROR = "5004";
    public static final String MSG_DATA_FORMAT_ERROR = "数据格式化失败";

    public static final String CODE_ERROR_PERMISSION = "5005";
    public static final String MSG_ERROR_PERMISSION = "请分配页面权限";

    public static final String CODE_ERROR_EXIST_ROLE = "5006";
    public static final String MSG_ERROR_EXIST_ROLE = "角色名称或编号不能重复";

    public static final String CODE_ERROR_ROLE_HAS_USE = "5007";
    public static final String MSG_ERROR_ROLE_HAS_USE = "该角色还有用户在使用，请先解除";
    public static final String CODE_ERROR_EXIST_USER = "5008";
    public static final String MSG_ERROR_EXIST_USER = "该用户已存在";

    public static final String CODE_SYNC_IS_EXIST = "5009";
    public static final String MSG_SYNC_IS_EXIST = "该系统已存在";
    public static final String CODE_SERVER_ADDRESS_ERROR = "5010";
    public static final String MSG_SERVER_ADDRESS_ERROR = "文件上传错误";
    public static final String CODE_SERVER_DATA_NULL_ERROR = "5011";
    public static final String MSG_SERVER_DATA_NULL_ERROR = "文件上传不能为空";
    public static final String CODE_PASSWORD_ERROR = "5012";
    public static final String MSG_PASSWORD_ERROR = "密码错误";
    public static final String CODE_PASSWORD_UPDATE_ERROR = "5013";
    public static final String MSG_PASSWORD_UPDATE_ERROR = "密码修改失败";
    public static final String CODE_GET_MESSAGE_ERROR = "5014";
    public static final String MSG_GET_MESSAGE_ERROR = "短信发送失败";
    public static final String CODE_SAVE_ERROR = "5015";
    public static final String MSG_SAVE_ERROR = "保存失败";
    public static final String CODE_DATA_NOT_EXIST = "5016";
    public static final String MSG_DATA_NOT_EXIST = "数据不存在";
	public static final String CODE_PHONE_CODE_TOO_BUSSISE = "5017";
	public static final String MSG_PHONE_CODE_TOO_BUSSISE = "短信获取太频繁了";
	public static final String CODE_VERIFICATION_CODE_ERROR = "5018";
	public static final String MSG_VERIFICATION_CODE_ERROR = "验证码无效或已过期";
	public static final String CODE_ORGCODE = "5019";
	public static final String MSG_ORGCODE = "没有合适的orgCode";
	public static final String CODE_EXCEL_DUPLICATE_ERROR = "5020";
	public static final String MSG_EXCEL_DUPLICATE_ERROR = "excel中有重复行";


	// 业务
	public static final String CODE_USER_DISABLE_OR_CANCLE = "5020";
	public static final String MSG_USER_DISABLE_OR_CANCLE = "该用户已被禁用";

	public static final String CODE_HARD_WARE_HAD_EXIST = "5021";
	public static final String MSG_HARD_WARE_HAD_EXIST = "该固件已存在";

	public static final String CODE_PHONE_ERROE_WITH_USER = "5022";
	public static final String MSG_PHONE_ERROE_WITH_USER = "该手机号与用户绑定的不符";

	public static final String CODE_PHONE_NEW_OLD_SAME = "5023";
	public static final String MSG_PHONE_NEW_OLD_SAME = "新手机号不能与旧手机号相同";

    //region 资金
    public static final String CODE_ERROR_TRADE = "7301";
    public static final String MSG_ERROR_TRADE = "交易失败";
    public static final String CODE_ERROR_PAY_TYPE = "7302";
    public static final String MSG_ERROR_PAY_TYPE = "支付方式错误";
    public static final String CODE_ORDERNO_EXIST = "7303";
    public static final String MSG_ORDERNO_EXIST = "订单号已存在";
    public static final String CODE_FLOW_ERROR_TYPE = "7304";
    public static final String MSG_FLOW_ERROR_TYPE = "交易业务类型不存在";
    public static final String CODE_ERROR_FLOW = "7305";
    public static final String MSG_ERROR_FLOW = "流水生成失败";
    public static final String CODE_FLOW_NOT_EXIST = "7306";
    public static final String MSG_FLOW_NOT_EXIST = "流水不存在";
    public static final String CODE_TRADE_FINISHED = "7307";
    public static final String MSG_TRADE_FINISHED = "交易已完成";
    public static final String CODE_ERROR_EXPIRE_TIME_FORMAT = "7308";
    public static final String MSG_ERROR_EXPIRE_TIME_FORMAT = "过期时间参数错误";
    public static final String CODE_NO_REFUND_INFO = "7309";
    public static final String MSG_NO_REFUND_INFO = "第三方退款信息不存在";
    public static final String CODE_NO_FILE = "7601";
    public static final String MSG_NO_FILE = "文件不存在";

    //服务商
    public static final String CODE_DEALER_NOT_EXIST_ERROR = "6301";
    public static final String MSG_DEALER_NOT_EXIST_ERROR = "服务商不存在";
    public static final String CODE_NO_OUTLETS = "6302";
    public static final String MSG_NO_OUTLETS = "您还没有门店";
    public static final String CODE_STORE_NOT_EXIST_ERROR = "6401";
    public static final String MSG_STORE_NOT_EXIST_ERROR = "门店不存在";
    public static final String CODE_DEALER_CANOT_ERROR = "6402";
    public static final String MSG_DEALER_CANOT_ERROR = "服务商下面有网点，不能删除";
    public static final String CODE_DEALER_CANOT_UNABLE_ERROR = "64002";
    public static final String MSG_DEALER_CANOT_UNABLE_ERROR = "服务商下面有启用的网点，不能被禁用";
    public static final String CODE_STORE_ADD_FAIL_ERROR = "6403";
    public static final String MSG_STORE_ADD_FAIL_ERROR = "服务网点添加失败";
    public static final String CODE_REPAIR_APPLY_NOT_EXIST_ERROR = "6501";
    public static final String MSG_REPAIR_APPLY_NOT_EXIST_ERROR = "维修申请不存在";
    public static final String CODE_CANNOT_SET_EVALUATE_ERROR = "6502";
    public static final String MSG_CANNOT_SET_EVALUATE_ERROR = "不能取消屏蔽或屏蔽评价";
    public static final String CODE_REPAIR_EVALUATE_NOT_EXIST_ERROR = "6601";
    public static final String MSG_REPAIR_EVALUATE_NOT_EXIST_ERROR = "服务评价失败，请重新评价";
    public static final String CODE_DEALER_ADD_FAIL_ERROR = "6602";
    public static final String MSG_DEALER_ADD_FAIL_ERROR = "服务商添加失败";
    public static final String CODE_REPAIR_APPLY_HANDLE_FAIL_ERROR = "6603";
    public static final String MSG_REPAIR_APPLY_HANDLE_FAIL_ERROR = "服务商处理失败，请处理";
    public static final String CODE_ERROR_DEALER_NAME_EXIST_USER = "6604";
    public static final String MSG_ERROR_DEALER_NAME_EXIST_ERROR = "服务商名称已存在";
    public static final String CODE_ERROR_LOGNAME_NAME_EXIST_USER = "6605";
    public static final String MSG_ERROR_LOGNAME_NAME_EXIST_ERROR = "登录名称已存在";
    public static final String CODE_ERROR_DEALER_LOGNAME_NAME_EXIST_USER = "6607";
    public static final String MSG_ERROR_DEALER_LOGNAME_NAME_EXIST_ERROR = "登录名称与服务商登录名称重复";
    public static final String CODE_ERROR_STORE_LOGNAME_NAME_EXIST_USER = "6608";
    public static final String MSG_ERROR_STORE_LOGNAME_NAME_EXIST_ERROR = "登录名称与服务网点登录名称重复";

    public static final String CODE_ERROR_STORE_NAME_EXIST_USER = "6609";
    public static final String MSG_ERROR_STORE_NAME_EXIST_ERROR = "服务网点名称已存在";
    public static final String CODE_ERROR_EXPORT = "6606";
    public static final String MSG_ERROR_EXPORT = "csv导出错误";
	public static final String CODE_LOGIN_PASSWORD_NULL = "6607";
	public static final String MSG_LOGIN_PASSWORD_NULL = "用户名或密码不能为空";

    public static final String CODE_STORE_STATISTICS_ERROR = "6610";
    public static final String MSG_STORE_STATISTICS_ERROR = "服务网点统计报错";
	public static final String CODE_DEALER_PHONE_HAD_USERD = "6611";
	public static final String MSG_DEALER_PHONE_HAD_USERD = "该手机号已被绑定";

    public static final String CODE_REPAIR_APPLY_HAS_HANDLE_ERROR = "6612";
    public static final String MSG_REPAIR_APPLY_HAS_HANDLE_ERROR = "维修申请已经处理";

    public static final String CODE_ERROR_DEALER_LOGNAME_NAME_FORMAT_USER = "6613";
    public static final String MSG_ERROR_DEALER_LOGNAME_NAME_FORMAT_ERROR = "APP登录账户格式不正确";

    public static final String CODE_ERROR_DEALER_CONTACT_NUMBER_FORMAT_USER = "6614";
    public static final String MSG_ERROR_DEALER_CONTACT_NUMBER_FORMAT_ERROR = "服务商联系电话格式不正确";

    public static final String CODE_ERROR_STORE_STORE_TELEPHONE_FORMAT_USER = "6615";
    public static final String MSG_ERROR_STORE_STORE_TELEPHONE_FORMAT_ERROR = "服务网点联系电话格式不正确";

    public static final String CODE_SET_EVALUATE_ERROR = "6616";
    public static final String MSG_SET_EVALUATE_ERROR = "设置失败，请重新设置";

    public static final String CODE_REPAIR_EVALUATE_STATE_UNHANDLE_ERROR = "6617";
    public static final String MSG_REPAIR_EVALUATE_STATE_UNHANDLE_ERROR = "维修申请为待处理状态，不可评价！";

    public static final String CODE_REPAIR_EVALUATE_STATE_FINISHED_ERROR = "6618";
    public static final String MSG_REPAIR_EVALUATE_STATE_FINISHED_ERROR = "维修申请已评价，不可重复评价！";

    public static final String CODE_REPAIR_EVALUATE_STATE_USERCANCEL_ERROR = "6619";
    public static final String MSG_REPAIR_EVALUATE_STATE_USERCANCEL_ERROR = "维修申请为用户取消状态，不可评价！";

    public static final String CODE_REPAIR_EVALUATE_STATE_STORECANCEL_ERROR = "6620";
    public static final String MSG_REPAIR_EVALUATE_STATE_STORECANCEL_ERROR = "维修申请为网点取消状态，不可评价！";

    public static final String CODE_REPAIR_EVALUATE_STATE__ERROR = "6621";
    public static final String MSG_REPAIR_EVALUATE_STATE__ERROR = "维修申请状态有误，不可评价！";

	public static final String CODE_STORE_NOT_COLLECT_ERROR = "6622";
	public static final String MSG_STORE_NOT_COLLECT_ERROR = "该商店未被收藏";

    public static final String CODE_STORE_REPEAT_COLLECT_ERROR = "6623";
    public static final String MSG_STORE_REPEAT_COLLECT_ERROR = "您已收藏成功，请勿重复操作！";

    public static final String CODE_ONLY_OWNER_APPLY = "6624";
    public static final String MSG_ONLY_OWNER_APPLY = "只有车主才能申请报修哦！";
    public static final String CODE_ONLY_OWNER_EVALUATE = "6625";
    public static final String MSG_ONLY_OWNER_EVALUATE = "只有车主才能评价哦！";
    public static final String CODE_REPAIR_APPLY_IMAGE_SAVE_ERROR = "6626";
    public static final String MSG_REPAIR_APPLY_IMAGE_SAVE_ERROR = "反馈的图片上传出错，请重新操作哦！";
    public static final String CODE_ONLY_OWNER_CANCEL = "6627";
    public static final String MSG_ONLY_OWNER_CANCEL = "只有车主才能取消哦！";
    public static final String CODE_STORE_PHONE_HAD_USERD = "6628";
    public static final String MSG_STORE_PHONE_HAD_USERD = "网店联系电话已被绑定";
    //endregion

    //region 智能服务
    public static final String CODE_NO_INTELLIGENT_SERVING = "6511";
    public static final String MSG_NO_INTELLIGENT_SERVING = "智能服务不可用";
    public static final String CODE_CAN_NOT_BUY_INTELLIGENT_SERVING = "6512";
    public static final String MSG_CAN_NOT_BUY_INTELLIGENT_SERVING = "智能服务只有车主才能购买哦~";
    //endregion

    // public static String getGJH(String key) {
    // return messageSource.getMessage(key, null,
    // LocaleContextHolder.getLocale());
    // }

    private static Map<String, String> msgMap = new HashMap<String, String>();

    public static String getMsgByCode(String code) {
        return msgMap.get(code);
    }

    static {
        // region 公共返回码
        msgMap.put(CODE_SUCCESS, MSG_SUCCESS);
        msgMap.put(CODE_ERROR, MSG_ERROR);
        msgMap.put(CODE_AUTH_ERROR, MSG_AUTH_ERROR);
        msgMap.put(CODE_IDEMPOTENT_ERROR, MSG_IDEMPOTENT_ERROR);
        msgMap.put(CODE_UNKNOWN_ERROR, MSG_UNKNOWN_ERROR);
        msgMap.put(CODE_EXCEL_DUPLICATE_ERROR, MSG_EXCEL_DUPLICATE_ERROR);
        msgMap.put(CODE_TELEPHONE_ERROR, MSG_TELEPHONE_ERROR);
        // endregion

        // region 数据相关
        msgMap.put(CODE_SIGN_ERROR, MSG_SIGN_ERROR);
        msgMap.put(CODE_PARAM_NULL, MSG_PARAM_NULL);
        msgMap.put(CODE_SQL_ERROR, MSG_SQL_ERROR);
        msgMap.put(CODE_INSERT_ERROR, MSG_INSERT_ERROR);
        msgMap.put(CODE_DELETE_ERROR, MSG_DELETE_ERROR);
        msgMap.put(CODE_UPDATE_ERROR, MSG_UPDATE_ERROR);
        msgMap.put(CODE_NULL_ERROR, MSG_NULL_ERROR);
        msgMap.put(CODE_DATE_REPEAT_ERROR, MSG_DATE_REPEAT_ERROR);
        msgMap.put(CODE_DATE_TOO_LONG_ERROR, MSG_DATE_TOO_LONG_ERROR);
        msgMap.put(CODE_INVALID_FORMAT_ERROR, MSG_INVALID_FORMAT_ERROR);
		msgMap.put(CODE_PHONE_NEW_OLD_SAME, MSG_PHONE_NEW_OLD_SAME);
        // endregion

        // region 其他常见错误
        msgMap.put(CODE_LOGIN_OUT_OF_TIME, MSG_LOGIN_OUT_OF_TIME);
        msgMap.put(CODE_ERROR_REMOTE, MSG_ERROR_REMOTE);
        msgMap.put(CODE_IMG_UPLOAD_ERROR, MSG_IMG_UPLOAD_ERROR);
        msgMap.put(CODE_INTERFACE_EXCEPTION, MSG_INTERFACE_EXCEPTION);
        msgMap.put(CODE_ERROR_DATE_FORMAT, MSG_ERROR_DATE_FORMAT);
        msgMap.put(CODE_ERROR_DATE_RANGE, MSG_ERROR_DATE_RANGE);
        msgMap.put(CODE_PHONE_CODE_TOO_BUSSISE, MSG_PHONE_CODE_TOO_BUSSISE);
        msgMap.put(CODE_VERIFICATION_CODE_ERROR, MSG_VERIFICATION_CODE_ERROR);
        msgMap.put(CODE_USER_DISABLE_OR_CANCLE, MSG_USER_DISABLE_OR_CANCLE);
        // endregion

        msgMap.put(CODE_ERROR_NOT_EXIST_USER, MSG_ERROR_NOT_EXIST_USER);
        msgMap.put(CODE_SAVE_ERROR, MSG_SAVE_ERROR);
        msgMap.put(CODE_LOGIN_OUT_OF_TIME, MSG_LOGIN_OUT_OF_TIME);
        msgMap.put(CODE_ERROR_EN_NOT_NULL, MSG_ERROR_EN_NOT_NULL);
        msgMap.put(CODE_ERROR_EXIST_ROLE, MSG_ERROR_EXIST_ROLE);
        msgMap.put(CODE_ERROR_EXIST_USER, MSG_ERROR_EXIST_USER);
        msgMap.put(CODE_GET_MESSAGE_ERROR, MSG_GET_MESSAGE_ERROR);
        msgMap.put(CODE_DATA_FORMAT_ERROR, MSG_DATA_FORMAT_ERROR);
        msgMap.put(CODE_PASSWORD_ERROR, MSG_PASSWORD_ERROR);
        msgMap.put(CODE_PASSWORD_UPDATE_ERROR, MSG_PASSWORD_UPDATE_ERROR);
        msgMap.put(CODE_ERROR_PERMISSION, MSG_ERROR_PERMISSION);
        msgMap.put(CODE_SERVER_ADDRESS_ERROR, MSG_SERVER_ADDRESS_ERROR);
        msgMap.put(CODE_SERVER_DATA_NULL_ERROR, MSG_SERVER_DATA_NULL_ERROR);
        msgMap.put(CODE_SYNC_IS_EXIST, MSG_SYNC_IS_EXIST);
        msgMap.put(CODE_ERROR_ROLE_HAS_USE, MSG_ERROR_ROLE_HAS_USE);
        msgMap.put(CODE_DATA_NOT_EXIST, MSG_DATA_NOT_EXIST);
		msgMap.put(CODE_ERROR_PASSWORD, MSG_ERROR_PASSWORD);
		msgMap.put(CODE_PHONE_ERROE_WITH_USER, MSG_PHONE_ERROE_WITH_USER);
		msgMap.put(CODE_LOGIN_PASSWORD_NULL, MSG_LOGIN_PASSWORD_NULL);
		msgMap.put(CODE_ORGCODE, MSG_ORGCODE);
		msgMap.put(CODE_ERROR_DVCNO_USER_NOT_BIND, MSG_ERROR_DVCNO_USER_NOT_BIND);
		msgMap.put(CODE_ERROR_DVCNO_USER_NOT_USED, MSG_ERROR_DVCNO_USER_NOT_USED);

        //region 资金
        msgMap.put(CODE_ERROR_TRADE, MSG_ERROR_TRADE);
        msgMap.put(CODE_ERROR_PAY_TYPE, MSG_ERROR_PAY_TYPE);
        msgMap.put(CODE_ORDERNO_EXIST, MSG_ORDERNO_EXIST);
        msgMap.put(CODE_FLOW_ERROR_TYPE, MSG_FLOW_ERROR_TYPE);
        msgMap.put(CODE_ERROR_FLOW, MSG_ERROR_FLOW);
        msgMap.put(CODE_FLOW_NOT_EXIST, MSG_FLOW_NOT_EXIST);
        msgMap.put(CODE_TRADE_FINISHED, MSG_TRADE_FINISHED);
        msgMap.put(CODE_ERROR_EXPIRE_TIME_FORMAT, MSG_ERROR_EXPIRE_TIME_FORMAT);
        msgMap.put(CODE_NO_REFUND_INFO, MSG_NO_REFUND_INFO);
        msgMap.put(CODE_NO_FILE, MSG_NO_FILE);
        //endregion

        //region 智能服务
        msgMap.put(CODE_NO_INTELLIGENT_SERVING, MSG_NO_INTELLIGENT_SERVING);
        msgMap.put(CODE_CAN_NOT_BUY_INTELLIGENT_SERVING, MSG_CAN_NOT_BUY_INTELLIGENT_SERVING);
        //endregion

        //服务商
        msgMap.put(CODE_DEALER_NOT_EXIST_ERROR, MSG_DEALER_NOT_EXIST_ERROR);
        msgMap.put(CODE_NO_OUTLETS, MSG_NO_OUTLETS);
        msgMap.put(CODE_STORE_NOT_EXIST_ERROR,MSG_STORE_NOT_EXIST_ERROR);
        msgMap.put(CODE_REPAIR_APPLY_NOT_EXIST_ERROR,MSG_REPAIR_APPLY_NOT_EXIST_ERROR);
        msgMap.put(CODE_CANNOT_SET_EVALUATE_ERROR,MSG_CANNOT_SET_EVALUATE_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_NOT_EXIST_ERROR,MSG_REPAIR_EVALUATE_NOT_EXIST_ERROR);
        msgMap.put(CODE_DEALER_ADD_FAIL_ERROR,MSG_DEALER_ADD_FAIL_ERROR);
        msgMap.put(CODE_DEALER_CANOT_ERROR,MSG_DEALER_CANOT_ERROR);
        msgMap.put(CODE_DEALER_CANOT_UNABLE_ERROR,MSG_DEALER_CANOT_UNABLE_ERROR);
        msgMap.put(CODE_STORE_ADD_FAIL_ERROR,MSG_STORE_ADD_FAIL_ERROR);
        msgMap.put(CODE_REPAIR_APPLY_HANDLE_FAIL_ERROR,MSG_REPAIR_APPLY_HANDLE_FAIL_ERROR);
        msgMap.put(CODE_ERROR_DEALER_NAME_EXIST_USER,MSG_ERROR_DEALER_NAME_EXIST_ERROR);
        msgMap.put(CODE_ERROR_LOGNAME_NAME_EXIST_USER,MSG_ERROR_LOGNAME_NAME_EXIST_ERROR);
        msgMap.put(CODE_ERROR_DEALER_LOGNAME_NAME_EXIST_USER,MSG_ERROR_DEALER_LOGNAME_NAME_EXIST_ERROR);
        msgMap.put(CODE_ERROR_STORE_LOGNAME_NAME_EXIST_USER,MSG_ERROR_STORE_LOGNAME_NAME_EXIST_ERROR);
        msgMap.put(CODE_ERROR_STORE_NAME_EXIST_USER,MSG_ERROR_STORE_NAME_EXIST_ERROR);
        msgMap.put(CODE_ERROR_EXPORT,MSG_ERROR_EXPORT);
        msgMap.put(CODE_STORE_STATISTICS_ERROR,MSG_STORE_STATISTICS_ERROR);
        msgMap.put(CODE_DEALER_PHONE_HAD_USERD,MSG_DEALER_PHONE_HAD_USERD);
        msgMap.put(CODE_REPAIR_APPLY_HAS_HANDLE_ERROR,MSG_REPAIR_APPLY_HAS_HANDLE_ERROR);
        msgMap.put(CODE_ERROR_DEALER_LOGNAME_NAME_FORMAT_USER,MSG_ERROR_DEALER_LOGNAME_NAME_FORMAT_ERROR);
        msgMap.put(CODE_ERROR_DEALER_CONTACT_NUMBER_FORMAT_USER,MSG_ERROR_DEALER_CONTACT_NUMBER_FORMAT_ERROR);
        msgMap.put(CODE_ERROR_STORE_STORE_TELEPHONE_FORMAT_USER,MSG_ERROR_STORE_STORE_TELEPHONE_FORMAT_ERROR);
        msgMap.put(CODE_SET_EVALUATE_ERROR,MSG_SET_EVALUATE_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_STATE_UNHANDLE_ERROR,MSG_REPAIR_EVALUATE_STATE_UNHANDLE_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_STATE_FINISHED_ERROR,MSG_REPAIR_EVALUATE_STATE_FINISHED_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_STATE_USERCANCEL_ERROR,MSG_REPAIR_EVALUATE_STATE_USERCANCEL_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_STATE_STORECANCEL_ERROR,MSG_REPAIR_EVALUATE_STATE_STORECANCEL_ERROR);
        msgMap.put(CODE_REPAIR_EVALUATE_STATE__ERROR,MSG_REPAIR_EVALUATE_STATE__ERROR);
		msgMap.put(CODE_STORE_NOT_COLLECT_ERROR, MSG_STORE_NOT_COLLECT_ERROR);
        msgMap.put(CODE_STORE_REPEAT_COLLECT_ERROR, MSG_STORE_REPEAT_COLLECT_ERROR);
        msgMap.put(CODE_ONLY_OWNER_APPLY, MSG_ONLY_OWNER_APPLY);
        msgMap.put(CODE_ONLY_OWNER_EVALUATE, MSG_ONLY_OWNER_EVALUATE);
        msgMap.put(CODE_ONLY_OWNER_CANCEL, MSG_ONLY_OWNER_CANCEL);
        msgMap.put(CODE_STORE_PHONE_HAD_USERD, MSG_STORE_PHONE_HAD_USERD);
        msgMap.put(CODE_REPAIR_APPLY_IMAGE_SAVE_ERROR, MSG_REPAIR_APPLY_IMAGE_SAVE_ERROR);

    }

    public String toString() {
        return "错误码：" + errCode + "，错误信息：" + errMsg;
    }
}
