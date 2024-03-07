package Arrayprograms;

public class ArrayMadeEqual {

	public static void main(String[] args) {
		
		int arr[] = { 50, 100, 75 };
		int n=arr.length;
		if(make_equal(arr,n))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}

	private static boolean make_equal(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
		{
			while(arr[i]%2==0)
			{
				arr[i]/=2;
			}
			
			while(arr[i]%3==0)
			{
				arr[i]/=3;
			}
		}
		
		for(int i=1;i<n;i++)
		{
			if(arr[i]!=arr[0])
			{
				return false;
			}
		}
		
		return true;	
	}

}
