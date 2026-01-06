package Arrayprograms.hard;

public class CountInversion {

	public static void main(String[] args) {
		
		int[] a = {5, 4, 3, 2, 1};
        int n = a.length;
        
        System.out.println(countInversionOptimal(a,n));
//        System.out.println(countInversionBrute(a,n));
	}

	private static int countInversionBrute(int[] a, int n) {
		
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]>a[j])
					count++;
			}
		}
		
		
		return count;
	}

	private static int countInversionOptimal(int[] a, int n) {
		
		return mergeSort(a,0,n-1);
		
	}

	private static int mergeSort(int[] a, int l, int r) {
		
		int count=0;
		
		if(l>=r)
		{
			return count;
		}
		int m=l+(r-l)/2;
		count+=mergeSort(a,l,m);
		count+=mergeSort(a, m+1, r);
		count+=merge(a,l,m,r);
		
		return count;
	}

	private static int merge(int[] a, int l, int m, int r) {
		
		int temp[]=new int[r-l+1];
		int i=l,j=m+1,k=0,count=0;
		while(i<=m && j<=r)
		{
			if(a[i]<=a[j])
			{
				temp[k]=a[i];
				i++;
			}
			else
			{
				temp[k]=a[j];
				count+=(m-i+1);
				j++;
			}
			k++;
		}
		
		while(i<=m)
		{
			temp[k++]=a[i++];
		}
		
		while(j<=r)
		{
			temp[k++]=a[j++];
		}
		
		for(int t=l;t<=r;t++)
		{
			a[t]=temp[t-l];
		}
		
		return count;				
	}

}
