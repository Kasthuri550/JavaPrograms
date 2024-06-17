package BinarySearch;

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		
		 int vec[] = {4, 7, 9, 10},k =4;
		 
		 System.out.println(kthMissingPositiveNumberBrute(vec,k));
		 System.out.println(kthMissingPositiveNumberOptimal(vec, k));

	}

	private static int kthMissingPositiveNumberOptimal(int[] vec, int k) {
		
		int n=vec.length;
		int low=0,high=n-1;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			int missing=vec[mid]-(mid+1);
			
			if(missing<k)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		
		return high+1+k;
	}

	private static int kthMissingPositiveNumberBrute(int[] vec, int k) {
		
		int n=vec.length;
		
		for(int i=0;i<n;i++)
		{
			if(vec[i]<=k)
			{
				k++;
			}
			else
			{
				break;
			}
		}
		return k;
	}
}
