package GreedyAlgorithm;

public class JumpGameI {

	public static void main(String[] args) {

		int N = 6,A[] = {1, 2, 0, 3, 0, 0};
		
		System.out.println(jumpGame(N,A));
	}

	private static int jumpGame(int n, int[] a) {
		
		int maxReach=0;
		
		for(int i=0;i<n;i++)
		{
			if(i>maxReach)
				return 0;
			
			maxReach=Math.max(maxReach,i+a[i]);
		}
		
		return 1;
	}
}
