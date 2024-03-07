package Stringprograms;

public class RotateString {

	public static void main(String[] args) {
		
		String s = "abcde", goal = "abced";
		System.out.println(rotate(s,goal));
	}

	private static boolean rotate(String s, String goal) {
		
		String s1=s+s;
		
		for(int i=0;i<s.length();i++)
		{
			boolean flag=true;
			for(int j=0;j<s.length();j++)
			{
				if(s1.charAt(i+j)!=goal.charAt(j))
				{
					flag=false;
					break;
				}
			}
			if(flag)
			{
				return true;
			}
		}
		
		return false;
		
	}

}
