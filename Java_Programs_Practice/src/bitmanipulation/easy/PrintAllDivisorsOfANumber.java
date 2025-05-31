package bitmanipulation.easy;

import java.util.ArrayList;
import java.util.Collections;

public class PrintAllDivisorsOfANumber {

	public static void main(String[] args) {

		int n=20;

		System.out.println(printAllDivisorsOfANumberBrute(n));
		System.out.println(printAllDivisorsOfANumberOptimal1(n));
		System.out.println(printAllDivisorsOfANumberOptimal2(n));
	}
	/*
	 * Time Complexity: O(sqrt(n)*log n)
	 * Space Complexity: O(n)
	 * */
	private static ArrayList<Integer> printAllDivisorsOfANumberOptimal2(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				list.add(i);

				if(n/i!=i)
					list.add(n/i);
			}
		}

		Collections.sort(list);

		return list;
	}
	/*
	 * Time Complexity: O(sqrt(n)*log n)
	 * Space Complexity: O(n)
	 * */
	private static ArrayList<Integer> printAllDivisorsOfANumberOptimal1(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=1;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				list.add(i);

				if(n/i != i)
				{
					list.add(n/i);
				}
			}
		}	

		Collections.sort(list);

		return list;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static ArrayList<Integer> printAllDivisorsOfANumberBrute(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				list.add(i);
			}
		}

		return list;
	}
}
