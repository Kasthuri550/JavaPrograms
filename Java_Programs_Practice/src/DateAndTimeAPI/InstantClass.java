package DateAndTimeAPI;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class InstantClass {

	public static void main(String[] args) {
		
		Instant instant=Instant.now();
		System.out.println(instant);
		
		Instant start=Instant.now();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Instant end=Instant.now();
		
		Duration diff=Duration.between(start,end);
		System.out.println(diff);
		
		System.out.println(start.plusSeconds(100));
		System.out.println(end.minusSeconds(150));
		
		
		LocalDateTime dateTime=LocalDateTime.ofInstant(start,ZoneId.systemDefault());
		System.out.println(dateTime);
		
		LocalDateTime myTime=LocalDateTime.now();
		
		Instant myInstant=myTime.atZone(ZoneId.systemDefault()).toInstant();
		System.out.println(myInstant);
	}
}
