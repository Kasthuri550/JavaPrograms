package sorting;

public class HeapSort {

	public static void main(String[] args) {
		
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		heapSort(arr,arr.length);
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		
		for(int sortedArray:arr)
		{
			System.out.print(sortedArray+" ");
		}
		
	}

	private static void heapSort(int[] arr, int n) {
		
		for(int i=n/2-1;i>=0;i--)
		{
			maxHeapify(arr,n-1,i);
		}
		
		for(int j=n-1;j>=0;j--)
		{
			swap(arr,0,j);
			maxHeapify(arr,j,0);
		}
		
	}


	private static void maxHeapify(int[] arr, int n, int i) {
		
		int largest=i;
		int left=2*i;
		int right=2*i+1;
		
		if(left<n && arr[left]>arr[largest])
		{
			largest=left;
		}
		if(right<n && arr[right]>arr[largest])
		{
			largest=right;
		}
		
		if(largest!=i)
		{
			swap(arr,largest,i);
			maxHeapify(arr, n, largest);
		}
	}

	private static void swap(int[] arr, int x, int y) {
		
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
}
