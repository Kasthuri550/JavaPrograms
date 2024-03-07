
public class PalindromeArray {

	public static void main(String[] args) {
		
		int arr[]= {3,2,3,3,5};
		int palArray = palArray(arr,arr.length);
		System.out.println(palArray);

	}

	private static int palArray(int[] arr, int length) {
		
		int i=0,j=length-1,res=0;
		
		while(i<=j)
		{
			if(arr[i]==arr[j])
			{
				i++;
				j--;
			}
			else if(arr[i]>arr[j])
			{
				j--;
				arr[j]+=arr[j+1];
				res++;
			}
			else
			{
				i++;
				arr[i]+=arr[i-1];
				res++;
			}
			
		}
		
		return res;
		
	}

}
