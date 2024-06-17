package Stringprograms.medium;

import java.util.ArrayList;

public class PrintAllSubstring {

	public static void main(String[] args) {

		String s = "abcd";

		allSubstringBrute(s,s.length());
		allSubstringBetter(s,s.length());
		allSubstringOptimal(s,s.length());

	}

	private static void allSubstringOptimal(String s, int n) {
		
		ArrayList<String> resultList=new ArrayList<String>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				String substr=s.substring(i,j+1);
				resultList.add(substr);
			}
		}
		System.out.println(resultList);
	}

	private static void allSubstringBetter(String s, int n) {

		ArrayList<String> resultList=new ArrayList<String>();

		for(int i=0;i<n;i++)
		{
			String substr="";
			for(int j=i;j<n;j++)
			{
				substr+=s.charAt(j);
				resultList.add(substr);
			}
		}
		
		System.out.println(resultList);
	}

	private static void allSubstringBrute(String s, int n) {

		ArrayList<String> resultList=new ArrayList<String>();

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				String substr="";
				for(int k=i;k<=j;k++)
				{
					substr+=s.charAt(k);
				}
				resultList.add(substr);
			}
		}

		System.out.println(resultList);
	}
}
