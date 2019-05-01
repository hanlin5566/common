package com.hanson.base.response;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hanson.base.enums.IResponseCode;

/**
 * Create by hanlin on 2018年5月22日
 **/
public class ResponseData implements Serializable{
	private static final long serialVersionUID = -8250920561400938966L;
	private Object data;
	private int code;
	private boolean success;
	private String message;
	@SuppressWarnings("deprecation")
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	private Object pageInfo = null;
	
	public ResponseData() {
		super();
	}

	private ResponseData(Object data, IResponseCode code) {
		super();
		this.data = data;
		this.code = code.code();
		this.message = code.friendlyMsg();
		this.success = ResponseCode.OK.code() == code.code();
	}
	
	private ResponseData(IResponseCode code) {
		super();
		//TODO:返回的是null还是{}在这指定
		this.data = new JSONObject();
		this.code = code.code();
		this.message = code.friendlyMsg();
		this.success =  ResponseCode.OK.code() == code.code();
	}

	public static ResponseData ok(Object data){
		return new ResponseData(data, ResponseCode.OK);
	}
	public ResponseData appendPageInfo(Object pageInfo){
		this.pageInfo = pageInfo;
		return this;
	}
	public static ResponseData ok(){
		return new ResponseData(ResponseCode.OK);
	}
	
	public static ResponseData fail(IResponseCode code){
		return new ResponseData(code);
	}
	
	public static ResponseData failByParam(){
		return new ResponseData(ResponseCode.ERROR_PARAM);
	}
	
	public static ResponseData failByUnauthorized(){
		return new ResponseData(ResponseCode.UNAUTHORIZED);
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int returnCode) {
		this.code = returnCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(Object pageInfo) {
		this.pageInfo = pageInfo;
	}
}
