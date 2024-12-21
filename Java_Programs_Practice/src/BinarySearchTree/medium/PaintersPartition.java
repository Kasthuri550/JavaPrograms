package BinarySearchTree.medium;

public class PaintersPartition {

	public static void main(String[] args) {

		int arr[] = {5, 10, 30, 20, 15}, k = 3,n=arr.length;

		System.out.println(paintersPartitionBrute(arr,n,k));
		System.out.println(paintersPartitionOptimal(arr,n,k));

	}
	
	/*
	 * Time Complexity: O(n*log(high-low+1))
	 * Space Complexity: O(1) 
	 * 
	 */
	
	private static int paintersPartitionOptimal(int[] arr, int n, int k) {

		int low=Integer.MIN_VALUE,high=0;

		for(int i=0;i<n;i++)
		{
			low=Math.max(low,arr[i]);
			high=high+arr[i];
		}

		while(low<=high)
		{
			int mid=(low+high)/2;

			int painterCount=possibleBoards(arr,n,mid);

			if(painterCount>k)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}

		return low;
	}

	/*
	 * Time Complexity: O(n*(max-sum+1))
	 * Space Complexity: O(1) 
	 * 
	 */
	
	private static int paintersPartitionBrute(int[] arr, int n, int k) {
		
		int max=Integer.MIN_VALUE,sum=0;
		
		for(int i=0;i<n;i++)
		{
			max=Math.max(max,arr[i]);
			sum=sum+arr[i];
		}

		for(int i=max;i<=sum;i++)
		{
			if(possibleBoards(arr, n,i)==k)
			{
				return i;
			}
		}

		return max;
	}
	
	private static int possibleBoards(int arr[],int n,int boards)
    {
        int painter=1,boardSum=0;
        
        for(int i=0;i<n;i++)
        {
            if(boardSum+arr[i]<=boards)
            {
                boardSum=boardSum+arr[i];
            }
            else
            {
                painter++;
                boardSum=arr[i];
            }
        }
        
        return painter;
    }
}
