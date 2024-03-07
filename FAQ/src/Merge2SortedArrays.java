import java.util.Arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {
		
		int n = 4, arr1[] = {1,3,5,7}; 
		int m = 5, arr2[] = {0,2,6,8,9};
		approach1(arr1,arr2,n,m);
//		approach2(arr1,arr2,n,m);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}


	private static void approach2(int[] arr1, int[] arr2, int n, int m) {
		
		int len=n+m;
		int gap=(len/2)+(len%2);
		
		while(gap>0)
		{
			int left=0;
			int right=left+gap;
			while(right<len)
			{
				if(left<n && right>=n)
				{
					swapIfGreater(arr1,arr2,left,right-n);
				}
				else if(left>=n)
				{
					swapIfGreater(arr2, arr2, left-n, right-n);
				}
				else
				{
					swapIfGreater(arr1, arr1, left, right);
				}
				left++;
				right++;
			}
			if(gap==1) break;
			gap=(gap/2)+(gap%2);
		}
		
	}

	private static void swapIfGreater(int[] arr1, int[] arr2, int left, int right) {
		
		if(arr1[left]>arr2[right])
		{
			int temp=arr1[left];
			arr1[left]=arr2[right];
			arr2[right]=temp;
		}
		
	}

	private static void approach1(int[] arr1, int[] arr2, int n, int m) {
		
		int left=n-1;
		int right=0;
		
		while(left>=0 && right<m)
		{
			if(arr1[left]>arr2[right])
			{
				swap(arr1,arr2,left,right);
			}
			else
			{
				break;
			}
			left--;
			right++;
		}
		
		Arrays.parallelSort(arr1);
		Arrays.parallelSort(arr2);
		
	}

	private static void swap(int[] arr1, int[] arr2, int left, int right) {
		
		int temp=arr1[left];
		arr1[left]=arr2[right];
		arr2[right]=temp;
	}
}
