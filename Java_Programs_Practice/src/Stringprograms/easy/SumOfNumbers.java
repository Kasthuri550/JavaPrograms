package Stringprograms.easy;

public class SumOfNumbers {

	public static void main(String[] args) {
		
		String str="1abc23";
		
		System.out.println(sum(str));
	}

	private static int sum(String str) {

		int result=0;
		int sum=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='0' && str.charAt(i)<='9')
			{
				result=result*10+str.charAt(i)-'0';
			}
			else
			{
				sum+=result;
				result=0;
			}
		}
		
		return sum+result;
	}

}
