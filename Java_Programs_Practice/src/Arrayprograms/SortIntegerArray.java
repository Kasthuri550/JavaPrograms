package Arrayprograms;

public class SortIntegerArray {

	public static void main(String[] args) {
		
		int [] arr = new int [] {10, 40, 30, 20}; 
		
		sort(arr);

	}

	private static void sort(int[] arr) {
		
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int k=0;k<n;k++)
		{
			System.out.print(arr[k]+" ");
		}
	}

}
