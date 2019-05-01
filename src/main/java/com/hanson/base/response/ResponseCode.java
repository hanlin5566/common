package com.hanson.base.response;

import com.hanson.base.enums.IResponseCode;

/**
 * Create by hanlin on 2017年11月6日
 **/
public enum ResponseCode implements IResponseCode{
	UNKNOWN(0, "未知"),
	OK(200000,"成功","恭喜你，请求成功啦"),
	RESET_CONTENT(205, "内容重置","返回体被重置,返回体"),
	ERROR_PARAM(400,"请求参数错误","错误的参数"),
	LOGIN_FAILED(411,"登录失败"),
	UNAUTHORIZED(401,"未授权"),
	PAYMENT_REQUIRED(402,"调用次数超限"),
	FORBIDDEN(403,"拒绝访问"),
	RESOURCE_NOT_FOUND(404,"请求资源未找到"),
	METHOD_NOT_ALLOWED(405,"请求方法不被允许调用","当前方法不支持"),
	NOT_ACCEPTABLE(406,"请求不可接受"),
	PROXY_AUTH_REQUIRED(407,"需要代理身份验证"),
	REQUEST_TIMEOUT (408,"请求超时"),
	CONFLICT (409,"数据冲突"),
	GONE (410,"已失效"),
	INTERNAL_SERVER_ERROR(500, "系统内部错误","%s系统发生%s内部错误"),
	BAD_GATEWAY(502, "错误的网关"),
	SERVICE_UNAVAILABLE(503, "服务不可用"),
	GATEWAY_TIMEOUT(504, "网关超时"),
	TRIGGER_FUSE(505, "触发熔断"),
	CREATE_REQEUST_BODY_ERROR(506, "构建reqeust错误","构建reqeust错误,URI:%S")
	;
	private final int code;
    private final String friendlyMsg;
    private final String detailMsg;

    private ResponseCode(int code, String friendlyMsg) {
        this.code = code;
        this.friendlyMsg = friendlyMsg;
        this.detailMsg = friendlyMsg;
    }
    private ResponseCode(int code, String friendlyMsg,String detailMsg) {
    	this.code = code;
    	this.friendlyMsg = friendlyMsg;
    	this.detailMsg = detailMsg;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String friendlyMsg() {
        return friendlyMsg;
    }

    @Override
	public String detailMsg() {
		return detailMsg;
	}

	public static ResponseCode codeOf(int code) {
        for (ResponseCode value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ResponseCode code: " + code);
    }
}
