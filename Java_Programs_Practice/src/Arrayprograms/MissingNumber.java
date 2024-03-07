package Arrayprograms;

public class MissingNumber {

	public static void main(String[] args) {
		
		int N = 5;
		int A[] = {1,2,3,5};
		
		System.out.println(missingNum1(A,N));
		System.out.println(missingNum2(A,N));
		System.out.println(missingNum3(A,N));
		System.out.println(missingNum4(A,N));
	}

	private static int missingNum4(int[] a, int n) {
		
		int xor2=0,xor1=0;
		for(int i=0;i<n-1;i++)
		{
			xor2=xor2^a[i];
			xor1=xor1^(i+1);
		}
		xor1=xor1^n;
		return xor1^xor2;
	}

	private static int missingNum3(int[] a, int n) {
		
		int existingSum=0;
		int totalSum=n*(n+1)/2;
		
		for(int i=0;i<n-1;i++)
		{
			existingSum+=a[i];
		}
		return totalSum - existingSum;
	}

	private static int missingNum2(int[] a, int n) {
		
		int miss[]=new int[n+1];
		
		for(int i=0;i<n-1;i++)
		{
			miss[a[i]]++;
		}
		
		for(int j=1;j<=n;j++)
		{
			if(miss[j]==0)
			{
				return j;
			}
		}
		return -1;
	}

	private static int missingNum1(int[] a, int n) {
		
		for(int i=1;i<=n;i++)
		{
			int flag=0;
			for(int j=0;j<n-1;j++)
			{
				if(a[j]==i)
				{
					flag=1;
					break;
				}
			}
			
			if(flag==0)
				return i;
		}
		return -1;
	}
}
