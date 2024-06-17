package DateAndTimeAPI;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTime {

	public static void main(String[] args) {
		
		LocalDate localDate=LocalDate.now();
		System.out.println(localDate);
		
		int day=localDate.getDayOfMonth();
		int month=localDate.getMonthValue();
		int year=localDate.getYear();
		
		System.out.printf("%d-%d-%d",day,month,year);
		
		LocalTime localTime=LocalTime.now();
		System.out.println(localTime);
		
		int hour=localTime.getHour();
		int minute=localTime.getMinute();
		int second=localTime.getSecond();
		int nanoSecond=localTime.getNano();
		
		System.out.printf("%d-%d-%d-%d",hour,minute,second,nanoSecond);
		System.out.println();
		LocalDateTime localDateTime=LocalDateTime.now();
		System.out.println(localDateTime);
		int d=localDateTime.getDayOfMonth();
		int m=localDateTime.getMonthValue();
		int y=localDateTime.getYear();
		System.out.printf("%d-%d-%d",d,m,y);
		
		int hr=localDateTime.getHour();
		int min=localDateTime.getMinute();
		int sec=localDateTime.getSecond();
		int nano=localDateTime.getNano();
		System.out.println();
		System.out.printf("%d:%d:%d:%d",hr,min,sec,nano);
		
		LocalDateTime localDateTime2=LocalDateTime.of(1998,Month.MAY,17,12,45);
		System.out.println(localDateTime2);
		System.out.println(localDateTime2.plusMonths(5));
		System.out.println(localDateTime2.minusMonths(5));
		
		Period period=Period.of(2024,05,19);
		System.out.println(period);
		
		LocalDate today=LocalDate.now();
		LocalDate birthday=LocalDate.of(1998,05,17);
		
		Period p=Period.between(birthday,today);
		
		System.out.println(p.getYears()+" "+p.getMonths()+" "+p.getDays());
		
		LocalDate deathDate=LocalDate.of(1998+60,05,17);
		
		LocalDate currentDate=LocalDate.now();
		
		Period livingPeriod=Period.between(currentDate,deathDate);
		System.out.println(livingPeriod.getYears()+" "+livingPeriod.getMonths()+" "+livingPeriod.getDays());
		
		Year currentYear=Year.of(2021);
		
		if(currentYear.isLeap())
		{
			System.out.println("Leap year");
		}
		else
		{
			System.out.println("Not leap year");
		}
		
		ZoneId zoneId1=ZoneId.systemDefault();
		System.out.println(zoneId1);
		
		ZoneId zoneId=ZoneId.of("America/Los_Angeles");
		ZonedDateTime zonedDateTime=ZonedDateTime.now(zoneId);
		System.out.println(zonedDateTime);

	}
}
