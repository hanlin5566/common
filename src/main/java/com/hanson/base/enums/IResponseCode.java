package com.hanson.base.enums;

/**
 * Create by hanlin on 2017年11月6日
 **/
public interface IResponseCode {
	/**
	 * 返回码
	 * @return
	 */
	public int code();
	/**
	 * 名称
	 * @return
	 */
	public String name();
	/**
	 * 友好提示信息
	 * @return
	 */
	public String friendlyMsg();
	/**
	 * 详细信息，通常用于日志输出
	 * @return
	 */
	public String detailMsg();
}