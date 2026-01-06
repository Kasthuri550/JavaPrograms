package DateAndTimeAPI;

import java.time.LocalDate;
import java.time.Period;

public class PeriodClass {

	public static void main(String[] args) {
		
		Period p1=Period.of(25,10,10);
		System.out.println(p1);
		System.out.println(p1.getYears());
		System.out.println(p1.getMonths());
		System.out.println(p1.getDays());
		
		Period p2=Period.between(LocalDate.of(1998,05,17), LocalDate.now());
		System.out.println(p2.getYears()+" years "+p2.getMonths()+" months "+p2.getDays()+" days");
	
		LocalDate date1=LocalDate.now();
		System.out.println(date1.plus(Period.ofMonths(3)));
		System.out.println(date1.minus(Period.ofWeeks(50)));
		
		
		Period p = Period.between(
			    LocalDate.of(2025, 1, 31),
			    LocalDate.of(2025, 2, 1)
			);

			System.out.println(p.getDays());
	}
}
