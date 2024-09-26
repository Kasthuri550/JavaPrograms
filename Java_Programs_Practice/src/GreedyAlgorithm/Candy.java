package GreedyAlgorithm;

public class Candy {

	public static void main(String[] args) {

		int N = 3,ratings[] = {1, 0, 2};

		System.out.println(candyBrute(N,ratings));	
		System.out.println(candyBetter(N,ratings));
		System.out.println(candyOptimal(N,ratings));

	}

	private static int candyOptimal(int n, int[] ratings) {
		
		int i=1,sum=1;
		
		while(i<n)
		{
			if(ratings[i]==ratings[i-1])
			{
				sum=sum+1;
				i++;
				continue;
			}
			
			int peak=1;
			
			while(i<n && ratings[i]>ratings[i-1])
			{
				peak++;
				sum=sum+peak;
				i++;
			}
			
			int down=1;
			
			while(i<n && ratings[i]<ratings[i-1])
			{
				sum=sum+down;
				i++;
				down++;
			}
			
			if(down>peak)
				sum=sum+(down-peak);
		}
		
		return sum;
	}

	private static int candyBetter(int n, int[] ratings) {

		int left[]=new int[n];

		left[0]=1;
		
		for(int i=1;i<n;i++)
		{
			if(ratings[i]>ratings[i-1])
			{
				left[i]=left[i-1]+1;
			}
			else
			{
				left[i]=1;
			}
		}

		int right=1,curr=1,sum=Math.max(1, left[n-1]);
		
		for(int i=n-2;i>=0;i--)
		{
			if(ratings[i]>ratings[i+1])
			{
				curr=right+1;
				right=curr;
			}
			else
			{
				curr=1;
			}
			
			sum=sum+Math.max(left[i],curr);
		}

		return sum;
	}

	private static int candyBrute(int n, int[] ratings) {

		int left[]=new int[n],right[]=new int[n];

		left[0]=1;
		right[n-1]=1;

		for(int i=1;i<n;i++)
		{
			if(ratings[i]>ratings[i-1])
			{
				left[i]=left[i-1]+1;
			}
			else
			{
				left[i]=1;
			}
		}

		for(int i=n-2;i>=0;i--)
		{
			if(ratings[i]>ratings[i+1])
			{
				right[i]=right[i+1]+1;
			}
			else
			{
				right[i]=1;
			}
		}

		int sum=0;

		for(int i=0;i<n;i++)
		{
			sum+=Math.max(left[i],right[i]);
		}

		return sum;
	}
}
