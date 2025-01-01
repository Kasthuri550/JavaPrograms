package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubsequence {

	public static void main(String[] args) {

		String s1 = "timetopractice", s2 = "toc";


		System.out.println(minimumWindowSubsequenceBrute(s1,s2));
		System.out.println(minimumWindowSubsequenceBetter(s1, s2));
		System.out.println(minimumWindowSubsequenceOptimalI(s1, s2));
	}
	/*
	 * Time Complexity: O(n+m)
	 * Space Complexity: O(1)
	 */
	private static String minimumWindowSubsequenceOptimalI(String s1, String s2) {

		if (s1.length() < s2.length()) return "";

        HashMap<Character, Integer> requiredFreq = new HashMap<>();
        for (char c : s2.toCharArray()) {
            requiredFreq.put(c, requiredFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int matchedCount = 0;
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        while (right < s1.length()) {
            char rightChar = s1.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            if (requiredFreq.containsKey(rightChar) &&
                windowFreq.get(rightChar).intValue() == requiredFreq.get(rightChar).intValue()) {
                matchedCount++;
            }

            while (matchedCount == requiredFreq.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s1.charAt(left);
                
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (requiredFreq.containsKey(leftChar) &&
                    windowFreq.get(leftChar).intValue() < requiredFreq.get(leftChar).intValue()) {
                    matchedCount--;
                }
                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s1.substring(startIndex, startIndex + minLength);
	}
	/*
	 * Time Complexity: O(n*m)
	 * Space Complexity: O(n*m)
	 */
	private static String minimumWindowSubsequenceBetter(String s1, String s2) {

		int n=s1.length(),m=s2.length();

		int dp[][]=new int[n+1][m+1];

		for(int i=0;i<=n;i++)
		{
			dp[i][0]=i;
		}

		for(int j=0;j<=m;j++)
		{
			dp[0][j]=-1;
		}

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}

		int minLength=Integer.MAX_VALUE,start=-1,end=-1;
		for(int i=1;i<=n;i++)
		{
			if(dp[i][m]!=-1)
			{
				if(i-dp[i][m]<minLength)
				{
					minLength=i-dp[i][m];
					start=dp[i][m];
					end=i-1;
				}
			}
		}

		String result="";

		for(int i=start;i<=end;i++)
		{
			result=result+s1.charAt(i);
		}

		return result;
	}
	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 */
	private static String minimumWindowSubsequenceBrute(String s1, String s2) {

		int n=s1.length(),minLength=Integer.MAX_VALUE,start=-1,end=-1;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(isSubsequence(s1,s2,i,j))
				{
					if(j-i+1<minLength)
					{
						minLength=j-i+1;
						start=i;
						end=j;
					}
				}
			}
		}

		if(start==-1) return "";

		String result="";
		for(int i=start;i<=end;i++)
		{
			result=result+s1.charAt(i);
		}

		return result;
	}

	private static boolean isSubsequence(String s1, String s2, int start, int end) {

		int j=0;

		for(int i=start;i<=end && j<s2.length();i++)
		{
			if(s1.charAt(i)==s2.charAt(j))
			{
				j++;
			}
		}
		return s2.length()==j;
	}

}
