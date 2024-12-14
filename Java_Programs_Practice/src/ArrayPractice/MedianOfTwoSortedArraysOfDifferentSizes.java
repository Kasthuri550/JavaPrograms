package ArrayPractice;

import java.util.ArrayList;

public class MedianOfTwoSortedArraysOfDifferentSizes {

	public static void main(String[] args) {

		int[] a = {1, 4, 7, 10, 12};
		int[] b = {2, 3, 6, 15};
		
		System.out.println(medianBrute(a,b));
		System.out.println(medianBetter(a,b));

	}

	private static double medianBetter(int[] a, int[] b) {
		
		int n1=a.length,n2=b.length,i=0,j=0;
		int n=n1+n2,count=0;
		int index1=n/2,index2=(n/2)-1;
		int indexEle1=-1,indexEle2=-1;
		
		while(i<n1 && j<n2)
		{
			if(a[i]<b[j])
			{
				if(index1==count) 
					indexEle1=a[i];
				if(index2==count)
					indexEle2=a[i];
				count++;
				i++;
			}
			else
			{
				if(index1==count) 
					indexEle1=b[j];
				if(index2==count)
					indexEle2=b[j];
				count++;
				j++;
			}
		}
		
		while(i<n1)
		{
			if(index1==count) 
				indexEle1=a[i];
			if(index2==count)
				indexEle2=a[i];
			count++;
			i++;
		}
		
		while(j<n2)
		{
			if(index1==count) 
				indexEle1=b[j];
			if(index2==count)
				indexEle2=b[j];
			count++;
			j++;
		}
		
		if(n%2==1) return (double)indexEle2;
		
		return (double)((double)(indexEle1+indexEle2))/2.0;
	}

	private static double medianBrute(int[] a, int[] b) {
		
		int n1=a.length,n2=b.length,i=0,j=0;
		
		ArrayList<Integer> arr3=new ArrayList<>();
		
		while(i<n1 && j<n2)
		{
			if(a[i]<b[j])
			{
				arr3.add(a[i++]);
			}
			else
			{
				arr3.add(b[j++]);
			}
		}
		
		while(i<n1)
		{
			arr3.add(a[i++]);
		}
		
		while(j<n2)
		{
			arr3.add(b[j++]);
		}
		
		int n=n1+n2;
		
		if(n%2==1) return (double)arr3.get(n/2);
		
		return ((double)arr3.get(n/2)+(double)arr3.get((n/2)-1))/2.0;
	}
}
