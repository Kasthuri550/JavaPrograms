package DynamicProgramming;

import java.util.Arrays;

public class NumberOfDistinctWordsWithKMaximumContiguousVowels {
	
	private static final int MOD=(int) (1e9+7);
	private static final int ALPHABETS=26;
	private static final int VOWELS=5;	

	public static void main(String[] args) {
		
		int N = 2,K = 0;
		
		System.out.println(kvowelwordsRecursive(N,K,0));
		System.out.println(kvowelwordsMemo(N,K,0));
		System.out.println(kvowelwordsTabulation(N,K));
		System.out.println(kvowelwordsSpaceOptimized(N, K));

	}

	private static int kvowelwordsSpaceOptimized(int n, int k) {
		
		int prev[]=new int[k+1];
		int curr[]=new int[k+1];
		
		for(int j=0;j<=k;j++)
		{
			prev[j]=1;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<=k;j++)
			{
				curr[j]=prev[k]*(ALPHABETS-VOWELS)%MOD;
				
				if(j>0)
				{
					curr[j]=(curr[j]+prev[j-1]*VOWELS%MOD)%MOD;
				}
			}
			
			prev=curr.clone();
		}
		
		return prev[k];
	}

	private static int kvowelwordsTabulation(int n, int k) {
		
		int dp[][]=new int[n+1][k+1];
		
		for(int j=0;j<=k;j++)
		{
			dp[0][j]=1;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<=k;j++)
			{
				dp[i][j]=(dp[i-1][k]*(ALPHABETS-VOWELS))%MOD;
				
				if(j>0)
				{
					dp[i][j]=(dp[i][j]+dp[i-1][j-1]*VOWELS%MOD)%MOD;
				}
			}
		}
		return dp[n][k];
	}

	private static int kvowelwordsMemo(int n, int k, int currentVowels) {
		
		long memo[][][]=new long[n+1][k+1][currentVowels+1];
		
		for(long layer[][]:memo)
		{
			for(long row[]:layer)
			{
				Arrays.fill(row, -1);
			}
		}
		
		
		return (int)kVowelWordsMemo(n,k,currentVowels,memo);
	}

	private static long kVowelWordsMemo(int n, int k, int currentVowels,long memo[][][]) {
		
		if(n==0)
			return 1;
		
		if(memo[n][k][currentVowels]!=-1)
			return memo[n][k][currentVowels];
		
		long result=(kVowelWordsMemo(n-1, k,0,memo)*(ALPHABETS-VOWELS))%MOD;
		
		if(currentVowels<k)
		{
			result=(result+kVowelWordsMemo(n-1, k, currentVowels+1,memo)*VOWELS)%MOD;
		}
		
		memo[n][k][currentVowels]=result;
		
		return memo[n][k][currentVowels];		
	}

	private static int kvowelwordsRecursive(int n, int k, int currentVowels) {
		
		if(n==0)
			return 1;
		
		int result=(kvowelwordsRecursive(n-1, k, 0)*(ALPHABETS-VOWELS))%MOD;
		
		if(currentVowels<k)
		{
			result=(result+kvowelwordsRecursive(n-1, k, currentVowels+1)*VOWELS)%MOD;
		}
		return result;
	}

}
