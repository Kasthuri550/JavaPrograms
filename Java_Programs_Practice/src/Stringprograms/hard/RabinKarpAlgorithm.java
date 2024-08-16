package Stringprograms.hard;

import java.util.ArrayList;

public class RabinKarpAlgorithm {

	private static final int d=256;
	private static final int q=101;

	public static void main(String[] args) {

		String text = "geeksforgeeks",pattern = "geek";

		System.out.println(rabinKarpAlgorithmBrute(text,pattern));
		System.out.println(rabinKarpAlgorithmBetter(text, pattern));
		System.out.println(rabinKarpAlgorithmOptimal(text, pattern));
	}

	private static ArrayList<Integer> rabinKarpAlgorithmOptimal(String text, String pattern) {

		int n=text.length(),m=pattern.length(),p=0,t=0,h=1;

		ArrayList<Integer> result=new ArrayList<Integer>();

		for(int i=0;i<m-1;i++)
		{
			h=(h*d)%q;
		}

		for(int i=0;i<m;i++)
		{
			p=(p*d+pattern.charAt(i))%q;
			t=(t*d+text.charAt(i))%q;
		}

		for(int i=0;i<=n-m;i++)
		{
			if(p==t)
			{
				int j;
				for(j=0;j<m;j++)
				{
					if(text.charAt(i+j)!=pattern.charAt(j))
						break;
				}

				if(j==m)
				{
					result.add(i+1);
				}
			}

			if(i<n-m)
			{
				t=(d*(t-text.charAt(i)*h)+text.charAt(i+m))%q;

				if(t<0)
				{
					t=t+q;
				}
			}
		}

		return result;
	}

	private static ArrayList<Integer> rabinKarpAlgorithmBetter(String text, String pattern) {

		int n=text.length(),m=pattern.length();

		ArrayList<Integer> result=new ArrayList<Integer>();

		int patternHash=hash(pattern,m);

		for(int i=0;i<=n-m;i++)
		{
			String substr=text.substring(i,i+m);
			int substrHash=hash(substr,m);
			if(substrHash==patternHash && substr.equals(pattern))
			{
				result.add(i+1);
			}
		}

		return result;
	}

	private static int hash(String pattern, int m) {

		int hashValue=0;

		for(int i=0;i<m;i++)
		{
			hashValue+=pattern.charAt(i);
		}

		return hashValue;
	}

	private static ArrayList<Integer> rabinKarpAlgorithmBrute(String text, String pattern) {

		int n=text.length(),m=pattern.length();

		ArrayList<Integer> result=new ArrayList<Integer>();

		for(int i=0;i<=n-m;i++)
		{
			int j;
			for(j=0;j<m;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}

			if(j==m)
			{
				result.add(i+1);
			}
		}

		return result;
	}
}
