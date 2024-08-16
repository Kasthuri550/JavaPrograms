package DynamicProgramming.subsequences;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		
		 int N = 4, arr[] = {1, 5, 11, 5};
		 
		 System.out.println(partitionEqualSubsetSumSpaceOptimizedApproach(arr,N));

	}

	private static boolean partitionEqualSubsetSumSpaceOptimizedApproach(int[] arr, int n) {
		
		int totalSum=0;
		
		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}
		
		if(totalSum%2==1) return false;
		
		int target=totalSum/2;
		
		return subsetSumEqualToTarget(arr,n,target);
	}

	private static boolean subsetSumEqualToTarget(int[] arr, int n, int target) {
		
		boolean prev[]=new boolean[target+1];
		boolean curr[]=new boolean[target+1];
		
		prev[0]=curr[0]=true;
		
		if(arr[0]<=target) prev[arr[0]]=true;
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
			{
				boolean notTake=prev[j];
				boolean take=false;
				
				if(arr[i]<=j)
				{
					take=prev[j-arr[i]];
				}
				
				curr[j]=take||notTake;
			}
			
			prev=curr.clone();
		}
		
		return prev[target];
	}
}
