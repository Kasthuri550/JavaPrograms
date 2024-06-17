package sorting;

public class RecursiveInsertionSort {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		
//		insertionSortAsc(arr);
//		insertionSortDesc(arr);
		recursiveInsertionSort(arr,arr.length);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

	private static void insertionSortDesc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=1;i<n;i++)
		{
			int temp=arr[i],j=i-1;
			while(j>=0 && arr[j]<temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		
	}

	private static void insertionSortAsc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=1;i<n;i++)
		{
			int temp=arr[i],j=i-1;
			while(j>=0 && arr[j]>temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		
	}

	private static void recursiveInsertionSort(int[] arr,int n) {
		
	    if(n<=1)
	    {
	    	return;
	    }
	    recursiveInsertionSort(arr, n-1);
	    
	    int temp=arr[n-1];
	    int j=n-2;
	    
	    while(j>=0 && arr[j]>temp)
	    {
	    	arr[j+1]=arr[j];
	    	j--;
	    }
	    
	    arr[j+1]=temp;
	    		
	}
}
