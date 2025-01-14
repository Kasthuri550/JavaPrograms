package Stringprograms.hard;

import java.util.ArrayList;

public class KMPAlgo {

	public static void main(String[] args) {

		String txt="abxabcabcaby",pattern="abcaby";

		//		String txt = "abcab", pattern = "ab";

		System.out.println(kmpBrute(txt,pattern));
		System.out.println(kmpOptimal(txt,pattern));

	}
	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(1)
	 */	
	private static ArrayList<Integer> kmpBrute(String txt, String pattern) {

		int m=txt.length(),n=pattern.length();
		ArrayList<Integer> result=new ArrayList<Integer>();

		for(int i=0;i<=m-n;i++)
		{
			int j;
			for(j=0;j<n;j++)
			{
				if(txt.charAt(i+j)!=pattern.charAt(j))
				{
					break;
				}
			}

			if(j==n)
			{
				result.add(i);
			}
		}

		return result;
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(n)
	 */	
	private static ArrayList<Integer> kmpOptimal(String txt, String pattern) {

		int m=txt.length(),n=pattern.length();

		int lps[]=new int[n];

		buildLPS(pattern,n,lps);

		int i=0,j=0;

		ArrayList<Integer> result=new ArrayList<>();

		while(i<m)
		{
			if(txt.charAt(i)==pattern.charAt(j))
			{
				i++;
				j++;
			}

			if(j==n)
			{
				result.add(i-j);
				j=lps[j-1];
			}
			else if(i<m && txt.charAt(i)!=pattern.charAt(j))
			{
				if(j!=0)
				{
					j=lps[j-1];
				}
				else
				{
					i++;
				}
			}
		}

		return result;		
	}

	private static void buildLPS(String pattern,int n,int lps[]) {

		int i=0,j=1;


		while(j<n)
		{
			if(pattern.charAt(i)==pattern.charAt(j))
			{
				i++;
				lps[j]=i;
				j++;
			}
			else
			{
				if(i!=0)
				{
					i=lps[i-1];
				}
				else
				{
					lps[j]=0;
					j++;
				}
			}
		}

		//		System.out.println(Arrays.toString(lps));

	}
}
