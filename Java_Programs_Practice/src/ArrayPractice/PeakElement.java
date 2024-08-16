package ArrayPractice;

public class PeakElement {

	public static void main(String[] args) {
		
		int n = 3, arr[] = {1, 2, 3} ;
		peakElementBrute(arr,n);
		System.out.println(peakElementBrute(arr, n));
		System.out.println(peakElementBetter(arr, n));

	}

	private static int peakElementBetter(int[] arr, int n) {
		
		int lb=0,ub=n-1;
		
		while(lb<ub)
		{
			int mid=lb+(ub-lb)/2;
			
			if(arr[mid]<arr[mid+1])
			{
				lb=mid+1;
			}
			else
			{
				ub=mid;
			}
		}
		return lb;
	}

	private static int peakElementBrute(int[] arr, int n) {
		
		int peak=0;
		
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]<arr[i+1])
			{
				peak=i+1;
			}
		}
		
		return peak;
	}
}
