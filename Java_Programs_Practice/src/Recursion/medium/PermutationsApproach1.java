package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity:O(N!*N)
 * Space Complexity: O(n)+O(n)
 * */
public class PermutationsApproach1 {

	public static void main(String[] args) {

		int nums[] = {1,2,3};

		permutationsApproach1(nums);
	}

	private static void permutationsApproach1(int[] nums) {

		List<List<Integer>> result=new ArrayList<>();
		List<Integer> ds=new ArrayList<Integer>();
		boolean freq[]=new boolean[nums.length];

		permutations(nums,ds,freq,result);

		System.out.println(result);
	}

	private static void permutations(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> result) {

		if(nums.length==ds.size())
		{
			result.add(new ArrayList<>(ds));
			return;
		}

		for(int i=0;i<nums.length;i++)
		{
			if(!freq[i])
			{
				freq[i]=true;
				ds.add(nums[i]);
				permutations(nums, ds, freq, result);
				ds.remove(ds.size()-1);
				freq[i]=false;
			}
		}
	}
}
