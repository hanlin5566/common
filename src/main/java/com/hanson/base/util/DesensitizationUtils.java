package com.hanson.base.util;

/**
 * Created by hanson on 2018/5/30.
 */
public class DesensitizationUtils {

	public static String desensitizationPhoneNumber(String num) {
		String var1 = num;
		String var2 = var1.length() > 15 ? "**********" : "*******";
		StringBuilder var3 = new StringBuilder();
		var3.append(var1.substring(0, 4)).append(var2).append(var1.substring(var3.length() - 5, var3.length() - 1));
		return var3.toString();
	}
}
