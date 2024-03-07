import java.util.Scanner;

public class MergeSort
{
	public static void main(String[] args) {
		
		int n;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter number of elements:");
			n=sc.nextInt();
			
			int a[]=new int[n];
			
			System.out.print("Enter the elements:");
			
			for(int i=0;i<a.length;i++)
			{
				a[i]=sc.nextInt();
			}
			
			int merged[]=mergeSort(a,0,a.length-1);
			
			for(int o:merged)
			{
				System.out.print(o+" ");
			}
		}
		
	}

	private static int[] mergeSort(int[] a, int lb, int ub) {
		
		if(lb==ub)
		{
			int c[]=new int[1];
			c[0]=a[lb];
			return c;
		}
		
		int mid=lb+ub/2;
		int one[]=mergeSort(a,lb,mid);
		int two[]=mergeSort(a,mid+1,ub);
		int merged[]=mergeTwoArrays(one,two);
		return merged;
	}

	private static int[] mergeTwoArrays(int[] one, int[] two) {
		
		int i=0,j=0,k=0;
		int sorted[]=new int[one.length+two.length];
		
		while(i<one.length && j<two.length)
		{
			if(one[i]<two[j])
			{
				sorted[k]=one[i];
				i++;
				k++;
			}
			else
			{
				sorted[k]=two[j];
				j++;
				k++;
			}
		}
		
		if(i==one.length)
		{
			while(j<two.length)
			{
				sorted[k]=two[j];
				j++;
				k++;
			}
		}
		if(j==two.length)
		{
			while(i<one.length)
			{
				sorted[k]=one[i];
				i++;
				k++;
			}
			
		}
		
		return sorted;
	
	}
}