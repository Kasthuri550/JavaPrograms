package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {


		int greed [] = {1, 2, 3},sz [] = {1, 1};

		System.out.println(assignCookies(greed,sz));
	}

	/*
	 * Time Complexity: O(mlogm +nlogn)
	 * Space Complexity: O(1)
	 * */	
	private static int assignCookies(int[] greed, int[] cookie) {

		int l=0,r=0,m=greed.length,n=cookie.length;

		Arrays.sort(greed);
		Arrays.sort(cookie);

		while(l<m && r<n)
		{
			if(greed[l]<=cookie[r])
			{
				l++;
			}

			r++;
		}

		return l;
	}
}
