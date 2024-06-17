package sorting;

public class RecursiveBubbleSort {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		bubbleSort(arr,arr.length);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

	private static void bubbleSort(int[] arr, int n) {
		
		if(n==1)
		{
			return;
		}
		
		int didSwap=0;
		
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		
		if(didSwap==0)
		{
			return;
		}
		
		 bubbleSort(arr, n-1);
		
	}

}
