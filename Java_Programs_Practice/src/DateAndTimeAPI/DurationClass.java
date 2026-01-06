package DateAndTimeAPI;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationClass {

	public static void main(String[] args) {
		
		Duration hours=Duration.ofHours(5);
		System.out.println(hours);
		System.out.println(hours.toHours());
		
		Duration minutes=Duration.ofMinutes(30);
		System.out.println(minutes);
		System.out.println(minutes.toMinutes());
		
		Duration seconds=Duration.ofSeconds(60);
		System.out.println(seconds);
		System.out.println(seconds.toNanos());
		
		
		LocalDateTime start = LocalDateTime.of(2025, 1, 1, 10, 0);
		LocalDateTime end   = LocalDateTime.of(2025, 1, 1, 12, 30);
		
		Duration duration=Duration.between(start,end);
		System.out.println(duration.toHours());
		System.out.println(duration.toMinutes());
		
		
		LocalDateTime future=LocalDateTime.now();
		System.out.println(future.plus(Duration.ofHours(4)));
		
		LocalDateTime past=LocalDateTime.now();
		System.out.println(past.minus(Duration.ofHours(24)));
	}
}
