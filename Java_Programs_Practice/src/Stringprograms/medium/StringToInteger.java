package Stringprograms.medium;

public class StringToInteger {

	public static void main(String[] args) {
		
		String s = "1337c0d3";
		
		System.out.println(stringToInteger(s));

	}

	private static int stringToInteger(String s) {
		
		int n=s.length(),sign=1,i=0,out=0;
		
		while(i<n && s.charAt(i)==' ')
		{
			i++;
		}
		
		if(i<n && (s.charAt(i)=='-'||s.charAt(i)=='+'))
		{
			sign=(s.charAt(i++)=='-')?-1:1;
		}
		
		while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
		{
			int digit=s.charAt(i++)-'0';
			
			if(out>Integer.MAX_VALUE/10 || out==Integer.MAX_VALUE/10 && digit>7)
			{
				return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			
			out=out*10+digit;
		}
		
		return out*sign;
		
	}
}
