import java.util.Arrays;
import java.util.Scanner;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements in an array: ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("Before sorting "+Arrays.toString(arr));
		Arrays.parallelSort(arr);
		System.out.println("After sorting "+Arrays.toString(arr));
		second(arr,arr.length);
	}

	private static void second(int[] arr, int length) {
		
		if(length<2)
		{
			System.out.println("Invalid input");
			return;
		}
		
		
		for(int i=length-2;i>=0;i--)
		{
			if(arr[i]!=arr[length-1])
			{
				System.out.println("The second largest element is "+arr[i]);
				return;
			}
		}
		
		System.out.println("There is no second largest element");
	}

}
