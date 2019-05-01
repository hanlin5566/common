package com.hanson.base.util;

/**
 * Create by hanlin on 2017年11月8日
 **/
public class StringUtils {
	public static String toUpperFristChar(String string) {
//		char[] charArray = string.toCharArray();
//		charArray[0] -= 32;
//		return String.valueOf(charArray);
		return string.substring(0,1).toUpperCase().concat(string.substring(1));
	}

	public static boolean isNotNull(String args) {
		if (args == null || args.equals("") || args.trim().equals("")) {
			return false;
		}
		return true;
	}

	public static String getStringValue(Object args) {
		if (args == null) {
			return "";
		} else {
			return args.toString().trim();
		}

	}

	// 强转
	public static Integer strToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
		}
		return -1;
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}

		return str1.equalsIgnoreCase(str2);
	}
}
