package Stringprograms.medium;

import java.util.Arrays;

public class LongestCommonPrefixII {

	public static void main(String[] args) {
		
		String str1 = "geeks",str2 = "dgeek";
		
		longestCommonPrefix(str1,str2);

	}

	private static void longestCommonPrefix(String str1, String str2) {
		
		int resultIndex[]=new int[2];
		
		Arrays.fill(resultIndex,-1);
		
		for(int i=1;i<str1.length();i++)
		{
			if(str2.indexOf(str1.substring(0,i))!=-1)
			{
				resultIndex[0]=0;
				resultIndex[1]=i-1;
			}
		}
		
		System.out.println(Arrays.toString(resultIndex));
	}
}
