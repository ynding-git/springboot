package com.ynding.springboot.common.utils;

/**
 * 验证工具类
 * @author ynding
 * @version 2019/01/20
 *
 */
public class UtilValidate {

	/**
	 * 验证对象是否为null或''
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(String obj) {
		if(obj == null || "".equals(obj) || "null".equals(obj)){
			return false;
		}
		return true;
	}

}
