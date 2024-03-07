import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {

		int n,data;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Enter search element: ");
		data=sc.nextInt();
		
		int result=linearSearch(a,0,a.length,data);
		if(result==-1)
		{
			System.out.println("Element not found");
		}
		else
		{
			System.out.println("Element is found in the index position "+result);
		}
	}

	private static int linearSearch(int[] a, int start, int length,int data) {
		
		for(int i=start;i<length;i++)
		{
			if(a[i]==data)
			{
				return i;
			}
		}
		
		return -1;
		
	}
}
