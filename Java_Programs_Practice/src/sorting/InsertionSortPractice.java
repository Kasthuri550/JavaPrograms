package sorting;

public class InsertionSortPractice {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		
		insertionSortAsc(arr);
//		insertionSortDesc(arr);

	}

	private static void insertionSortDesc(int[] arr) {
		
		int n=arr.length;
		
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
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
	}

	private static void insertionSortAsc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=1;i<n;i++)
		{
			int j=i;
			while(j>0 && arr[j-1]>arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
			}
		}
		
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
