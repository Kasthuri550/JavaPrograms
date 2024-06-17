package Arrayprograms.medium;

public class ElementOccurOnceOtherThrice {

	public static void main(String[] args) {
		
		int arr[] = {1, 10, 1, 1};
		
		System.out.println(appearOnce(arr));
	}

	private static int appearOnce(int[] arr) {
		
		int n=arr.length,ones=0,twos=0,commonBits=0;
		
		for(int i=0;i<n;i++)
		{
			twos|=ones & arr[i];
			
			ones^=arr[i];
			
			commonBits=~(ones & twos);
			
			ones&=commonBits;
			twos&=commonBits;
		}
		
		return ones;
	}
}
