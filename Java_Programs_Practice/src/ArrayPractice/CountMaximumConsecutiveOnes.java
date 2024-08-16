package ArrayPractice;

public class CountMaximumConsecutiveOnes {

	public static void main(String[] args) {
		
		int nums[] = { 1, 1, 0, 1, 1, 1 };
		
		maxConsecutiveOnes(nums);
	}

	private static void maxConsecutiveOnes(int[] nums) {
		
		int n = nums.length,count=0,max=0;
		
		for(int i=0;i<n;i++)
		{
			if(nums[i]==1)
			{
				count++;
			}
			else
			{
				count=0;
			}
			
			max=Math.max(max,count);
		}
		
		System.out.println(max);
	}
}
