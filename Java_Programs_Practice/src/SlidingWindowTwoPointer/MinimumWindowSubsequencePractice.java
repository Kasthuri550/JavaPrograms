package SlidingWindowTwoPointer;

public class MinimumWindowSubsequencePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeksforgeeks", s2 = "eksrg";
		
//		System.out.println(minimumWindowSubsequenceBrute(s1,s2));
		System.out.println(minimumWindowSubsequenceOptimal(s1, s2));
	}
	
	private static String minimumWindowSubsequenceOptimal(String s1, String s2) {
		
		int n=s1.length(),m=s2.length();
		
		if(n<m)
			return "";
		
		int i=0,j=0,minLen=Integer.MAX_VALUE,strIndex=-1;
		
		while(i<n)
		{
			if(s1.charAt(i)==s2.charAt(j))
				j++;
			
			if(j==m)
			{
				int end=i;
				j=m-1;
				
				int k=i;
				
				while(k>=0)
				{
					if(s1.charAt(k)==s2.charAt(j))
					{
						j--;
						
						if(j<0) break;
					}
					
					k--;
				}
				
				if(end-k+1<minLen)
				{
					minLen=end-k+1;
					strIndex=k;
				}
				
				j=0;
				i=k+1;				
			}
			
			i++;
		}
		
		return strIndex==-1?"":s1.substring(strIndex,strIndex+minLen);
	}

	private static String minimumWindowSubsequenceBrute(String s1,String s2)
	{
		int n=s1.length(),minLen=Integer.MAX_VALUE;
		String resultStr="";
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				String substr=s1.substring(i,j+1);
				
				if(isSubsequence(substr,s2))
				{
					if(substr.length()<minLen)
					{
						minLen=substr.length();
						resultStr=substr;
					}
				}
			}
		}
		
		return resultStr;
	}
	
	private static boolean isSubsequence(String s1,String s2)
	{
		int n=s1.length(),m=s2.length(),i=0,j=0;
		
		while(i<n && j<m)
		{
			if(s1.charAt(i) == s2.charAt(j))
					j++;
			
			i++;				
		}
		
		return j==m;
	}
}
