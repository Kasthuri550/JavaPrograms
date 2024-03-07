package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		insertionSortAsc(arr,arr.length);
		System.out.println("Ascending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		insertionSortDesc(arr,arr.length);
		System.out.println("Descending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}

	}

	private static void insertionSortDesc(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
		{
			int j=i;
			while(j>0 && arr[j-1]<arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
				j--;
			}
		}
	}

	private static void insertionSortAsc(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
		{
			int j=i;
			while(j>0 && arr[j-1]>arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
				j--;
			}
		}
		
	}

}
