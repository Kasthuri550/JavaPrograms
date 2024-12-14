package ArrayPractice;

public class RepeatingAndMissingNumbers {

	public static void main(String[] args) {

		int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
		
		repeatingAndMissingBrute(a);
		repeatingAndMissingBetter(a);
		repeatingAndMissingOptimal(a);
	}

	private static void repeatingAndMissingOptimal(int[] a) {
		
		int n=a.length;
		int sn=n*(n+1)/2;
		int sn2=(n*(n+1)*(2*n+1))/6;
		int s=0,s2=0;
		
		for(int i=0;i<n;i++)
		{
			s+=a[i];
			s2+=a[i]*a[i];
		}
		
		int val1=s-sn;
		int val2=s2-sn2;
		
		val2=val2/val1;
		
		int x=(val1+val2)/2;
		int y=x-val1;
		
		System.out.println("repeating= "+x+" missing= "+y);
		
	}

	private static void repeatingAndMissingBetter(int[] arr) {
		
		int n=arr.length,repeating=-1,missing=-1;
		int hash[]=new int[n+1];
		
		for(int i=0;i<n;i++)
		{
			hash[arr[i]]++;
		}
		
		for(int i=1;i<=n;i++)
		{
			if(hash[i]==2)
			{
				repeating=i;
			}
			else if(hash[i]==0)
			{
				missing=i;
			}
			
			if(repeating!=-1 && missing!=-1)
				break;
		}
		
		System.out.println("repeating= "+repeating+" missing= "+missing);
	}

	private static void repeatingAndMissingBrute(int[] arr) {
		
		int n=arr.length,repeating=-1,missing=-1;
		
		for(int i=1;i<=n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(arr[j]==i)
					count++;
			}
			
			if(count==2) repeating=i;
			else if(count==0) missing=i;
			
			if(repeating!=-1 && missing!=-1)
				break;
				
		}
		
		System.out.println("repeating= "+repeating+" missing= "+missing);
	}
}
