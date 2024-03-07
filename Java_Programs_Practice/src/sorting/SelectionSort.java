package sorting;

public class SelectionSort {

	public static void main(String[] args) {

		int arr[]={4, 1, 3, 9, 7};
		selectionSortAsc(arr,arr.length);
		System.out.println("Ascending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		selectionSortDesc(arr,arr.length);
		System.out.println("Descending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
	}
	private static void selectionSortDesc(int[] arr, int length) {
		
		int n=arr.length;		
		for(int i=0;i<=n-2;i++)
		{
			int max=i;
			for(int j=i;j<=n-1;j++)
			{
				if(arr[max]<arr[j])
				{
					max=j;
				}
			}
			int temp=arr[max];
			arr[max]=arr[i];
			arr[i]=temp;
		}

	}
	//O(n^2) O(1)
	private static void selectionSortAsc(int[] arr, int n) {

		for(int i=0;i<=n-2;i++)
		{
			int min=i;
			for(int j=i;j<=n-1;j++)
			{
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}

			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;			
		}
	}
}
