package bitmanipulation.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Time Complexity: O(n*2^n)
 * Space Complexity: O(n(2^n)
 * */
public class PowerSet {

	public static void main(String[] args) {

		int nums[]= {1,2,3};

		String s="abc";

		System.out.println(powerSetInteger(nums));
		System.out.println(powerSetString(s));
	}

	private static List<String> powerSetString(String s) {

		int n=s.length(),subsets=1<<n;

		List<String> resultList=new ArrayList<>();

		for(int i=0;i<subsets;i++)
		{
			StringBuilder subset=new StringBuilder();
			for(int j=0;j<n;j++)
			{
				if((i & (1<<j))!=0)
				{
					subset.append(s.charAt(j));
				}
			}

			resultList.add(subset.toString());
		}

		Collections.sort(resultList);

		return resultList;
	}

	private static List<List<Integer>> powerSetInteger(int[] nums) {

		int n=nums.length,subsets=1<<n;

		List<List<Integer>> resultList=new ArrayList<>();

		for(int i=0;i<subsets;i++)
		{
			List<Integer> list=new ArrayList<>();
			for(int j=0;j<n;j++)
			{
				if((i & (1<<j))!=0)
				{
					list.add(nums[j]);
				}
			}

			resultList.add(list);
		}

		return resultList;
	}
}
