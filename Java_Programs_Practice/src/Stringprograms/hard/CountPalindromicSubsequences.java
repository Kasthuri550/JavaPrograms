package Stringprograms.hard;

import java.util.Arrays;

public class CountPalindromicSubsequences {
	
	private static final int mod=(int)1e9+7;

	public static void main(String[] args) {
		
		String s = "abcd";
		
//		System.out.println(countPalindromicSubsequencesBrute1(s,0,""));
//		System.out.println(countPalindromicSubsequencesBrute2(s,0,s.length()-1));
//		System.out.println(countPalindromicSubsequencesBetter(s));
//		System.out.println(countPalindromicSubsequencesOptimal(s));
		System.out.println(countPalindromicSubsequencesSpaceOptimized(s));

	}

	private static int countPalindromicSubsequencesSpaceOptimized(String s) {

		int n=s.length();
				
		int prev[]=new int[n];
		int curr[]=new int[n];
		
		prev[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            curr[i] = 1;  
            for (int j = i + 1; j < n; j++) {
                long num = prev[j] + curr[j - 1];  
                if (s.charAt(i) == s.charAt(j)) {
                    num++;
                } else {
                    num -= prev[j - 1];
                }
                
                curr[j] = (int) ((num < 0) ? (num + mod) % mod : num % mod);
            }
           
            System.arraycopy(curr, 0, prev, 0, n);
        }
        
        return prev[n - 1];
	}

	private static int countPalindromicSubsequencesOptimal(String s) {

		int n=s.length();
		int dp[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			dp[i][i]=1;
		}
		
		for(int len=2;len<=n;len++)
		{
			for(int start=0;start<=n-len;start++)
			{
				int end=start+len-1;
				if(s.charAt(start)==s.charAt(end))
				{
					dp[start][end]=1+dp[start+1][end]+dp[start][end-1];
				}
				else
				{
					dp[start][end]=dp[start+1][end]+dp[start][end-1]-dp[start+1][end-1];
				}
			}
		}
		return dp[0][n-1];
	}

	private static int countPalindromicSubsequencesBetter(String s) {

		int n=s.length();
		int dp[][]=new int[n][n];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return countPalindromicSubsequencesMemo(s,0,n-1,dp);
	}

	private static int countPalindromicSubsequencesMemo(String s, int start, int end, int[][] dp) {

		if(start>end) return 0;
		
		if(start==end) return 1;
		
		if(dp[start][end]!=-1) return dp[start][end];
		
		if(s.charAt(start)==s.charAt(end))
		{
			dp[start][end]=1+countPalindromicSubsequencesMemo(s, start+1, end, dp)+
					countPalindromicSubsequencesMemo(s, start, end-1, dp);
		}
		else
		{
			dp[start][end]=countPalindromicSubsequencesMemo(s, start+1, end, dp)+
					countPalindromicSubsequencesMemo(s, start, end-1, dp)-
					countPalindromicSubsequencesMemo(s, start+1, end-1, dp);
		}
		
		return dp[start][end];
	}

	private static int countPalindromicSubsequencesBrute2(String s, int start, int end) {

		if(start>end) return 0;
		
		if(start==end) return 1;
		
		if(s.charAt(start)==s.charAt(end))
		{
			return 1+countPalindromicSubsequencesBrute2(s,start+1, end)+countPalindromicSubsequencesBrute2(s, start, end-1);
		}
		
			return countPalindromicSubsequencesBrute2(s, start+1, end)+
					countPalindromicSubsequencesBrute2(s, start, end-1)-
					countPalindromicSubsequencesBrute2(s, start+1, end-1);
	}

	private static int countPalindromicSubsequencesBrute1(String s,int index,String current) {

		if(index==s.length())
		{
			return current.isEmpty()?0:isPalindrome(current)?1:0;
		}
		
		int include=countPalindromicSubsequencesBrute1(s,index+1,current+s.charAt(index));
		
		int exclude=countPalindromicSubsequencesBrute1(s, index+1, current);
		
		return include+exclude;
	}

	private static boolean isPalindrome(String current) {

		int left=0,right=current.length()-1;
		
		while(left<=right)
		{
			if(current.charAt(left)!=current.charAt(right))
			{
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
}
