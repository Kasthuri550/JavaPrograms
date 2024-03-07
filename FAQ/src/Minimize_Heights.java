import java.util.Arrays;

public class Minimize_Heights {

	public static void main(String[] args) {

		int[] arr = { 7, 4, 8, 8, 8, 9 };
        int k = 6;
		int minDiff = getMinDiff(arr,arr.length,k);
		System.out.println(minDiff);

	}

	static int getMinDiff(int[] arr, int n, int k) {

		Arrays.sort(arr);
		int ans=arr[n-1]-arr[0];


		int smallest=arr[0]+k;
		int largest=arr[n-1]-k;
		int min,max;

		for(int i=0;i<n-1;i++)
		{
			min=Math.min(smallest,arr[i+1]-k);
			max=Math.max(largest,arr[i]+k);

			if(min<0)
				continue;

			ans=Math.min(ans,max-min);
		}

		return ans;

	}

}
