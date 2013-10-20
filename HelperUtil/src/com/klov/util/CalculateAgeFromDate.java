package com.klov.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class CalculateAgeFromDate {

	private  final Logger LOG = Logger.getLogger("CalculateAgeFromDate") ;
	/**
	 * 根据生日获取年龄 生日必须是 yyyy-MM-dd
	 * 
	 * @param birthday
	 * @return
	 */
	public Integer getAgeByBirthday(String birthday) {

		Integer age = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birth = format.parse(birthday);
			age = getAge(birth, new Date());
		} catch (ParseException e) {
			LOG.warning(e.getMessage()) ;
		}
		return age;
	}

	/**
	 * 计算年龄 根据生日
	 * 
	 * @param date
	 * @return
	 */
	private int getAge(Date birthDate, Date toDate) {
		int age = 0;
		Calendar birthday = getYearMonthDayCalendar(birthDate);
		Calendar today = getYearMonthDayCalendar(toDate);

		age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		
		birthday.add(Calendar.YEAR, age);
		if (today.before(birthday)) {
			--age;
		}

		if (age == 0) {
			age = 1;
		}
		return age;
	}

	private Calendar getYearMonthDayCalendar(Date birthDate) {
		Calendar birthdayTmp = Calendar.getInstance();
		birthdayTmp.clear();
		birthdayTmp.setTime(birthDate);
		Calendar birthday = Calendar.getInstance();
		birthday.clear();
		birthday.set(birthdayTmp.get(Calendar.YEAR),
				birthdayTmp.get(Calendar.MONTH), birthdayTmp.get(Calendar.DATE));
		return birthday;
	}

}
