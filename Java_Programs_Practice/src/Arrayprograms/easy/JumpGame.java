package Arrayprograms.easy;

public class JumpGame {

	public static void main(String[] args) {
		
		int A[] = {1, 2, 0, 3, 0, 0};
		
		System.out.println(jumpGame(A));

	}

	private static int jumpGame(int[] a) {
		
		int n=a.length,maxReach=0;
		
		for(int i=0;i<n;i++)
		{
			if(i>maxReach)
				return 0;
			
			maxReach=Math.max(maxReach, i+a[i]);
			
			if(maxReach>=n-1)
			{
				return 1;
			}
		}
		
		return 0;		
	}
}
