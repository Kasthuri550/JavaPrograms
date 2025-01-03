package BinarySearch.hard;

import java.util.PriorityQueue;


public class MinimizeMaxDistanceToGasStation {

	public static class Pair
	{
		double diff;
		int index;

		public Pair(double diff, int index) {
			super();
			this.diff = diff;
			this.index = index;
		}
	}

	public static void main(String[] args) {

		int n = 10,stations[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},k = 9;

		System.out.println(minimizeMaxDistanceToGasStationBrute(stations,n,k));
		System.out.println(minimizeMaxDistanceToGasStationBetter(stations, n, k));
		System.out.println(minimizeMaxDistanceToGasStationOptimal(stations, n, k));

	}
	
/*
 * Time Complexity: O(n*log(len))+O(n)
 * Space Complexity: O(1)
 * 
 */	
	
	private static double minimizeMaxDistanceToGasStationOptimal(int[] stations, int n, int k) {
		
		double low=0,high=0;
		
		for(int i=0;i<n-1;i++)
		{
			high=Math.max(high,stations[i+1]-stations[i]);
		}
		
		double diff=1e-6;
		
		while(high-low>diff)
		{
			double mid=(low+high)/2;
			int count=numberOfGasStationsRequired(stations,n,mid);
			
			if(count>k)
			{
				low=mid;
			}
			else
			{
				high=mid;
			}
		}
		
		return high;
	}

	private static int numberOfGasStationsRequired(int[] stations,int n,double mid) {

		int count=0;
		
		for(int i=0;i<n-1;i++)
		{
			int numberInBetween=(int)((stations[i+1]-stations[i])/mid);
			
			if((stations[i+1]-stations[i])==mid*numberInBetween)
			{
				numberInBetween--;
			}
			
			count+=numberInBetween;
		}

		return count;
	}
	
	/*
	 * Time Complexity: O(nlogn)+O(klogn)
	 * Space Complexity: O(n-1)+O(n-1)
	 * 
	 */

	private static double minimizeMaxDistanceToGasStationBetter(int[] stations, int n, int k) {

		PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b)-> Double.compare(b.diff,a.diff));

		int howMany[]=new int[n-1];

		for(int i=0;i<n-1;i++)
		{
			pq.offer(new Pair(stations[i+1]-stations[i],i));
		}

		for(int gasStations=1;gasStations<=k;gasStations++)
		{
			Pair pair=pq.poll();

			int index=pair.index;

			howMany[index]++;

			double diff=stations[index+1]-stations[index];			
			double newSectionLength=diff/(double)(howMany[index]+1);
			pq.offer(new Pair(newSectionLength,index));
		}		

		return pq.peek().diff;
	}


	/*
	 * Time Complexity: O(n*k)+O(n)
	 * Space Complexity: O(n-1)
	 * 
	 */

	private static double minimizeMaxDistanceToGasStationBrute(int[] stations, int n, int k) {

		int howMany[]=new int[n-1];

		for(int gasStations=1;gasStations<=k;gasStations++)
		{
			double maxSection=-1;
			int maxInd=-1;

			for(int i=0;i<n-1;i++)
			{
				double diff=stations[i+1]-stations[i];
				double sectionLength=diff/(double)(howMany[i]+1);

				if(maxSection<sectionLength)
				{
					maxSection=sectionLength;
					maxInd=i;
				}
			}

			howMany[maxInd]++;
		}

		double maxAns=-1;		
		for(int i=0;i<n-1;i++)
		{
			int diff=stations[i+1]-stations[i];
			double sectionLength=diff/(double)(howMany[i]+1);
			maxAns=Math.max(maxAns, sectionLength);
		}

		return maxAns;		
	}
}
