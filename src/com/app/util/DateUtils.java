package com.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static final String FORMAT_0 = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_1 = "yyyy-MM-dd";
	private static final String FORMAT_2 = "HH:mm:ss";

	public static Date getDateNow() {
		return new Date();
	}

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期时间，精确到秒 如:2010-4-15 9:36:38
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 **/
	public static String toFull(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_0);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	public static String toYYYYMM(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM");
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期 如:2010-4-15
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 **/
	public static String toDate(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_1);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	public static String toDateNoHeng(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期 如:2010-4-15
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 **/
	public static String toYearMonth(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMM");
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期时间，精确到秒<br>
	 * 如:9:36:38
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 **/
	public static String toTime(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_2);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 根据字符串格式去转换相应格式的日期和时间
	 * 
	 * @param java
	 *            .lang.String 必要参数
	 * @return java.util.Date
	 * @exception java.text.ParseException
	 *                如果参数格式不正确会抛出此异常
	 **/
	public static Date reverse2Date(String date) {
		SimpleDateFormat simple = null;
		if (date == null || date.equals("") || date.equals("null"))
			return new Date();
		switch (date.trim().length()) {
		case 19:// 日期+时间
			simple = new SimpleDateFormat(FORMAT_0);
			break;
		case 10:// 仅日期
			simple = new SimpleDateFormat(FORMAT_1);
			break;
		case 8:// 仅时间
			simple = new SimpleDateFormat(FORMAT_2);
			break;
		default:
			break;
		}
		try {
			if (simple == null)
				simple = new SimpleDateFormat(FORMAT_1);
			return simple.parse(date.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将带有时、分、秒格式的日期转化为00:00:00<br>
	 * 方便日期推算,格式化后的是yyyy-MM-dd 00:00:00
	 * 
	 * @param java
	 *            .util.Date... date的长度可以为0,即不用给参数
	 * @return java.util.Date
	 **/
	public static Date startOfADay(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_1);
		Date date_ = date.length == 0 ? new Date() : date[0];// 如果date为null则取当前时间
		String d = simple.format(date_);
		try {
			return simple.parse(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 推算一个月内向前或向后偏移多少天,当然推算年也可以使用
	 * 
	 * @param date
	 *            要被偏移的日期,<br>
	 *            amout 偏移量<br>
	 *            b 是否先将date格式化为yyyy-MM-dd 00:00:00 即: 是否严格按整天计算
	 * @return java.util.Date
	 **/
	public static Date addDayOfMonth(Date date, Integer amount, Boolean b) {
		date = date == null ? new Date() : date;// 如果date为null则取当前日期
		if (b) {
			date = startOfADay(date);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * 推算一个小时内向前或向后偏移多少分钟,除了秒、毫秒不可以以外,其他都可以
	 * 
	 * @param date
	 *            要被偏移的日期,<br>
	 *            amout 偏移量<br>
	 *            b 是否先将date格式化为yyyy-MM-dd HH:mm:00 即: 是否严格按整分钟计算
	 * @return java.util.Date
	 **/
	public static Date addMinuteOfHour(Date date, Integer amount, Boolean b) {
		date = date == null ? new Date() : date;// 如果date为null则取当前日期
		if (b) {
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
			try {
				date = simple.parse(simple.format(date));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, amount);
		return cal.getTime();
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.addMinuteOfHour(new Date(), 60, false));
	}

	/*
	 * 计算2个时间相隔的分钟数
	 */
	public static int getTwoDateTimeMinutes(Date sour, Date tag) {
		long diff = tag.getTime() - sour.getTime();
		int mins = (int) (diff / (1000 * 60));
		return mins;
	}

	/*
	 * 计算2个时间相隔的秒数
	 */
	public static int getTwoDateTimeSecond(Date sour, Date tag) {
		long diff = tag.getTime() - sour.getTime();
		int mins = (int) (diff / (1000));
		return mins;
	}
}
