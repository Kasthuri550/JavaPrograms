package Stringprograms.medium;

public class MyAtoi {

	public static void main(String[] args) {
		
		String s = " -042";
		
		System.out.println(atoi(s));

	}

	private static int atoi(String s) {
		
		int n=s.length(),i=0,sign=1,out=0;
		
		while(i<n && Character.isWhitespace(s.charAt(i)))
		{
			i++;
		}
		
		if(i<n && (s.charAt(i)=='+'||s.charAt(i)=='-'))
		{
			sign=(s.charAt(i++)=='-')?-1:1;
		}
		
		while(i<n && Character.isDigit(s.charAt(i)))
		{
			int digit=s.charAt(i++)-'0';
			
			if(out>Integer.MAX_VALUE/10 || out==Integer.MAX_VALUE/10 && digit>7)
			{
				return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			out=out*10+digit;
		}
		
		return out*sign;
		
	}

}
