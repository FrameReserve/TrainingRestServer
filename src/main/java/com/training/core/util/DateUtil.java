package com.training.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {
	
	public static final String DATE_FORMAT_ORDER="yyyyMMdd";
	public static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_NOT_TIME="yyyy-MM-dd";
	public static final String DATE_FORMAT_MONTH="yyyy-MM";
	public static final String DATE_FORMAT_NOT_YEAR="MM-dd";
	public static final String DATE_FORMAT_NATURALID="yyMMdd";
	
	static public Integer getBeforeDay(Integer before){
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		date.setDate(date.getDate()-before);
		return Integer.parseInt((date.getTime()/1000)+"");
	}
	
	// ----- Date 转换成 String
	static public String formatDateOrderNo(Date date) {
    	return formatDate(date, DATE_FORMAT_ORDER);
	}
	static public String formatDate(Date date) {
    	return formatDate(date, DATE_FORMAT);
	}
	static public<T> String formatDateNotTime(Date date) {
		return formatDate(date, DATE_FORMAT_NOT_TIME);
	}
	static public<T> String formatDateNotYear(Date date) {
		return formatDate(date, DATE_FORMAT_NOT_YEAR);
	}
	static public<T> String formatDateMonth(Date date) {
		return formatDate(date, DATE_FORMAT_MONTH);
	}
	
	// ----- Date 转换成 Long 10位，精确到秒
	static public Integer formatDateGetTime() {
    	return formatDateGetTime(new Date());
	}
	static public Integer formatDateGetTime(Date date) {
    	return Integer.parseInt((date.getTime()/1000)+"");
	}
	static public Date toDateSetTime(Long date) {
    	return new Date(date*1000);
	}
	
	// ------ String 转换成 Date
	static public<T> Date toDate(String dateStr) {
		return toDate(DATE_FORMAT, dateStr);
	}
	static public<T> Date toDateNotTime(String dateStr) {
		return toDate(DATE_FORMAT_NOT_TIME, dateStr);
	}
	static public<T> Date toDateMonth(String dateStr) {
		return toDate(DATE_FORMAT_MONTH, dateStr);
	}
	// ------ Date 转换成 Date 去除时分秒
	static public<T> Date DatetoDateNotTime(Date date) {
		String dateStr=formatDateNotTime(date);
		return toDateNotTime(dateStr);
	}
	
	/**
	 * 将Date类型的日期转换为系统参数定义的格式的字符串。
	 * @param aTs_Datetime
	 * @param as_Pattern
	 * @return
	 */
	public static String format(Date aTs_Datetime, String as_Pattern){
		if (aTs_Datetime == null || as_Pattern == null)
			return null;
		
		SimpleDateFormat dateFromat = new SimpleDateFormat();
		dateFromat.applyPattern(as_Pattern);
		  
		return dateFromat.format(aTs_Datetime);
	}
	
	// ---------- private ------------------------------------------
	private static String formatDate(Date date,String pattern){
		java.text.DateFormat format1 = new java.text.SimpleDateFormat(pattern);
        String reqDate = format1.format(date);
    	return reqDate;
	}
	public static Date toDate(String pattern,String dateStr){
		java.text.DateFormat format1 = new java.text.SimpleDateFormat(pattern);
		Date reDate;
		try {
			reDate = format1.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		return reDate;
	}
}
