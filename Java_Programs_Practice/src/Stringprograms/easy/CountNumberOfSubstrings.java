package Stringprograms.easy;

public class CountNumberOfSubstrings {

	public static void main(String[] args) {
		
		String str="abcabc";
		
		bruteForce(str);
		better(str);
		optimal(str);

	}

	private static void optimal(String str) {
		
		int n=str.length();
		
		System.out.println(n*(n+1)/2);
	}

	private static void better(String str) {
		
		int n=str.length(),count=0;
		
		for(int i=0;i<n;i++)
		{
			count+=n-i;
		}
		
		System.out.println(count);
	}

	private static void bruteForce(String str) {
		
		int n=str.length(),count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				count++;
			}
		}
		
		System.out.println(count);
	}
}
