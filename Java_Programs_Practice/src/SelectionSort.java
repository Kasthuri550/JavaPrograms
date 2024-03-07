import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements: ");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		
		int sorted[]=selectionSort(a,a.length);	
		System.out.println(Arrays.toString(sorted));
	}

	private static int[] selectionSort(int[] a,int length) {
		
		for(int i=0;i<length-1;i++)
		{
			int min=i;
			
			for(int j=i+1;j<length;j++)
			{
				if(a[j]<a[min])
					min=j;
			}
			
			if(min!=i)
			{
				int temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
		
		return a;		
	}

}
