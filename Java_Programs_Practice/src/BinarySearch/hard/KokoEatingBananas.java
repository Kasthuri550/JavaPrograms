package BinarySearch.hard;

public class KokoEatingBananas {

	public static void main(String[] args) {

		int v[] = {7, 15, 6, 3};
		int h = 8;


		System.out.println(kokoEatingBananasBrute(v,h));

		System.out.println(kokoEatingBananasOptimal(v, h));

	}

	//	Time Complexity: O(N * log(max(a[])))
	//	Space Complexity: O(1)
	
	private static int kokoEatingBananasOptimal(int[] v, int h) {

		int low=1,high=findMax(v);

		while(low<=high)
		{
			int mid=(low+high)/2;

			int totalHours=requiredTime(v,mid);

			if(totalHours<=h)
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

	//Time Complexity: O(max(a[]) * N)
	//	Space Complexity: O(1)

	private static int kokoEatingBananasBrute(int v[], int h) {

		int max=findMax(v);

		for(int i=1;i<=max;i++)
		{
			int totalHours=requiredTime(v,i);

			if(totalHours<=h)
				return i;
		}

		return max;		
	}

	private static int requiredTime(int[] v, int h) {

		int totalHours=0;

		for(int i=0;i<v.length;i++)
		{
			totalHours+=Math.ceil((double)v[i]/(double)h);
		}
		return totalHours;
	}

	private static int findMax(int[] v) {

		int max=v[0];

		for(int i=1;i<v.length;i++)
		{
			max=Math.max(max,v[i]);
		}

		return max;
	}

}
