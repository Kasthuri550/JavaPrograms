package Stringprograms.medium;

public class RotateString {

	public static void main(String[] args) {
		
		String s = "abcde", goal = "cdeab";
		
		System.out.println(checkRotateString(s,goal));

	}

	private static boolean checkRotateString(String s, String goal) {
		
		String s1=s+s;
		
		if(s.length()!=goal.length())
		{
			return false;
		}
		
		if(s1.contains(goal))
		{
			return true;
		}
		
		return false;		
	}
}
