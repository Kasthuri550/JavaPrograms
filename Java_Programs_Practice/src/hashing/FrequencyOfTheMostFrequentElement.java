package hashing;

public class FrequencyOfTheMostFrequentElement {

	public static void main(String[] args) {
		
		int n=3,arr[] = {2,2,4},k=4;
		
		System.out.println(maximumFrequencyBrute(arr,n,k));
		System.out.println(maximumFrequencyOptimal(arr, n, k));

	}

	private static int maximumFrequencyOptimal(int[] arr, int n, int k) {

		long total=0;
		int left=0,maxFreq=1;
		
		for(int right=0;right<n;right++)
		{
			total=total+arr[right];
			
			while(arr[right]*(right-left+1)>total+k)
			{
				total=total-arr[left];
				left++;
			}
			
			maxFreq=Math.max(maxFreq, right-left+1);
		}
		
		return maxFreq;
	}

	private static int maximumFrequencyBrute(int[] arr, int n, int k) {

		int maxFreq=1;
		
		for(int i=0;i<n;i++)
		{
			int freq=1,operations=k;
			
			for(int j=i-1;j>=0 && operations>=0;j--)
			{
				int diff=arr[i]-arr[j];
				
				if(operations>=diff)
				{
					operations=operations-diff;
					
					freq++;
				}
			}
			
			maxFreq=Math.max(maxFreq,freq);
		}
		
		return maxFreq;
	}
}
