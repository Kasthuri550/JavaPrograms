package Stringprograms.hard;

public class CountAndSay {

	public static void main(String[] args) {

		int n = 5;

		System.out.println(countAndSayOptimal(n));

	}
	/*
	 * Time Complexity:O(n*m)
	 * Space Complexity: O(m)
	 */
	private static String countAndSayOptimal(int n) {

		String result="1";

		if(n==1) return result;

		for(int i=2;i<=n;i++)
		{
			result=buildNext(result);
		}

		return result;		
	}

	private static String buildNext(String result) {

		StringBuilder sb=new StringBuilder();

		int m=result.length();
		int count=1;

		for(int i=0;i<m-1;i++)
		{
			if(result.charAt(i)==result.charAt(i+1))
			{
				count++;
			}
			else
			{
				sb.append(count).append(result.charAt(i));
				count=1;
			}
		}

		sb.append(count).append(result.charAt(m-1));

		return sb.toString();
	}
}
