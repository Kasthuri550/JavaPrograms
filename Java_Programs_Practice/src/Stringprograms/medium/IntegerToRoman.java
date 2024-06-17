package Stringprograms.medium;

public class IntegerToRoman {

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(intToRoman(n));

	}

	private static String intToRoman(int n) {
		
		String units[]= {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String tens[]= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String hundreds[]= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String thousands[]= {"","M","MM","MMM"};
		
		return thousands[n/1000]+hundreds[(n%1000)/100]+tens[(n%100)/10]+units[n%10];		
	}

}
