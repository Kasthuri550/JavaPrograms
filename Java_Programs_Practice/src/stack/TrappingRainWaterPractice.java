package stack;

public class TrappingRainWaterPractice {

	public static void main(String[] args) {
		
		int height[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		
//		trapRainWaterBrute(height);
//		trapRainWaterBetter(height);
		trapRainWaterOptimal(height);
	}

	private static void trapRainWaterOptimal(int[] height) {
		
		int n=height.length,waterTrapped=0,maxLeft=0;
		int left=0,right=n-1,maxRight=0;
		
		while(left<=right)
		{
			if(height[left]<=height[right])
			{
				if(maxLeft<=height[left])
				{
					maxLeft=height[left];
				}
				else
				{
					waterTrapped+=maxLeft-height[left];
				}
				left++;
			}
			else
			{
				if(maxRight<=height[right])
				{
					maxRight=height[right];
				}
				else
				{
					waterTrapped+=maxRight-height[right];
				}
				right--;
			}
		}
		System.out.println(waterTrapped);
		
	}

	private static void trapRainWaterBetter(int[] height) {
		
		int n=height.length,waterTrapped=0;
		int prefix[]=new int[n];
		int suffix[]=new int[n];
		prefix[0]=height[0];
		
		for(int i=1;i<n;i++)
		{
			prefix[i]=Math.max(prefix[i-1],height[i]);
		}
		
		suffix[n-1]=height[n-1];
		
		for(int i=n-2;i>=0;i--)
		{
			suffix[i]=Math.max(suffix[i+1],height[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			waterTrapped+=Math.min(prefix[i],suffix[i])-height[i];
		}
		System.out.println(waterTrapped);
	}

	private static void trapRainWaterBrute(int[] height) {
		
		int n=height.length,j,waterTrapped=0;
		
		for(int i=0;i<n;i++)
		{
			j=i;
			int maxLeft=0,maxRight=0;
			while(j>=0)
			{
				maxLeft=Math.max(maxLeft, height[j]);
				j--;
			}
			
			j=i;
			while(j<n)
			{
				maxRight=Math.max(maxRight, height[j]);
				j++;
			}
			
			waterTrapped+=Math.min(maxLeft, maxRight)-height[i];
		}
		System.out.println(waterTrapped);
		
	}
}
