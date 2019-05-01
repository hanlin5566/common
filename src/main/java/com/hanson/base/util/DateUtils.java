package com.hanson.base.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by hanlin on 2017年11月9日
 **/
public class DateUtils {
	public static final String ISO_DATE = "yyyy-MM-dd";
	public static final String ISO_DATE_TIME = "yyyy-MM-dd hh:mm";
	public static Date getTomorrow(Date date){
		Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.add(Calendar.DAY_OF_MONTH, 1);// 明天
        Date tomorrow = c.getTime();
		return tomorrow; 
	}



	//日期验证
	public static Map<String, Object> validate(String bTime, String eTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);

		Date beginTime, endTime;
			if (StringUtils.isNotNull(bTime) && StringUtils.isNotNull(eTime)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					beginTime = sdf.parse(bTime);
					endTime = sdf.parse(eTime);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(endTime);
					calendar.set(Calendar.HOUR_OF_DAY, 24);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					endTime = calendar.getTime();

					map.put("beginTime", beginTime);
					map.put("endTime", endTime);
				} catch (Exception e) {
					map.put("success", false);
					return map;
				}
			} else {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			beginTime = calendar.getTime();

			calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 24);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			endTime = calendar.getTime();
			map.put("beginTime", beginTime);
			map.put("endTime", endTime);
		}
		if (beginTime.getTime() > endTime.getTime()) {
			map.put("success", false);
		}

		return map;
	}


	public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";



//计算给开始日期 结束日期 的间隔天数 yyyy-MM-dd

	public static int getDayLength(String start_date,String end_date) throws Exception{

		Date fromDate = getStrToDate(start_date,DATE_FORMAT_NORMAL);  //开始日期
		Date toDate = getStrToDate(end_date,DATE_FORMAT_NORMAL); //结束日期
		long from = fromDate.getTime();
		long to = toDate.getTime();

		//一天等于多少毫秒：24*3600*1000

		int day = (int)((to-from)/(24*60*60*1000));
		return day;

	}

	public static Date getStrToDate(String start_date) throws Exception{

		Date fromDate = getStrToDate(start_date,DATE_FORMAT_NORMAL);  //开始日期

		return fromDate;

	}



	public static Date getStrToDate(String date,String fomtter) throws Exception{
		DateFormat df = new SimpleDateFormat(fomtter);
		return df.parse(date);
	}


	/**
	 * 获取两个日期之间的日期
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合
	 */
	public static List<Date> getBetweenDates(Date start, Date end) {
		List<Date> result = new ArrayList<Date>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(tempStart.getTime());
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}


		return result;
	}


}
