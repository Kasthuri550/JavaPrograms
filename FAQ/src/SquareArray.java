import java.util.Arrays;

public class SquareArray {

	public static void main(String[] args) {
		
		int arr[] = { -6, -3, -1, 2, 4, 5 };
		int n=arr.length;
		sortSquareArray(arr,n);
	}

	private static void sortSquareArray(int[] arr, int n) {
		
		
		System.out.println("Before sort");
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		System.out.println("After sort");
		
		for(int i=0;i<n;i++)
			arr[i]=arr[i]*arr[i];
				
		Arrays.parallelSort(arr);
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
	}

}
