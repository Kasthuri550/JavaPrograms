package GreedyAlgorithm;

public class JumpGame2 {

	public static void main(String[] args) {
		
		int nums[] = {2,3,1,1,4};
		
		System.out.println(minimumJumps(nums.length,nums));
	}

	private static int minimumJumps(int n, int[] nums) {
		
		int nextJump=0,start=0,jumps=0;
		
		if(n==1)
		{
			return 0;
		}
		else if(nums[0]==0)
		{
			return -1;
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				if(i>nextJump) return -1;
				
				nextJump=Math.max(nextJump,i+nums[i]);
				if(i<n-1 && i==start)
				{
					jumps++;
					start=nextJump;
				}
			}
			
			return jumps;
		}
		
	}
}
