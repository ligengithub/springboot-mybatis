package com.example.user.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Message {
	Logger logger = LoggerFactory.getLogger(Message.class);

    private String code;
    private String msg;
    private Object data;

    public Message() {
    }

    public static final String CODE_SUCCESS = "8001";
    public static final String MSG_SUCCESS = "操作成功";

    public static final String CODE_ERROR = "4001";
    public static final String MSG_ERROR = "操作失败";

    public static Message getSuccess() {
        return new Message(CODE_SUCCESS, MSG_SUCCESS, null);
    }

    public static Message getError() {
        return new Message(CODE_ERROR, MSG_ERROR, null);
    }

    public Message(String code) {
        this.code = code;
        this.msg = BusinessException.getMsgByCode(code);
        this.data = null;
    }

    public Message(String code, Object data) {
        this.code = code;
        this.msg = BusinessException.getMsgByCode(code);
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public Message(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public Message isSuccess() throws BusinessException {
		if ("8001".equals(this.getCode())) {
			return this;
		} else {
			logger.debug(this.getMsg());
			throw new BusinessException(BusinessException.CODE_ERROR_REMOTE);
		}

	}
}
