package ArrayPractice;

public class MissingNumber {

	public static void main(String[] args) {
		
		int N = 5;
        int a[] = {1, 2, 4, 5};
        
       System.out.println(missingNumberBrute(a,N));
       System.out.println(missingNumberBetter(a,N));
       System.out.println(missingNumberOptimal1(a,N));
       System.out.println(missingNumberOptimal2(a,N));
	}

	private static int missingNumberOptimal2(int[] a, int n) {
		
		int xor1=0,xor2=0;
		
		for(int i=0;i<n-1;i++)
		{
			xor1=xor1^(i+1);
			xor2=xor2^a[i];
		}
		
		xor1=xor1^n;
		
		return xor1^xor2;
	}

	private static int missingNumberOptimal1(int[] a, int n) {
		
		int sum1=(n*(n+1))/2,sum2=0;
		for(int i=0;i<n-1;i++)
		{
			sum2+=a[i];
		}
		
		int missing=sum1-sum2;
		return missing;
	}

	private static int missingNumberBetter(int[] a, int n) {
		
		int hash[]=new int[n+1];
		
		for(int i=0;i<n-1;i++)
		{
			hash[a[i]]++;
		}
		
		for(int i=1;i<=n;i++)
		{
			if(hash[i]==0)
			{
				return i;
			}
		}
		return -1;
	}

	private static int missingNumberBrute(int[] a, int n) {
		
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
			
			if(flag==0) return i;
		}
		
		return -1;
	}
}
