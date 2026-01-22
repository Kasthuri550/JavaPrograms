package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(N!*N)
 * Space Complexity: O(N) recursive stack space
 * */
public class PermutationsApproach2 {

	public static void main(String[] args) {

		int nums[] = {1,2,3};

		System.out.println(permutationsApproach2(nums));
	}

	private static List<List<Integer>> permutationsApproach2(int[] nums) {

		List<List<Integer>> result=new ArrayList<>();

		permutations(0,nums,result);

		return result;
	}

	private static void permutations(int index, int[] nums, List<List<Integer>> result) {

		if(index==nums.length)
		{
			List<Integer> ds=new ArrayList<>();
			for(int i=0;i<nums.length;i++)
			{
				ds.add(nums[i]);
			}

			result.add(ds);
			return;
		}

		for(int i=index;i<nums.length;i++)
		{
			swap(index,i,nums);
			permutations(index+1, nums, result);
			swap(index,i,nums);
		}

	}

	private static void swap(int i, int j, int[] nums) {

		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
