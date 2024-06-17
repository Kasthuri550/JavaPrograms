package Stringprograms.easy;

public class CheckStringRotatedByTwoPlaces {

	public static void main(String[] args) {

		String a = "amazon";
		String b = "azonam";
		
		System.out.println(checkStringRotatedBy2Places(a, b));

	}

	private static boolean checkStringRotatedBy2Places(String a, String b) {
		
		int string1Length=a.length(),string2Length=b.length();
		
		if(string1Length!=string2Length)
			return false;
		
		if(string1Length<2)
			return a.equals(b);
		
		String clockwise=a.substring(string1Length-2)+a.substring(0,string1Length-2);
		String antiClockwise=a.substring(2)+a.substring(0,2);
		
		return clockwise.equals(b)||antiClockwise.equals(b);
	}
}
