import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PrintDate {

	public static void main(String[] args) {

		approach1();
	}

	private static void approach1() {
		
		SimpleDateFormat simeplDateFormat=new SimpleDateFormat("EEEE MMMMM mm/dd/yyyy hh:mm:ss.sss aa z D w W G");
		String date = simeplDateFormat.format(new Date());
		Calendar calendar = simeplDateFormat.getCalendar();
		System.out.println(calendar.getTimeZone().getDisplayName());
		System.out.println(date);
	}

}
