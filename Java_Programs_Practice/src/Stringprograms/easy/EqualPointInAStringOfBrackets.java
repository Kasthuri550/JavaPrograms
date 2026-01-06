package Stringprograms.easy;

/*
 * Time Complexity: O(2n)
 * Space Complexity: O(1)
 * */
public class EqualPointInAStringOfBrackets {

	public static void main(String[] args) {

		String  str = "(())))(";

		System.out.println(equalPointBrackets(str));
	}

	private static int equalPointBrackets(String str) {

		int opening=0,closing=0,n=str.length();

		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)==')')
			{
				closing++;
			}
		}

		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)=='(')
			{
				opening++;
			}

			if(str.charAt(i)==')')
			{
				closing--;
			}

			if(opening==closing)
			{
				return i+1;
			}
		}

		return n-1;
	}
}
