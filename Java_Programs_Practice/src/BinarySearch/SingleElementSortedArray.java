package BinarySearch;

public class SingleElementSortedArray {

	public static void main(String[] args) {
		
		int arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65};
		
		System.out.println(singleElementBrute(arr));
		System.out.println(singleElementBetter(arr));

	}

	private static int singleElementBetter(int[] arr) {
		
		int n=arr.length,xor=0;
		
		for(int i=0;i<n;i++)
		{
			xor^=arr[i];
		}
		
		return xor;
	}

	private static int singleElementBrute(int[] arr) {
		
		int n=arr.length;
		
		if(n==1) return arr[0];
		
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				if(arr[i]!=arr[i+1]) return arr[i];
			}
			else if(i==n-1)
			{
				if(arr[i]!=arr[i-1]) return arr[i];
			}
			else
			{
				if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1]) return arr[i];
			}
		}
		
		return -1;
	}
}
