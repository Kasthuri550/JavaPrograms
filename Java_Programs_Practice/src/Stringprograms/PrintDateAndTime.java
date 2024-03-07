package Stringprograms;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrintDateAndTime {

	public static void main(String[] args) {
		
//		dateAndTime1();
//		dateAndTime2();
//		dateAndTime3();
//		dateAndTime4();
		dateAndTime5();
	}

	private static void dateAndTime5() {
		
		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd $ mm $ yyyy");
		String format1 = simpleDateFormat1.format(new java.util.Date());
		System.out.println(format1);		
		
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss z");
		String format2 = simpleDateFormat2.format(new java.util.Date());
		System.out.println(format2);
	}

	private static void dateAndTime4() {
		
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd/mm/yyyy")));
		LocalDate date=LocalDate.of(2023,11,05);
		System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
	}

	private static void dateAndTime3() {
		
		String dateString="2023-11-05";
		Date date = Date.valueOf(dateString);
		System.out.println(date);		
	}

	private static void dateAndTime2() {
		
		GregorianCalendar calendar=new GregorianCalendar();
		int date = calendar.get(Calendar.DATE);
		System.out.println(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month);
		int year = calendar.get(calendar.YEAR);
		System.out.println(year);
		int second = calendar.get(calendar.SECOND);
		System.out.println(second);
		int minute = calendar.get(calendar.MINUTE);
		System.out.println(minute);
		int hour = calendar.get(calendar.HOUR);
		System.out.println(hour);
	}

	private static void dateAndTime1() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		Date date=new Date(currentTimeMillis);
		System.out.println(date);
	}

}
