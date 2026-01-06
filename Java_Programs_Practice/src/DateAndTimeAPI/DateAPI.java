package DateAndTimeAPI;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate date=LocalDate.now();
		System.out.println(date);
		
		LocalTime time=LocalTime.now();
		System.out.println(time);
				
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println(dateTime);
				
		ZonedDateTime zoneDateTime=ZonedDateTime.now();
		System.out.println(zoneDateTime);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		
		String formatted=dateTime.format(formatter);
		System.out.println(formatted);
		
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate newDate=LocalDate.parse("11/2/2026",formatter1);
		System.out.println(newDate);
		
		OffsetTime offSetTime=OffsetTime.now();
		System.out.println(offSetTime);
		
		OffsetDateTime offSetDateTime=OffsetDateTime.now();
		System.out.println(offSetDateTime);
		
		Clock clock1=Clock.systemDefaultZone();
		System.out.println(clock1.getZone());
		
		Clock clock2=Clock.systemUTC();
		System.out.println(clock2);
		
		ZonedDateTime zdt=ZonedDateTime.now();
		System.out.println(zdt);
		
//		System.out.println(zdt.withZoneSameInstant(ZoneId.of("Asia/kolkata")));
		
		Duration d1 = Duration.ofHours(5);
		Duration d2 = Duration.ofMinutes(30);
		Duration d3 = Duration.ofSeconds(10);

		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		Period period=Period.of(26, 5, 2);
		System.out.println(period);
		
		Duration duration=Duration.between(LocalTime.of(8,11), LocalTime.of(10, 11));
		System.out.println(duration);
		
		
	}
}
