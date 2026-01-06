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
	
	
	public int myAtoi(String s) {
        // Initialize index, sign, and result
        int i = 0, sign = 1;
         // Use long to prevent overflow
        long res = 0;

        // Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Return 0 if only spaces are found
        if (i == s.length()) return 0;

        // Check for optional '+' or '-' sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Convert characters to integer while valid digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');

            // Clamp to Integer.MAX_VALUE if overflow
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            // Clamp to Integer.MIN_VALUE if underflow
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        // Return final result after applying sign
        return (int)(sign * res);
    }
}
