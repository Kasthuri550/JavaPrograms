package DynamicProgramming;

import java.util.Arrays;

public class ValidParanthesisChecker {

	public static void main(String[] args) {
		
		String s="(*)";
		
		System.out.println(validParanthesisCheckerRecursion(0,s,0));
		System.out.println(validParanthesisCheckerMemoization(s.length(),s));

	}

	private static boolean validParanthesisCheckerMemoization(int n,String s) {

		Boolean dp[][]=new Boolean[n][2*n+1];
		
				
		return validParanthesisCheckerMemo(0,s,s.length(),0,dp);
	}

	private static boolean validParanthesisCheckerMemo(int index, String s,int n,int balance,Boolean dp[][]) {

		if(balance<-n || balance>n) return false;
		if(index==s.length()) return balance==0;
		
		if (dp[index][balance + n] != null) return dp[index][balance + n];
			
		
		if(s.charAt(index)=='(')
		{
			dp[index][balance+n]=validParanthesisCheckerMemo(index+1, s,n, balance+1, dp);
		}
		else if(s.charAt(index)==')')
		{
			dp[index][balance+n]=validParanthesisCheckerMemo(index+1, s,n, balance-1, dp);
		}
		else
		{
			dp[index][balance+n]=validParanthesisCheckerMemo(index+1, s,n, balance+1, dp)||
					validParanthesisCheckerMemo(index+1, s,n, balance-1, dp)||
					validParanthesisCheckerMemo(index+1, s,n, balance, dp);
		}
		
		return dp[index][balance+n];
	}

	private static boolean validParanthesisCheckerRecursion(int index, String s, int balance) {
		
		if(balance<0) return false;
		if(index==s.length()) return balance==0;
		
		if(s.charAt(index)=='(')
		{
			return validParanthesisCheckerRecursion(index+1, s, balance+1);
		}
		else if(s.charAt(index)==')')
		{
			return validParanthesisCheckerRecursion(index+1, s, balance-1);
		}
		else
		{
			return validParanthesisCheckerRecursion(index+1, s, balance-1)||
					validParanthesisCheckerRecursion(index+1, s, balance+1)||
					validParanthesisCheckerRecursion(index+1, s, balance);
		}
		
	}
}
