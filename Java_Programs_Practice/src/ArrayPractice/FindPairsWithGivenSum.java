package ArrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairsWithGivenSum {

	public static void main(String[] args) {

		int arr[] = {1, 5, 7, -1, 5},sum=6;

				findPairsBrute(arr,sum);
				findPairsBetter(arr,sum);
		findPairsOptimal(arr, sum);
	}

	private static void findPairsOptimal(int[] arr, int sum) {

		int left=0,right=arr.length-1;
		Arrays.sort(arr);

		ArrayList<ArrayList<Integer>> result=new ArrayList<>();

		while(left<right)
		{
			int currentSum=arr[left]+arr[right];

			if(currentSum<sum)
			{
				left++;
			}
			else if(currentSum>sum)
			{
				right--;
			}
			else
			{
				ArrayList<Integer> list=new ArrayList<>();
				list.add(arr[left]);
				list.add(arr[right]);
				result.add(list);

				while(left<right && arr[left]==arr[left+1])
				{
					left++;
				}
				
				while(left<right && arr[right]==arr[right-1])
				{
					right--;
				}
				
				left++;
				right--;
			}
		}

		System.out.println(result);
	}

	private static void findPairsBetter(int[] arr, int sum) {

		int n=arr.length;
		HashSet<Integer> set=new HashSet<>();

		Set<ArrayList<Integer>> result=new HashSet<>();

		for(int i=0;i<n;i++)
		{
			int complement=sum-arr[i];

			if(set.contains(complement))
			{
				ArrayList<Integer> list=new ArrayList<>();
				list.add(arr[i]);
				list.add(complement);
				result.add(list);
			}

			set.add(arr[i]);
		}


		System.out.println(result);
	}

	private static void findPairsBrute(int[] arr,int target) {

		int n=arr.length;

		ArrayList<ArrayList<Integer>> result=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j]==target)
				{
					ArrayList<Integer> list=new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);
					result.add(list);
				}
			}
		}

		System.out.println(result);
	}
}
