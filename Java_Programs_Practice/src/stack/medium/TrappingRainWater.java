package stack.medium;

public class TrappingRainWater {

	public static void main(String[] args) {

		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

		System.out.println(trappingRainWaterBrute(height,height.length));
		System.out.println(trappingRainWaterOptimal(height,height.length));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int trappingRainWaterOptimal(int[] height, int n) {

		int left=0,right=n-1,maxLeft=0,maxRight=0,totalWater=0;

		while(left<=right)
		{
			if(height[left]<=height[right])
			{
				if(height[left]>=maxLeft)
				{
					maxLeft=height[left];
				}
				else
				{
					totalWater+=maxLeft-height[left];
				}
			}
			else
			{
				if(height[right]>=maxRight)
				{
					maxRight=height[right];
				}
				else
				{
					totalWater+=maxRight-height[right];
				}
			}
		}

		return totalWater;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */	
	private static int trappingRainWaterBrute(int[] height, int n) {

		int totalWater=0;

		for(int i=0;i<n;i++)
		{
			int maxLeft=0,maxRight=0;


			for(int j=0;j<=i;j++)
			{
				if(height[j]>maxLeft)
				{
					maxLeft=height[j];
				}
			}

			for(int j=i;j<n;j++)
			{
				if(height[j]>maxRight)
				{
					maxRight=height[j];
				}
			}

			totalWater+=Math.min(maxLeft, maxRight) - height[i];
		}

		return totalWater;
	}
}
