package Stringprograms.medium;

public class MaximumNestingDepthParentheses {

	public static void main(String[] args) {
		
		String s = "(1+(2*3)+((8)/4))+1";
		
		maxNestingDepth(s);

	}

	private static void maxNestingDepth(String s) {
		
		int n=s.length(),count=0,max=0;
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='(')
			{
				count++;
			}
			
			if(s.charAt(i)==')')
			{
				count--;
			}
			
			max=Math.max(max,count);
		}
		
		System.out.println(max);
		
	}
}
