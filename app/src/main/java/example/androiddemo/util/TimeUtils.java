package example.androiddemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 	时间相关的工具类
 */
public class TimeUtils {
	private TimeUtils() {
		throw new UnsupportedOperationException("u can't fuck me...");
	}
	public static final SimpleDateFormat DEFAULT_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 各时间单位与毫秒的倍数
	 * 	 UNIT_MSEC:毫秒
	 *   UNIT_SEC :秒
	 *   UNIT_MIN :分
	 *   UNIT_HOUR:小时
	 *   UNIT_DAY :天
	 */
	public static final int UNIT_MSEC = 1;
	public static final int UNIT_SEC = 1000;
	public static final int UNIT_MIN = 60000;
	public static final int UNIT_HOUR = 3600000;
	public static final int UNIT_DAY = 86400000;

	/**
	 * 将时间戳转为时间字符串
	 * <p>格式为yyyy-MM-dd HH:mm:ss</p>
	 *
	 * @param milliseconds 毫秒时间戳
	 * @return 时间字符串
	 */
	public static String milliseconds2String(long milliseconds) {
		return milliseconds2String(milliseconds, DEFAULT_SDF);
	}

	/**
	 * 将时间戳转为时间字符串
	 * @param milliseconds 毫秒时间戳
	 * @param format       时间格式
	 * @return 时间字符串
	 */
	public static String milliseconds2String(long milliseconds, SimpleDateFormat format) {
		return format.format(new Date(milliseconds));
	}

	/**
	 * 将时间字符串转为时间戳
	 * @param time 时间字符串
	 * @return 毫秒时间戳
	 */
	public static long string2Milliseconds(String time) {
		return string2Milliseconds(time, DEFAULT_SDF);
	}

	/**
	 * 将时间字符串转为时间戳
	 * @param time   时间字符串
	 * @param format 时间格式
	 * @return 毫秒时间戳
	 */
	public static long string2Milliseconds(String time, SimpleDateFormat format) {
		try {
			return format.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 将时间字符串转为Date类型
	 * <p>格式为yyyy-MM-dd HH:mm:ss</p>
	 * @param time 时间字符串
	 * @return Date类型
	 */
	public static Date string2Date(String time) {
		return string2Date(time, DEFAULT_SDF);
	}
	/**
	 * 将时间字符串转为Date类型
	 * @param time   时间字符串
	 * @param format 时间格式
	 * @return Date类型
	 */
	public static Date string2Date(String time, SimpleDateFormat format) {
		return new Date(string2Milliseconds(time, format));
	}

	/**
	 * 将Date类型转为时间字符串
	 * @param time Date类型时间
	 * @return 时间字符串
	 */
	public static String date2String(Date time) {
		return date2String(time, DEFAULT_SDF);
	}

	/**
	 * 将Date类型转为时间字符串
	 * @param time   Date类型时间
	 * @param format 时间格式
	 * @return 时间字符串
	 */
	public static String date2String(Date time, SimpleDateFormat format) {
		return format.format(time);
	}

	/**
	 * 将Date类型转为时间戳
	 * @param time Date类型时间
	 * @return 毫秒时间戳
	 */
	public static long date2Milliseconds(Date time) {
		return time.getTime();
	}

	/**
	 * 将时间戳转为Date类型
	 * @param milliseconds 毫秒时间戳
	 * @return Date类型时间
	 */
	public static Date milliseconds2Date(long milliseconds) {
		return new Date(milliseconds);
	}

	/**
	 * 毫秒时间戳单位转换（单位：unit）
	 * @param milliseconds 毫秒时间戳
	 * @param unit
	 * @return unit时间戳
	 */
	private static long milliseconds2Unit(long milliseconds, int unit) {
		switch (unit) {
			case UNIT_MSEC:
			case UNIT_SEC:
			case UNIT_MIN:
			case UNIT_HOUR:
			case UNIT_DAY:
				return Math.abs(milliseconds) / unit;
		}
		return -1;
	}

	/**
	 * 获取两个时间差（单位：unit）
	 * <p>time1和time2格式都为yyyy-MM-dd HH:mm:ss</p>
	 * @param time1 时间字符串1
	 * @param time2 时间字符串2
	 * @param unit
	 * @return unit时间戳
	 */
	public static long getIntervalTime(String time1, String time2, int unit) {
		return getIntervalTime(time1, time2, unit, DEFAULT_SDF);
	}

	/**
	 * 获取两个时间差（单位：unit）
	 * <p>time1和time2格式都为format</p>
	 *
	 * @param time1  时间字符串1
	 * @param time2  时间字符串2
	 * @param unit
	 * @param format 时间格式
	 * @return unit时间戳
	 */
	public static long getIntervalTime(String time1, String time2, int unit, SimpleDateFormat format) {
		return milliseconds2Unit(string2Milliseconds(time1, format)
				- string2Milliseconds(time2, format), unit);
	}

	/**
	 * 获取两个时间差（单位：unit）
	 * <p>time1和time2都为Date类型</p>
	 *
	 * @param time1 Date类型时间1
	 * @param time2 Date类型时间2
	 * @param unit
	 * @return unit时间戳
	 */
	public static long getIntervalTime(Date time1, Date time2, int unit) {
		return milliseconds2Unit(date2Milliseconds(time2) - date2Milliseconds(time1), unit);
	}

	/**
	 * 获取当前时间
	 * @return 毫秒时间戳
	 */
	public static long getCurTimeMills() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取当前时间
	 * <p>格式为yyyy-MM-dd HH:mm:ss</p>
	 * @return 时间字符串
	 */
	public static String getCurTimeString() {
		return milliseconds2String(getCurTimeMills());
	}

	/**
	 * 获取当前时间
	 * <p>格式为用户自定义</p>
	 * @param format 时间格式
	 * @return 时间字符串
	 */
	public static String getCurTimeString(SimpleDateFormat format) {
		return milliseconds2String(getCurTimeMills(), format);
	}

	/**
	 * 获取当前时间
	 * <p>Date类型</p>
	 * @return Date类型时间
	 */
	public static Date getCurTimeDate() {
		return new Date();
	}

	/**
	 * 获取与当前时间的差（单位：unit）
	 * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
	 *
	 * @param time 时间字符串
	 * @param unit
	 * @return unit时间戳
	 */
	public static long getIntervalByNow(String time, int unit) {
		return getIntervalByNow(time, unit, DEFAULT_SDF);
	}

	/**
	 * 获取与当前时间的差（单位：unit）
	 * <p>time格式为format</p>
	 *
	 * @param time   时间字符串
	 * @param unit
	 * @param format 时间格式
	 * @return unit时间戳
	 */
	public static long getIntervalByNow(String time, int unit, SimpleDateFormat format) {
		return getIntervalTime(getCurTimeString(), time, unit, format);
	}

	/**
	 * 获取与当前时间的差（单位：unit）
	 * <p>time为Date类型</p>
	 *
	 * @param time Date类型时间
	 * @param unit
	 * @return unit时间戳
	 */
	public static long getIntervalByNow(Date time, int unit) {
		return getIntervalTime(getCurTimeDate(), time, unit);
	}

	/**
	 * 判断闰年
	 * @param year 年份
	 * @return true: 闰年<br>false: 平年
	 */
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}


}
