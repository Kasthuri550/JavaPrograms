import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {

		int n,search;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of elements: ");
		n=sc.nextInt();

		int a[]=new int[n];

		System.out.println("Enter the elements: ");

		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Before sorting "+Arrays.toString(a));
        Arrays.parallelSort(a);
        System.out.println("After sorting "+Arrays.toString(a));
		System.out.println("Enter search element: ");
		search=sc.nextInt();
		int index=binarySearch(a,a.length,search);		
		System.out.println("Position of the searched element: "+index);
	}

	private static int binarySearch(int[] a, int length, int data) {

		int l=0,r=length-1;

		while(l<=r)
		{
			int mid=l+(r-l)/2;
			if(data == a[mid])
			{
				return mid;
			}
			if(data > a[mid])
			{
				l=mid+1;
			}
			else 
			{
				r=mid-1;
			}		
		}

		return -1;	
	}

}
