package Basicmaths;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class ConvertStringToDate {

	public static void main(String[] args) {
		
		String dateString1="2023/12/05";
		String dateString2="06-12-2023";
		
		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date parseDate1 = simpleDateFormat1.parse(dateString1);
			System.out.println(parseDate1);
			Date parseDate2 = simpleDateFormat2.parse(dateString2);
			System.out.println(parseDate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate date=LocalDate.now();
		
		date.format(formatter);
		
		System.out.println(date);
	}

}
