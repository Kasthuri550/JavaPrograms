package ArrayPractice;

public class MinimumNumberOfJumps {

	public static void main(String[] args) {

		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		System.out.println(minJumps(arr));
	}

	private static int minJumps(int[] arr) {
		
		int n=arr.length,nextJumps=0,jumps=0,start=0;
		
		if(arr.length==1)
		{
			return 0;
		}
		else if(arr[0]==0)
		{
			return -1;
		}
		else 
		{
			for(int i=0;i<n;i++)
			{
				if(i>nextJumps) return -1;
				
				nextJumps=Math.max(nextJumps,i+arr[i]);
				
				if(i<n-1 && start==i)
				{
					jumps++;
					start=nextJumps;
				}
			}
		}
		
		return jumps;
	}
}
