
public class MinimumJumps {

	public static void main(String[] args) {
		
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};	
		

		int minJumps = minJumps(arr);	
		System.out.println(minJumps);

	}
	static int minJumps(int[] arr)
	{
		int jumps=0,nextJump=0,start=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(nextJump<i)
				return -1;
			
			nextJump=Math.max(nextJump, i+arr[i]);
			if(i<arr.length-1 && start==i)
			{
				jumps++;
				start=nextJump;
			}
		}
		
		return jumps;
	}

}
