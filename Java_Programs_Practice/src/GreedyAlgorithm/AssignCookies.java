package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {


		int greed [] = {1, 2, 3},sz [] = {1, 1};

		System.out.println( assignCookies(greed,sz));

	}

	private static int assignCookies(int[] greed, int[] sz) {
		
		int n=sz.length,m=greed.length,l=0,r=0;
		
		Arrays.sort(greed);
		Arrays.sort(sz);
		
		while(l<n && r<m)
		{
			if(greed[r]<=sz[l])
			{
				r++;
			}
			l++;
		}
		
		return r;
	}
}
