package Arrayprograms;

public class EquilibriumIndex {

	public static void main(String[] args) {
		
		int arr[] = { 1,2,3,4,5,1,3,2,4 };
        int arr_size = arr.length;
        
//        System.out.println(equilibrium_index1(arr,arr_size));
//        System.out.println(equilibrium_index2(arr,arr_size));
        System.out.println(equilibrium_index3(arr,arr_size));
	}

	private static int equilibrium_index3(int[] arr, int arr_size) {
		
		int mid=arr_size/2;
		int leftSum=0,rightSum=0;
		
		for(int i=0;i<mid;i++)
		{
			leftSum+=arr[i];
		}
		
		for(int j=mid+1;j<arr_size;j++)
		{
			rightSum+=arr[j];
		}
		
		if(rightSum > leftSum)
		{
			while(rightSum > leftSum  && mid<arr_size-1)
			{
				rightSum-=arr[mid+1];
				leftSum+=arr[mid];
				mid++;
			}
		}
		else
		{
			while(leftSum > rightSum && 0 < mid)
			{
				leftSum-=arr[mid-1];
				rightSum+=arr[mid];
				mid--;
			}
		}
		
		if(leftSum == rightSum)
		{
			return mid;
		}
			
		return -1;
	}

	private static int equilibrium_index2(int[] arr, int arr_size) {
		
		for(int i=0;i<arr_size;i++)
		{
			int leftSum=0;
			for(int k=0;k<i;k++)
			{
				leftSum+=arr[i];
			}
			int rightSum=0;
			for(int j=i+1;j<arr_size;j++)
			{
				rightSum+=arr[i];
			}
			
			if(leftSum==rightSum)
				return i;
		}
		return -1;
	}

	private static int equilibrium_index1(int[] arr, int arr_size) {
		
		int sum=0,leftSum=0;
		
		for(int i=0;i<arr_size;i++)
		{
			sum+=arr[i];			
		}
		
		for(int j=0;j<arr_size;j++)
		{
			sum-=arr[j];
			if(leftSum==sum)
				return j;
			
			leftSum+=arr[j];
		}
		return -1;
	}

}
