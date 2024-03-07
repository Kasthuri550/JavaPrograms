package Stringprograms;

public class PrintAllSubstring {

	public static void main(String[] args) {
		
		String str="hello";
		
//		printSubstring1(str);
//		printSubstring2(str);
//		printSubstring3(str);
		printSubstring4(str);
	}

	private static void printSubstring4(String str) {
		
		for(int i=0;i<str.length();i++)
		{
			StringBuilder sb=new StringBuilder();
			for(int j=i;j<str.length();j++)
			{
				sb.append(str.charAt(j));
				System.out.println(sb);
			}
		}
		
	}

	private static void printSubstring3(String str) {
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
			{
				for(int k=i;k<j;k++)
				{
					System.out.print(str.charAt(k));
				}
				System.out.println();
			}
		}	
	}

	private static void printSubstring2(String str) {
		
		int length=str.length();
		for(int i=0;i<length;i++)
		{
			for(int j=i+1;j<=length;j++)
			{
				substring(str,i,j);
				System.out.println();
			}
		}
	}

	private static void substring(String str, int start, int end) {
		
		for(int i=start;i<end;i++)
		{
			System.out.print(str.charAt(i));
		}
		
	}

	private static void printSubstring1(String str) {
		
		int n=str.length();
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				System.out.println(str.substring(i,j));
			}
		}
		
	}

}
