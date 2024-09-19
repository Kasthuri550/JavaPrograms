package DynamicProgramming.mcm;

import java.util.Arrays;

public class EvaluateBooleanExpressionToTrue {
	
	private static final int MOD=(int)1e9+7;

	public static void main(String[] args) {
		
		int n = 7;
		String s = "T|T&F^T";
		
		System.out.println(evaluateBooleanExpressionToTrueRecursion(0,n-1,1,s));
		System.out.println(evaluateBooleanExpressionToTrueMemoization(n,s));
		System.out.println(evaluateBooleanExpressionToTrueTabulation(n, s));

	}

	private static int evaluateBooleanExpressionToTrueTabulation(int n, String s) {
		
		int dp[][][]=new int[n][n][2];
		
		for(int i=n-1;i>=0;i--)
		{
			for(int j=0;j<=n-1;j++)
			{
				if(i>j) continue;
				
				for(int isTrue=0;isTrue<=1;isTrue++)
				{
					if(i==j)
					{
						if(isTrue==1)
						{
							dp[i][j][isTrue]=s.charAt(i)=='T'?1:0;
						}
						else
						{
							dp[i][j][isTrue]=s.charAt(i)=='F'?1:0;
						}
						continue;
					}
					
					int ways=0;
					
					for(int ind=i+1;ind<=j-1;ind+=2)
					{
						int lt=dp[i][ind-1][1];
						int lf=dp[i][ind-1][0];
						int rt=dp[ind+1][j][1];
						int rf=dp[ind+1][j][0];
						
						char operator=s.charAt(ind);
						
						if(operator=='&')
						{
							if(isTrue==1)
								ways=(ways+(lt*rt)%MOD)%MOD;
							else
								ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lf*rf)%MOD)%MOD;
						}
						else if(operator=='|')
						{
							if(isTrue==1)
								ways=(ways+(lt*rt)%MOD+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
							else
								ways=(ways+(lf*rf)%MOD)%MOD;
						}
						else
						{
							if(isTrue==1)
								ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
							else
								ways=(ways+(lt*rt)%MOD+(lf*rf)%MOD)%MOD;
						}
						
						dp[i][j][isTrue]=ways;
					}
				}
			}
		}
		return dp[0][n-1][1];
	}

	private static int evaluateBooleanExpressionToTrueMemoization(int n,String s) {
		
		int dp[][][]=new int[n][n][2];
		
		for(int row1[][]:dp)
		{
			for(int row2[]:row1)
			{
				Arrays.fill(row2,-1);
			}
		}
		
		return evaluateBooleanExpressionToTrueMemo(0,n-1,1,s,dp);
	}

	private static int evaluateBooleanExpressionToTrueMemo(int i, int j, int isTrue, String s,int dp[][][]) {

		if(i>j) return 0;
		
		if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
		
		if(i==j)
		{
			if(isTrue==1)
			{
				return s.charAt(i)=='T'?1:0;
			}
			else
			{
				return s.charAt(i)=='F'?1:0;
			}
		}
		
		int ways=0;
		
		for(int ind=i+1;ind<=j-1;ind++)
		{
			int lt=evaluateBooleanExpressionToTrueMemo(i,ind-1,1,s,dp);
			int lf=evaluateBooleanExpressionToTrueMemo(i,ind-1,0,s,dp);
			int rt=evaluateBooleanExpressionToTrueMemo(ind+1,j,1,s,dp);
			int rf=evaluateBooleanExpressionToTrueMemo(ind+1,j,0,s,dp);
			
			char operator=s.charAt(ind);
			
			if(operator=='&')
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lf*rf)%MOD)%MOD;
				}
			}
			else if(operator=='|')
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lt*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lf*rf)%MOD)%MOD;
				}
			}
			else
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lf*rf)%MOD+(lt*rt)%MOD)%MOD;
				}
			}
		}
		
		return dp[i][j][isTrue]=ways;
	}

	private static int evaluateBooleanExpressionToTrueRecursion(int i, int j, int isTrue, String s) {

		if(i>j) return 0;
		
		if(i==j)
		{
			if(isTrue==1)
			{
				return s.charAt(i)=='T'?1:0;
			}
			else
			{
				return s.charAt(i)=='F'?1:0;
			}
		}
		
		int ways=0;
		
		for(int ind=i+1;ind<=j-1;ind+=2)
		{
			int lt=evaluateBooleanExpressionToTrueRecursion(i,ind-1,1, s);
			int lf=evaluateBooleanExpressionToTrueRecursion(i,ind-1,0, s);
			int rt=evaluateBooleanExpressionToTrueRecursion(ind+1, j,1, s);
			int rf=evaluateBooleanExpressionToTrueRecursion(ind+1, j,0, s);
			
			char operator=s.charAt(ind);
			
			if(operator=='&')
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lf*rf)%MOD)%MOD;
				}
			}
			else if(operator=='|')
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lt*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lf*rf)%MOD)%MOD;
				}
			}
			else
			{
				if(isTrue==1)
				{
					ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
				}
				else
				{
					ways=(ways+(lt*rt)%MOD+(lf*rf)%MOD)%MOD;
				}
			}
		}
		
		return ways;
	}
}
