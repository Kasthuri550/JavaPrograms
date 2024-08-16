package Stringprograms.hard;

import java.util.ArrayList;

public class KMPAlgorithm {

	public static void main(String[] args) {
		
		String txt = "geeksforgeeks";
		String pat = "geek";
		
//		System.out.println(kmpAlgorithmBrute(txt,pat));
		System.out.println(kmpAlgorithmOptimal(txt,pat));

	}

	private static ArrayList<Integer> kmpAlgorithmOptimal(String txt, String pat) {
		
		int n=txt.length(),m=pat.length();
		
		int lps[]=new int[m];
		
		computeLpsArray(pat,m,lps);
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		int i=0,j=0;
		
		while(i<n)
		{
			if(txt.charAt(i)==pat.charAt(j))
			{
				i++;
				j++;
			}
			
			if(j==m)
			{
				result.add(i-j+1);
				j=lps[j-1];				
			}
			else if(i<n && txt.charAt(i)!=pat.charAt(j))
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

	private static void computeLpsArray(String pat, int m, int[] lps) {
		
		int i=1,len=0;
		lps[0]=0;
		
		while(i<m)
		{
			if(pat.charAt(i)==pat.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					len=lps[len-1];
				}
				else
				{
					lps[i]=len;
					i++;
				}
			}
		}
		
	}

	private static ArrayList<Integer> kmpAlgorithmBrute(String txt, String pat) {
		
		int n=txt.length(),m=pat.length();
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<=n-m;i++)
		{
			int j;
			for(j=0;j<m;j++)
			{
				if(txt.charAt(i+j)!=pat.charAt(j))
					break;
			}
			
			if(j==m)
			{
				list.add(i+1);
			}
		}
		
		return list;
	}
}
