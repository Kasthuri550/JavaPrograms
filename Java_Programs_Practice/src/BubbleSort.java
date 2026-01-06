import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {

		int n;
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter number of elements: ");
		n=sc.nextInt();

		System.out.println("Enter elements: ");
		int a[]=new int[n];

		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}

		int[] b=bubbleSort(a,a.length);
		System.out.println(Arrays.toString(b));
	}

	private static int[] bubbleSort(int[] a, int length) {

		int temp;

		for(int i=0;i<length-1;i++)
		{
			boolean swapped=false;
			for(int j=0;j<length-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					swapped=true;
				}
			}

			if(!swapped)
			{
				break;
			}
		}

		return a;

	}

}
