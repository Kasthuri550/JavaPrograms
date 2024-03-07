import java.util.HashMap;

public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		
		int N = 4, K = 6;
	    int arr[] = {1, 5, 7, 1};
		int cnt=count(arr,N,K);
		System.out.println(cnt);

	}

	private static int count(int[] arr, int n, int k) {
		
		int count=0;
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(arr[i]))
			{
				map.put(arr[i],map.get(arr[i])+1);
			}
			else
			{
				map.put(arr[i],1);
			}
			if(map.containsKey(k-arr[i]))
			{
				count+=map.get(k-arr[i]);
			}
		}
		return count;
		
	}

}
