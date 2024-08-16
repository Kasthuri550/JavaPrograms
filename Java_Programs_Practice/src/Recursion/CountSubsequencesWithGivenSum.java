package Recursion;

public class CountSubsequencesWithGivenSum {

	public static void main(String[] args) {
		
		int arr[]= {1,2,1},sum=2;
		
		System.out.println(countAllSubsequences(arr,0,0,sum));
	}

	private static int countAllSubsequences(int[] arr, int result,int index,int sum) {
		
		if(result>sum) return 0;
		
		if(arr.length==index)
		{
			if(result==sum)
				return 1;
			else 
				return 0;
		}
		
		int left=countAllSubsequences(arr,result+arr[index], index+1,sum);
		
		int right=countAllSubsequences(arr, result, index+1, sum);
		
		return left+right;		
	}
}
