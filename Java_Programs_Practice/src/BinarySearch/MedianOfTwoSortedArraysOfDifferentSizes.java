package BinarySearch;

import java.util.Arrays;

public class MedianOfTwoSortedArraysOfDifferentSizes {

	public static void main(String[] args) {
		
		 int[] nums1 = {1, 4, 7, 10, 12};
	        int[] nums2 = {2, 3, 6, 15};
        
//        int median=findMedianBrute(nums1,nums2);
        
        double median=findMedianOptimal(nums1,nums2);
        System.out.println(median);

	}

	private static double findMedianOptimal(int[] nums1, int[] nums2) {
		
		int n1 = nums1.length;
		int n2 = nums2.length;
		int n=(n1+n2)/2;
		
		int left=(n1+n2+1)/2;
		int low=0,high=n1;
		
		while(low<=high)
		{
			int mid1=(low+high)/2;
			int mid2=left-mid1;
			
			int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
			int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
			int r1=(mid1<n1)?nums1[mid1]:Integer.MAX_VALUE;
			int r2=(mid2<n2)?nums2[mid2]:Integer.MAX_VALUE;
			
			if(l1<=r2 && l2<=r1)
			{
				if(n%2==1) return Math.max(l1,l2);
				else return (((double)(Math.max(l1,l2)+Math.min(r1, r2)))/2.0);
			}
			else if(l1>r2)
			{
				high=mid1-1;
			}
			else
			{
				low=mid1+1;
			}
		}
		
		return 0;
	}

	private static int findMedianBrute(int[] nums1, int[] nums2) {
		
		int n=nums1.length,m=nums2.length;
		int mergedArrays[]=new int[n+m];
		
		System.arraycopy(nums1,0, mergedArrays,0, n);
		System.arraycopy(nums2, 0, mergedArrays, n, m);
		Arrays.sort(mergedArrays);
		System.out.println(Arrays.toString(mergedArrays));
		int a=mergedArrays.length;
		if(a%2==1)
		{
			return (mergedArrays[(a/2)-1]+mergedArrays[a/2])/2;
			
		}
		else
		{
			return mergedArrays[a/2];
		}
		
	}
}
