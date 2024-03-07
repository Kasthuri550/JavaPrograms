package Arrayprograms;

import java.util.Arrays;

public class RearrangeArrayAlternately {

	public static void main(String[] args) {
		
		int n = 6;
		long arr[] = {1,2,3,4,5,6};
		
//		rearrangeArray1(n, arr);
//		rearrangeArray2(n, arr);

	}

	private static void rearrangeArray2(int n, long[] arr) {
		
		int min=0,max=n-1;
		long M=arr[n-1]+1;
		
		for(int i=0;i<n;i++)
		{
			if(i%2==0)
			{
				arr[i]=arr[i]+(arr[max]%M)*M;
				max--;
			}
			else
			{
				arr[i]=arr[i]+(arr[min]%M)*M;
				min++;
			}
		}
		
		for(int j=0;j<n;j++)
		{
			arr[j]=arr[j]/M;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void rearrangeArray1(int n, long[] arr) {
		
		long M=arr[n-1]+1;
        int min=0,max=n-1;
        
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[i]=arr[i]+((arr[max]%M)*M);
                max--;
            }
            else
            {
                arr[i]=arr[i]+((arr[min]%M)*M);
                min++;
            }
        }
        
        for(int j=0;j<n;j++)
        {
            arr[j]=arr[j]/M;
        }
	}

}
