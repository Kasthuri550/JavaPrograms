package Arrayprograms.easy;

public class FirstNonRepeatingArray {
	
	public static void main(String[] args) {
		
		int arr[] = {-1, 2, -1, 3, 2};
		
		System.out.println(firstNonRepeating(arr));
		
	}

	private static int firstNonRepeating(int[] arr) {
		
		int n=arr.length,firstNonRepeat=-1;
		
		for(int i=0;i<n;i++)
		{
			boolean repeat=false;
			for(int j=0;j<n;j++)
			{
				if(i!=j && arr[i]==arr[j])
				{
					repeat=true;
					break;
				}
			}
			
			if(!repeat)
			{
				firstNonRepeat=i+1;
				break;
			}
				
		}
		
		return firstNonRepeat;		
	}
}
