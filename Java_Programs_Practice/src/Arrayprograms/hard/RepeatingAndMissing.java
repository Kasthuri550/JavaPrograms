package Arrayprograms.hard;

public class RepeatingAndMissing {

	public static void main(String[] args) {
		
		int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
		
		RepeatAndMissElementsBrute(a);
		RepeatAndMissElementsBetter(a);
		RepeatAndMissElementsOptimal(a);
	}

	private static void RepeatAndMissElementsOptimal(int[] a) {
		
		long n=a.length;
		long sn=(n*(n+1))/2;
		long sn2=(n*(n+1)*(2*n+1))/6;
		long s=0,s2=0;
		
		for(int i=0;i<n;i++)
		{
			s+=a[i];
			s2+=(long)a[i]*a[i];
		}
		
		long val1=s-sn;
		long val2=s2-sn2;
		
		val2=val2/val1;
		long x=(val1+val2)/2;
		long y=x-val1;
		
		System.out.println(x+","+y);
		
	}

	private static void RepeatAndMissElementsBetter(int[] a) {
		
		int n=a.length;
		int hashArr[]=new int[n+1];
		int repeating=-1,missing=-1;
		
		for(int i=0;i<n;i++)
		{
			hashArr[a[i]]++;
		}
		
		for(int i=1;i<=n;i++)
		{
			if(hashArr[i]>1)
			{
				repeating=i;
			}
			else if(hashArr[i]==0)
			{
				missing=i;
			}
			if(repeating!=-1 && missing!=-1) break;
		}
		
		System.out.println(repeating+","+missing);
		
	}

	private static void RepeatAndMissElementsBrute(int[] a) {
		
		int n=a.length,repeating=-1,missing=-1;
		
		for(int i=1;i<=n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(a[j]==i)
				{
					count++;
				}
			}
			
			if(count==2) repeating=i;
			else if(count==0) missing=i;
			if(repeating!=-1 && missing!=-1) break;			
		}
		
		System.out.println(repeating+","+missing);
	}
}
