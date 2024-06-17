package Stringprograms.easy;

import java.util.Arrays;

public class LongestCommonPrefixI {

	public static void main(String[] args) {
		
		String str1 = "practice",str2 = "coderpractice";
		
//		System.out.println(Arrays.toString(longestCommonPrefixI(str1,str2)));
		
		System.out.println(Arrays.toString(longestCommonPrefixII(str1,str2)));

	}

	private static int[] longestCommonPrefixII(String str1, String str2) {
		
		int start=-1,end=-1;
		
		for(int i=0;i<str1.length();i++)
		{
			if(str1.charAt(i)==str2.charAt(i))
			{
				if(start==-1)
				{
					start=i;
				}
				end=i;
			}
			else
			{
				break;
			}
		}
		return new int[] {start,end};
	}

	private static int[] longestCommonPrefixI(String str1, String str2) {
		
		int result[]=new int[2];
		Arrays.fill(result,-1);
		
		for(int i=1;i<str1.length();i++)
		{
			if(str2.indexOf(str1.substring(0,i))!=-1)
			{
				result[0]=0;
				result[1]=i-1;
			}
		}
		
		return result;		
	}
}
