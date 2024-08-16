package Stringprograms.hard;

import java.util.ArrayList;

public class ZAlgorithm {

	public static void main(String[] args) {
		
		String text = "batmanandrobinarebat", pattern = "bat";
		
//		System.out.println(zAlgorithmBrute(text,pattern));
		System.out.println(zAlgorithmOptimal(text,pattern));

	}

	private static ArrayList<Integer> zAlgorithmOptimal(String text, String pattern) {
		
		String concat=pattern+"$"+text;
		int size=concat.length();
		int Z[]=new int[size];
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		getZArr(concat,Z);
		
		for(int i=0;i<size;i++)
		{
			if(Z[i]==pattern.length())
			{
				result.add(i-pattern.length());
			}
		}
		return result;
	}

	private static void getZArr(String concat, int[] z) {
		
		int left=0,right=0,n=concat.length();
		
		for(int k=1;k<n;k++)
		{
			if(k>right)
			{
				left=right=k;
				
				while(right<n && concat.charAt(right)==concat.charAt(right-left))
				{
					right++;
				}
				
				z[k]=right-left;
				right--;
			}
			else
			{				
				int k1=k-left;
				if(z[k1]<right-k+1)
				{
					z[k]=z[k1];
				}
				else
				{
					left=k;
					
					while(right<n && concat.charAt(right)==concat.charAt(right-left))
					{
						right++;
					}
					
					z[k]=right-left;
					right--;
				}
			}
		}
		
	}

	private static ArrayList<Integer> zAlgorithmBrute(String text, String pattern) {
		
		int n=text.length(),m=pattern.length();
		
		ArrayList<Integer> result=new ArrayList<>();
		
		for(int i=0;i<=n-m;i++)
		{
			int j;
			for(j=0;j<m;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
				{
					break;
				}
			}
			
			if(j==m)
			{
				result.add(i+1);
			}
		}
		
		return result;
	}
}
