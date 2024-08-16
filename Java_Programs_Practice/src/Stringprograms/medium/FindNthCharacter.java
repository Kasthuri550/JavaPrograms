package Stringprograms.medium;

public class FindNthCharacter {

	public static void main(String[] args) {

		String s = "1100";
		int r = 2, n = 3;

		System.out.println(findNthCharBrute(s,r,n));
		System.out.println(findNthCharOptimal(s, r, n));
	}

	private static char findNthCharOptimal(String s, int r, int n) {

		if(r==0)
		{
			return s.charAt(n);
		}
		char c=findNthCharOptimal(s, r-1, n/2);

		if(n%2!=0)
		{
			if(c=='0') return '1';
			else return '0';
		}
		else
		{
			return c;
		}
	}

	private static char findNthCharBrute(String s, int r, int n) {

		for(int i=0;i<r;i++)
		{
			StringBuilder newStr=new StringBuilder();
			for(char c:s.toCharArray())
			{
				if(c=='0')
				{
					newStr.append("01");
				}
				else
				{
					newStr.append("10");
				}

			}

			s=newStr.toString();
		}

		return s.charAt(n);
	}
}
