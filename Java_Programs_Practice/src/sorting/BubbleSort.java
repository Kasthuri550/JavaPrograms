package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		bubbleSortAsc(arr,arr.length);
		System.out.println("Ascending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		bubbleSortDesc(arr,arr.length);
		System.out.println("Descending order");
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
	}

	private static void bubbleSortDesc(int[] arr, int n) {
		
		for(int i=n-1;i>=1;i--)
		{
			boolean swapDone=false;
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;					
				}	
			}
			if(!swapDone)
				break;
		}
		
	}

	private static void bubbleSortAsc(int[] arr, int n) {
		
		for(int i=n-1;i>=1;i--)
		{
			boolean swapDone=false;
			for(int j=0;j<i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(!swapDone)
				break;
		}
		
	}
}
