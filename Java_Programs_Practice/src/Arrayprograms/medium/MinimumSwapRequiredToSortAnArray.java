package Arrayprograms.medium;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapRequiredToSortAnArray {

	public static void main(String[] args) {
		
		int nums[] = {10, 19, 6, 3, 5};
		
//		minimumSwapBrute(nums);
		minimumSwapOptimal(nums);

	}

	private static void minimumSwapOptimal(int[] nums) {
		
		int n=nums.length,swaps=0;
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		int arr[]=nums.clone();
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],i);
		}
		
		
		for(int i=0;i<n;i++)
		{
			while(map.get(nums[i])!=i) 
			{
				swaps++;
				int temp=nums[i];
				nums[i]=nums[map.get(temp)];
				nums[map.get(temp)]=temp;
			}
		}
		System.out.println(swaps);
	}

	private static void swap(int[] nums, int x, int y) {
		
		int temp=nums[x];
		nums[x]=nums[y];
		nums[y]=temp;		
	}

	private static void minimumSwapBrute(int[] nums) {
		
		int n=nums.length,swaps=0;
		
		for(int i=0;i<n-1;i++)
		{
			boolean swapped=false;
			for(int j=0;j<n-i-1;j++)
			{
				if(nums[j]>nums[j+1])
				{
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					swaps++;
					swapped=true;
				}
			}
			
			if(!swapped) break;
		}
		
		System.out.println(swaps);
	}
}
