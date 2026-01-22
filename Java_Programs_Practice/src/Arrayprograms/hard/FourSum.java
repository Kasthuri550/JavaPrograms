package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {

		int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
		int target = 9;

		sum4brute(nums,target);
		sum4better(nums,target);
		sum4optimal(nums,target);
	}
	/*
	 * Time Complexity: O(n^3 * nlogn))
	 * Space Complexity: O(no. of unique quadruplets)
	 * */
	private static void sum4optimal(int[] nums, int target) {

		List<List<Integer>> temp=new ArrayList<>();
		int n=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n;i++)
		{
			if(i!=0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<n;j++)
			{
				if(j!=i+1 && nums[j]==nums[j-1]) continue;
				int k=j+1,l=n-1;
				while(k<l)
				{
					long sum=nums[i]+nums[j];
					sum+=nums[k]+nums[l];

					if(sum<target)
					{
						k++;
					}
					else if(sum>target)
					{
						l--;
					}
					else
					{
						List<Integer> list=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
						temp.add(list);
						k++;
						l--;

						while(k<l && nums[k]==nums[k-1]) k++;
						while(k<l && nums[l]==nums[l+1]) l--;
					}
				}
			}
		}

		System.out.println(temp);
	}
	/*
	 * Time Complexity: O(n^3 * log(no of quadruplets))
	 * Space Complexity: O(2*(no. of unique quadruplets))
	 * */
	private static void sum4better(int[] nums, int target) {

		Set<List<Integer>> temp=new HashSet<>();
		int n=nums.length;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				Set<Long> hashSet=new HashSet<Long>();
				for(int k=j+1;k<n;k++)
				{
					long sum=nums[i]+nums[j]+nums[k];
					long fourth=target-sum;

					if(hashSet.contains(fourth))
					{
						List<Integer> list=Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
						list.sort(null);
						temp.add(list);						
					}
					hashSet.add((long)nums[k]);
				}
			}
		}

		ArrayList<List<Integer>> arrayList=new ArrayList<>(temp);
		System.out.println(arrayList);
	}

	/*
	 * Time Complexity: O(n^4 * log(no of quadruplets))
	 * Space Complexity: O(2*(no. of unique quadruplets))
	 * */
	private static void sum4brute(int[] nums, int target) {

		Set<List<Integer>> temp=new HashSet<>();

		int n=nums.length;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					for(int l=k+1;l<n;l++)
					{
						long fourSum=nums[i]+nums[j]+nums[k]+nums[l];

						if(fourSum == target)
						{
							List<Integer> list=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
							list.sort(null);
							temp.add(list);
						}
					}
				}
			}
		}

		ArrayList<List<Integer>> arrayList = new ArrayList<>(temp);
		System.out.println(arrayList);
	}
}
