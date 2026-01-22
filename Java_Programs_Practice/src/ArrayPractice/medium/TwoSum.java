package ArrayPractice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {

		int[] arr = {2, 6, 5, 8, 11,3};
		int target = 14;

//		twoSum(arr,target);
		twoSumClosest(new int[] {5, 2, 7, 1, 4},10);
	}

	private static void twoSumClosest(int[] arr,int target) {

		int n=arr.length;
		
		if(n<2)
			return;
		
		Arrays.parallelSort(arr);
		int left=0,right=n-1;
		int minDiff=Integer.MAX_VALUE,maxAbsolute=Integer.MIN_VALUE;
		int a=-1,b=-1;
		
		List<Integer> result=new ArrayList<>();
		while(left<right)
		{
			int sum=arr[left]+arr[right];
			int diff=Math.abs(sum-target);
			int absoluteDiff=Math.abs(arr[right]-arr[left]);
			
			if(diff<minDiff || ( diff== minDiff && absoluteDiff>maxAbsolute))
			{
				minDiff=diff;
				maxAbsolute=absoluteDiff;
				a=arr[left];
				b=arr[right];
//				List<Integer> list=new ArrayList<>();
//				list.add(arr[left]);
//				list.add(arr[right]);
//				result.add(list);
			}
			if(sum<target)
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		
		if(a!=-1)
		{
			result.add(a);
			result.add(b);
		}
		System.out.println(result);
	}

	private static void twoSum(int[] arr, int target) {

		int n=arr.length;
		
		if(n<2)
			return;
		
		Arrays.sort(arr);
		int left=0,right=n-1;
		
		List<List<Integer>> list=new ArrayList<>();

		while(left<right)
		{
			int sum=arr[left]+arr[right];

			if(sum<target)
			{
				left++;
			}
			else if(sum>target)
			{
				right--;
			}
			else
			{
				List<Integer> result=new ArrayList<>();
				result.add(arr[left]);
				result.add(arr[right]);
				list.add(result);
				left++;
				right--;
			}
		}
		
		System.out.println(list);
	}
}
