package Stringprograms;

public class ImplementATOI {

	public static void main(String[] args) {
		
		String str ="   -42";		
		System.out.println(atoi1(str));
		System.out.println(atoi2(str));
	}

	private static int atoi2(String str) {
		
		int i=0,strLength=str.length(),sign=1,out=0;
		while(i<strLength && Character.isWhitespace(str.charAt(i)))
		{
			i++;
		}
		if(i<strLength && (str.charAt(i)=='+'||str.charAt(i)=='-'))
		{
			sign=(str.charAt(i)=='-')?-1:1;
			i++;
		}
		while(i<strLength && Character.isDigit(str.charAt(i)))
		{
			int digit=str.charAt(i++)-'0';
			
			if(Integer.MAX_VALUE/10 <out || (Integer.MAX_VALUE/10 == out && digit>7))
			{
				return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			out=out*10+digit;
		}
		return out*sign;
	}

	private static int atoi1(String str) {
		
		int out=0,sign=1;
		
		int strLength=str.length();
		
		for(int i=0;i<strLength;i++)
		{
			if(i==0 && str.charAt(i)==45)
			{
				sign=-1;
				continue;
			}
			if(str.charAt(i)>='0' && str.charAt(i)<='9')
			{
				out=out*10+str.charAt(i)-'0';
			}
			else
			{
				return -1;
			}
		}
		
		return out*sign;
	}
}
