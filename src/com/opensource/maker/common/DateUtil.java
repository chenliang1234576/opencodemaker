package com.opensource.maker.common;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

 import org.apache.log4j.Logger;

 
 /***
  *  ���ڴ�������
  * @date      2015.8.28
  * @author  ����
  * ***/
public class DateUtil {
	// ~ Static fields/initializers
	// =============================================

	private static Logger logger = Logger.getLogger(DateUtil.class);
	private static String defaultDatePattern = null;
	private static String timePattern = "HH:mm";
	private static Calendar cale = Calendar.getInstance();
	public static final String TS_FORMAT = DateUtil.getDatePattern() + " HH:mm:ss.S";
	/** ���ڸ�ʽyyyy-MM�ַ������� */
	private static final String MONTH_FORMAT = "yyyy-MM";
	/** ���ڸ�ʽyyyy-MM-dd�ַ������� */
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	/** ���ڸ�ʽHH:mm:ss�ַ������� */
	private static final String HOUR_FORMAT = "HH:mm:ss";
	/** ���ڸ�ʽyyyy-MM-dd HH:mm:ss�ַ������� */
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** ĳ�쿪ʼʱ�����ַ�������  00:00:00 */
	private static final String DAY_BEGIN_STRING_HHMMSS = " 00:00:00";
	/**  ĳ�����ʱ�����ַ�������  23:59:59  */
	public static final String DAY_END_STRING_HHMMSS = " 23:59:59";
	private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);
	private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);
	private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);
	

	// ~ Methods
	// ================================================================

	public DateUtil() {
	}

	/**
	 * ��÷�������ǰ���ڼ�ʱ�䣬�Ը�ʽΪ��yyyy-MM-dd HH:mm:ss�������ַ�����ʽ����
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getDateTime() {
		try {
			return sdf_datetime_format.format(cale.getTime());
		} catch (Exception e) {
			logger.debug("DateUtil.getDateTime():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ��÷�������ǰ���ڣ��Ը�ʽΪ��yyyy-MM-dd�������ַ�����ʽ����
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getDate() {
		try {
			return sdf_date_format.format(cale.getTime());
		} catch (Exception e) {
			logger.debug("DateUtil.getDate():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ��÷�������ǰʱ�䣬�Ը�ʽΪ��HH:mm:ss�������ַ�����ʽ����
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getTime() {
		String temp = " ";
		try {
			temp += sdf_hour_format.format(cale.getTime());
			return temp;
		} catch (Exception e) {
			logger.debug("DateUtil.getTime():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ͳ��ʱ��ʼ���ڵ�Ĭ��ֵ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getStartDate() {
		try {
			return getYear() + "-01-01";
		} catch (Exception e) {
			logger.debug("DateUtil.getStartDate():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ͳ��ʱ�������ڵ�Ĭ��ֵ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getEndDate() {
		try {
			return getDate();
		} catch (Exception e) {
			logger.debug("DateUtil.getEndDate():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ��÷�������ǰ���ڵ����
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getYear() {
		try {
			return String.valueOf(cale.get(Calendar.YEAR));
		} catch (Exception e) {
			logger.debug("DateUtil.getYear():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ��÷�������ǰ���ڵ��·�
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getMonth() {
		try {
			java.text.DecimalFormat df = new java.text.DecimalFormat();
			df.applyPattern("00;00");
			return df.format((cale.get(Calendar.MONTH) + 1));
		} catch (Exception e) {
			logger.debug("DateUtil.getMonth():" + e.getMessage());
			return "";
		}
	}

	/**
	 * ��÷������ڵ�ǰ��������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getDay() {
		try {
			return String.valueOf(cale.get(Calendar.DAY_OF_MONTH));
		} catch (Exception e) {
			logger.debug("DateUtil.getDay():" + e.getMessage());
			return "";
		}
	}

	/**
	 * �Ƚ�����������������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMargin(String date1, String date2) {
		int margin;
		try {
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos1 = new ParsePosition(0);
			Date dt1 = sdf_date_format.parse(date1, pos);
			Date dt2 = sdf_date_format.parse(date2, pos1);
			long l = dt1.getTime() - dt2.getTime();
			margin = (int) (l / (24 * 60 * 60 * 1000));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtil.getMargin():" + e.toString());
			return 0;
		}
	}

	/**
	 * �Ƚ�����������������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double getDoubleMargin(String date1, String date2) {
		double margin;
		try {
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos1 = new ParsePosition(0);
			Date dt1 = sdf_datetime_format.parse(date1, pos);
			Date dt2 = sdf_datetime_format.parse(date2, pos1);
			long l = dt1.getTime() - dt2.getTime();
			margin = (l / (24 * 60 * 60 * 1000.00));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtil.getMargin():" + e.toString());
			return 0;
		}
	}

	/**
	 * �Ƚ�����������������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonthMargin(String date1, String date2) {
		int margin;
		try {
			margin = (Integer.parseInt(date2.substring(0, 4)) - Integer.parseInt(date1.substring(0, 4))) * 12;
			margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0",
					"-")) - Integer.parseInt(date1.substring(4, 7).replaceAll("-0", "-")));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtil.getMargin():" + e.toString());
			return 0;
		}
	}

	/**
	 * �������ڼ�X��������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date
	 * @param i
	 * @return
	 */
	public static String addDay(String date, int i) {
		try {
			GregorianCalendar gCal = new GregorianCalendar(
					Integer.parseInt(date.substring(0, 4)), 
					Integer.parseInt(date.substring(5, 7)) - 1, 
					Integer.parseInt(date.substring(8, 10)));
			gCal.add(GregorianCalendar.DATE, i);
			return sdf_date_format.format(gCal.getTime());
		} catch (Exception e) {
			logger.debug("DateUtil.addDay():" + e.toString());
			return getDate();
		}
	}

	/**
	 * �������ڼ�X�º������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date
	 * @param i
	 * @return
	 */
	public static String addMonth(String date, int i) {
		try {
			GregorianCalendar gCal = new GregorianCalendar(
					Integer.parseInt(date.substring(0, 4)), 
					Integer.parseInt(date.substring(5, 7)) - 1, 
					Integer.parseInt(date.substring(8, 10)));
			gCal.add(GregorianCalendar.MONTH, i);
			return sdf_date_format.format(gCal.getTime());
		} catch (Exception e) {
			logger.debug("DateUtil.addMonth():" + e.toString());
			return getDate();
		}
	}

	/**
	 * �������ڼ�X��������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param date
	 * @param i
	 * @return
	 */
	public static String addYear(String date, int i) {
		try {
			GregorianCalendar gCal = new GregorianCalendar(
					Integer.parseInt(date.substring(0, 4)), 
					Integer.parseInt(date.substring(5, 7)) - 1, 
					Integer.parseInt(date.substring(8, 10)));
			gCal.add(GregorianCalendar.YEAR, i);
			return sdf_date_format.format(gCal.getTime());
		} catch (Exception e) {
			logger.debug("DateUtil.addYear():" + e.toString());
			return "";
		}
	}

	/**
	 * ����ĳ��ĳ���е������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMaxDay(int iyear, int imonth) {
		int day = 0;
		try {
			if (imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7
					|| imonth == 8 || imonth == 10 || imonth == 12) {
				day = 31;
			} else if (imonth == 4 || imonth == 6 || imonth == 9 || imonth == 11) {
				day = 30;
			} else if ((0 == (iyear % 4)) && (0 != (iyear % 100)) || (0 == (iyear % 400))) {
				day = 29;
			} else {
				day = 28;
			}
			return day;
		} catch (Exception e) {
			logger.debug("DateUtil.getMonthDay():" + e.toString());
			return 1;
		}
	}

	/**
	 * ��ʽ������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param orgDate
	 * @param Type
	 * @param Span
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String rollDate(String orgDate, int Type, int Span) {
		try {
			String temp = "";
			int iyear, imonth, iday;
			int iPos = 0;
			char seperater = '-';
			if (orgDate == null || orgDate.length() < 6) {
				return "";
			}

			iPos = orgDate.indexOf(seperater);
			if (iPos > 0) {
				iyear = Integer.parseInt(orgDate.substring(0, iPos));
				temp = orgDate.substring(iPos + 1);
			} else {
				iyear = Integer.parseInt(orgDate.substring(0, 4));
				temp = orgDate.substring(4);
			}

			iPos = temp.indexOf(seperater);
			if (iPos > 0) {
				imonth = Integer.parseInt(temp.substring(0, iPos));
				temp = temp.substring(iPos + 1);
			} else {
				imonth = Integer.parseInt(temp.substring(0, 2));
				temp = temp.substring(2);
			}

			imonth--;
			if (imonth < 0 || imonth > 11) {
				imonth = 0;
			}

			iday = Integer.parseInt(temp);
			if (iday < 1 || iday > 31)
				iday = 1;

			Calendar orgcale = Calendar.getInstance();
			orgcale.set(iyear, imonth, iday);
			temp = this.rollDate(orgcale, Type, Span);
			return temp;
		} catch (Exception e) {
			return "";
		}
	}

	public static String rollDate(Calendar cal, int Type, int Span) {
		try {
			String temp = "";
			Calendar rolcale;
			rolcale = cal;
			rolcale.add(Type, Span);
			temp = sdf_date_format.format(rolcale.getTime());
			return temp;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * ����Ĭ�ϵ����ڸ�ʽ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static synchronized String getDatePattern() {
		defaultDatePattern = "yyyy-MM-dd";
		return defaultDatePattern;
	}

	/**
	 * ��ָ�����ڰ�Ĭ�ϸ�ʽ���и�ʽ�������ַ���������磺yyyy-MM-dd
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param aDate
	 * @return
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * ȡ�ø������ڵ�ʱ���ַ�������ʽΪ��ǰĬ��ʱ���ʽ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param theTime
	 * @return
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * ȡ�õ�ǰʱ���Calendar��������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 * @throws ParseException
	 */
	public Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));
		return cal;
	}

	/**
	 * ��������ת����ָ����ʽ���ַ�����ʽ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param aMask
	 * @param aDate
	 * @return
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			logger.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * ��ָ��������ת����Ĭ�ϸ�ʽ���ַ�����ʽ
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * �������ַ�����ָ����ʽת������������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param aMask ָ�������ڸ�ʽ����:yyyy-MM-dd
	 * @param strDate ��ת���������ַ���
	 * @return
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (logger.isDebugEnabled()) {
			logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			logger.error("ParseException: " + pe);
			throw pe;
		}
		return (date);
	}

	/**
	 * �������ַ�����Ĭ�ϸ�ʽת������������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			if (logger.isDebugEnabled()) {
				logger.debug("converting date with pattern: " + getDatePattern());
			}
			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			logger.error("Could not convert '" + strDate + "' to a date, throwing exception");
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
		return aDate;
	}

	/**
	 * ����һ��JAVA�����͵������ַ���
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getSimpleDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat();
		String NDateTime = formatter.format(new Date());
		return NDateTime;
	}
	
	/**
	 * ��ָ���ַ�����ʽ�������뵱ǰʱ��Ƚ�
	 * @author DYLAN
	 * @date Feb 17, 2012
	 * @param strDate ��Ҫ�Ƚ�ʱ��
	 * @return 
	 * 		<p>
	 * 		int code
	 * 		<ul>
	 * 		<li>-1 ��ǰʱ�� < �Ƚ�ʱ�� </li>
	 * 		<li> 0 ��ǰʱ�� = �Ƚ�ʱ�� </li>
	 * 		<li>>=1��ǰʱ�� > �Ƚ�ʱ�� </li>
	 * 		</ul>
	 * 		</p>
	 */
	public static int compareToCurTime (String strDate) {
		if (strDate == null || strDate.trim().equals("")) {
			return -1;
		}
		Date curTime = cale.getTime();
		String strCurTime = null;
		try {
			strCurTime = sdf_datetime_format.format(curTime);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("[Could not format '" + strDate + "' to a date, throwing exception:" + e.getLocalizedMessage() + "]");
			}
		} 
	   if (strCurTime == null || strCurTime.trim().equals("")) {
			return strCurTime.compareTo(strDate);
		}
		return -1;
	}
	
	/**
	 * Ϊ��ѯ���������Сʱ��
	 * 
	 * @param Ŀ������Date
	 * @param ת������Date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date addStartTime(Date param) {
		Date date = param;
		try {
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			return date;
		} catch (Exception ex) {
			return date;
		}
	}

	/**
	 * Ϊ��ѯ����������ʱ��
	 * 
	 * @param Ŀ������Date
	 * @param ת������Date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date addEndTime(Date param) {
		Date date = param;
		try {
			date.setHours(23);
			date.setMinutes(59);
			date.setSeconds(0);
			return date;
		} catch (Exception ex) {
			return date;
		}
	}

	/**
	 * ����ϵͳ���������ָ���·ݵ�����
	 * 
	 * @param �·�month
	 * @return ָ���µ�������
	 */
	@SuppressWarnings("deprecation")
	public static String getMonthLastDay(int month) {
		Date date = new Date();
		int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
				{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
		int year = date.getYear() + 1900;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return day[1][month] + "";
		} else {
			return day[0][month] + "";
		}
	}

	/**
	 * ����ָ�������ָ���·ݵ�����
	 * 
	 * @param ���year
	 * @param �·�month
	 * @return ָ���µ�������
	 */
	public static String getMonthLastDay(int year, int month) {
		int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
				{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return day[1][month] + "";
		} else {
			return day[0][month] + "";
		}
	}

	/**
	 * �ж���ƽ�껹������
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @param year
	 * @return
	 */	
	public static boolean isLeapyear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ȡ�õ�ǰʱ����մ�
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getTimestamp() {
		Date date = cale.getTime();
		String timestamp = "" + (date.getYear() + 1900) + date.getMonth()
				+ date.getDate() + date.getMinutes() + date.getSeconds()
				+ date.getTime();
		return timestamp;
	}

	/**
	 * ȡ��ָ��ʱ����մ�
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getTimestamp(Date date) {
		String timestamp = "" + (date.getYear() + 1900) + date.getMonth()
				+ date.getDate() + date.getMinutes() + date.getSeconds()
				+ date.getTime();
		return timestamp;
	}

	public static void main(String[] args) {
		System.out.println(getYear() + "|" + getMonth() + "|" + getDate());
	}
}
