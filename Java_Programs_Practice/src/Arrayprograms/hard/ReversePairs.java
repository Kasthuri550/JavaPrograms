package Arrayprograms.hard;

public class ReversePairs {

	public static void main(String[] args) {

		//		int[] a = {4, 1, 2, 3, 1};
		int[] a= {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
		int n = a.length;

		reversePairsBrute(a,n);
		reversePairsOptimal(a,n);
	}

	private static void reversePairsOptimal(int[] a, int n) {

		System.out.println(mergeSort(a,0,n-1));
	}

	/*
	 * Time Complexity: O(2nlogn)
	 * Space Complexity: O(n)
	 * */
	private static int mergeSort(int[] a, int low, int high) {

		int count=0;
		if(low>=high)
		{
			return count;
		}
		int mid=(low+high)/2;
		count+=mergeSort(a,low,mid);
		count+=mergeSort(a,mid+1,high);
		count+=countPairs(a,low,mid,high);
		merge(a,low,mid,high);

		return count;
	}

	private static int countPairs(int[] a, int low, int mid, int high) {

		int right=mid+1,count=0;
		for(int i=low;i<=mid;i++)
		{
			while(right<=high && a[i] > 2*a[right])
			{
				right++;
			}
			count+=(right-(mid+1));
		}
		return count;
	}

	private static void merge(int[] a, int low, int mid, int high) {

		int i=low,j=mid+1,k=0;
		int temp[]=new int[high-low+1];

		while(i <= mid && j <= high)
		{
			if(a[i]<=a[j])
			{
				temp[k]=a[i];
				i++;
			}
			else
			{
				temp[k]=a[j];
				j++;
			}
			k++;
		}

		while(i<=mid)
		{
			temp[k++]=a[i++];
		}
		while(j<=high)
		{
			temp[k++]=a[j++];
		}

		for(int t=low;t<=high;t++)
		{
			a[t]=temp[t-low];
		}

		System.out.println("Array after merge:");
		for (int l = low; l <= high; l++) {
			System.out.print(a[l] + " ");
		}
		System.out.println();
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static void reversePairsBrute(int[] a, int n) {

		int count=0;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i] > 2*a[j])
					count++;
			}
		}

		System.out.println(count);
	}
}
