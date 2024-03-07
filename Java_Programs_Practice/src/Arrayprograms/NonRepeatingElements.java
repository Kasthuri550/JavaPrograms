package Arrayprograms;

public class NonRepeatingElements {

	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 2, 3, 4, 4, 5, 6, 6 }; 
		
		nonRepeating1(arr);
	}

	private static void nonRepeating1(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			boolean isRepeated=false;
			for(int j=0;j<n;j++)
			{
				if(i!=j && arr[i]==arr[j])
				{
					isRepeated=true;
					break;
				}
			}
			
			if(!isRepeated)
			{
				System.out.println(arr[i]);
			}
		}
		
	}
}
