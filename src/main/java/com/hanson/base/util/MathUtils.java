package com.hanson.base.util;

import java.util.UUID;

/**
 * Create by hanlin on 2018年10月16日
 **/
public class MathUtils {
	/**
	 * 基于UUID生成唯一标识
	 * @return
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
