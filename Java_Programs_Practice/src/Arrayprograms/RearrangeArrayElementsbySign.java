package Arrayprograms;

import java.util.Arrays;

public class RearrangeArrayElementsbySign {

	public static void main(String[] args) {
		
		int A[]= {1,2,-4,-5};
		int A1[]={1,2,-4,-5,3,4};
		
//		rearrangeBySign1(A,A.length);
//		rearrangeBySign2(A,A.length);
		rearrangeBySign3(A1,A1.length);
	}

	private static void rearrangeBySign3(int[] a, int n) {
		
		int positive[]=new int[n];
		int negative[]=new int[n];
		int pos=0,neg=0;
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				positive[pos]=a[i];
				pos++;
			}
			else
			{
				negative[neg]=a[i];
				neg++;
			}
		}
		
		
		if(pos > neg)
		{
			for(int i=0;i<neg;i++)
			{
				a[i*2]=positive[i];
				a[i*2+1]=negative[i];
			}
			
			int index=neg*2;
			for(int j=index;j<pos;j++)
			{
				a[index]=a[j];
				index++;
			}
		}
		else
		{
			for(int i=0;i<pos;i++)
			{
				a[i*2]=positive[i];
				a[i*2+1]=negative[i];
			}
			int index=pos*2;
			for(int j=index;j<neg;j++)
			{
				a[index]=a[j];
				index++;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void rearrangeBySign2(int[] a, int n) {
		
		int ans[]=new int[n];
		int positiveIndex=0,negativeIndex=1;
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				ans[positiveIndex]=a[i];
				positiveIndex+=2;
			}
			else
			{
				ans[negativeIndex]=a[i];
				negativeIndex+=2;
			}
		}
		
		System.out.println(Arrays.toString(ans));
	}

	private static void rearrangeBySign1(int[] a, int n) {
		
		int negative[]=new int[n/2];
		int positive[]=new int[n/2];
		int pos=0;
		int neg=0;
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				positive[pos]=a[i];
				pos++;
			}
			else
			{
				negative[neg]=a[i];
				neg++;
			}
		}
		
		for(int j=0;j<n/2;j++)
		{
			a[j*2]=positive[j];
			a[j*2+1]=negative[j];
		}
		
		System.out.println(Arrays.toString(a));
	}
}
