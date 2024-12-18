package BinarySearchTree.medium;

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		
		int weights[] = {5, 4, 5, 2, 3, 4, 5, 6};
//		int weights[] = {1,2,1};
        int d = 5;
//        int d=2;
        
       System.out.println(capacityToShipPackagesWithinDDaysBrute(weights,d));
       System.out.println(capacityToShipPackagesWithinDDaysOptimal(weights, d));

	}

	/*
	 * Time Complexity: O(n*log(high-low+1))
	 * Space Complexity: O(1)
	 * 
	 */
	private static int capacityToShipPackagesWithinDDaysOptimal(int[] weights, int d) {

		int n=weights.length,low=Integer.MIN_VALUE,high=0;
		
		for(int i=0;i<n;i++)
		{
			low=Math.max(low,weights[i]);
			high=high+weights[i];
		}
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(findDays(weights, n, mid)<=d)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		
		return low;
	}
	
	/*
	 * Time Complexity: O(n*(high-low+1))
	 * Space Complexity: O(1)
	 * 
	 */
	private static int capacityToShipPackagesWithinDDaysBrute(int[] weights, int d) {
		
		int n=weights.length,max=Integer.MIN_VALUE,sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+weights[i];
			max=Math.max(max,weights[i]);
		}
		
		for(int i=max;i<=sum;i++)
		{
			if(findDays(weights,n,i)<=d)
			{
				return i;
			}
		}
		
		return -1;		
	}

	private static int findDays(int[] weights,int n,int capacity) {
		
		int load=0,days=1;

		for(int i=0;i<n;i++)
		{
			if(load+weights[i]>capacity)
			{
				days++;
				load=weights[i];
			}
			else
			{
				load=load+weights[i];
			}
		}
		return days;
	}

}
