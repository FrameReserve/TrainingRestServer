package com.training.core.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 验证帮助类
 */
public class ValidateUtil {

	/**
	 * 校验是否为null或空字符串 或执行trim再进行比较
	 * 
	 * @return true为空，false为不空
	 */
	public static boolean isEmpty(Object target) {
		return target == null || target.toString().trim().equals("");
	}

	static public <T> boolean isEmpty(String ogl, T templateObject) {
		String target = format(ogl, templateObject);
		return isEmpty(target);
	}

	static public <T> boolean isAllEmpty(List<String> ogls, T templateObject) {
		for (String ogl : ogls) {
			if (!isEmpty(ogl, templateObject)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否是为数字 包括小数 不包括 + -数
	 * 
	 * @param s
	 * @return false
	 */
	public static boolean isDecimal(String str) {
		if (str == null || "".equals(str))
			return false;
		Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否是为正整数
	 * 
	 * @param s
	 * @return false:不是整数，true:是整数
	 */
	public static boolean isInteger(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str).matches();
	}

	/**
	 * 是否包含中文字符
	 */
	public static boolean isCnSymbol(String value) {
		if (ValidateUtil.isEmpty(value)) {
			return false;
		}
		String[] symbols = new String[] { "　" };
		for (String str : symbols) {
			if (0 <= value.indexOf(str)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNull(Object object) {
		return null == object;
	}

	static public <T> boolean isNull(String ogl, T templateObject) {
		Object object = OgnlUtil.evalOgl(ogl, templateObject);
		return null == object;
	}

	static public <T> String format(String ogl, T templateObject) {
		if (null == templateObject) {
			return "";
		}
		Object o = OgnlUtil.evalOgl(ogl, templateObject);
		return (null == o) ? "" : String.valueOf(o);
	}

	static public <T> String[] format(String[] ogl, T templateObject) {
		return format1(ogl, templateObject).toArray(new String[0]);
	}

	static public <T> String[] format(String[] ogl, T templateObject, String addedString) {

		List<String> result = format1(ogl, templateObject);
		result.add(addedString);

		return result.toArray(new String[0]);
	}

	static private <T> List<String> format1(String[] ogl, T templateObject) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < ogl.length; i++) {
			result.add(format(ogl[i], templateObject));
		}
		return result;
	}

	static private String trimNumberTailZero(String qty) {

		BigDecimal bigDecimal = new BigDecimal(qty).stripTrailingZeros();

		return bigDecimal.toPlainString();
	}

	/**
	 * 删除小数点后面的0，比如5.000=>5, 5.100 => 5.1
	 */
	private static final String sepsPoint = ".";

	public static String trimRightZeroAfterDecimalPoint(String str) {

		if (ValidateUtil.isEmpty(str)) {
			return str;
		}

		str = str.trim();
		if (ValidateUtil.isEmpty(str)) {
			return str;
		}

		if ("0.000000".equals(str)) {
			return "0";
		}

		int index = str.indexOf(sepsPoint);
		if (-1 == index) { // 没有小数点
			return str;
		}

		return ValidateUtil.trimNumberTailZero(str);
	}

	public static String formatStringWithWith20(String strValue) {
		String item = "";
		String changeLine = "\r\n";
		Integer maxLingth = 20;
		while (strValue.length() >= maxLingth) {
			item = item.concat(strValue.substring(0, maxLingth)).concat(changeLine);
			strValue = strValue.substring(maxLingth);
		}
		if (strValue.length() > 0) {
			item = item.concat(strValue);
		}

		return item;
	}

}
