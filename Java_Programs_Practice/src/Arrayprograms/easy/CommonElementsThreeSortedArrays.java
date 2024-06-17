package Arrayprograms.easy;

import java.util.ArrayList;

public class CommonElementsThreeSortedArrays {
	
	public static void main(String[] args) {
		
		int A[] = {1, 5, 10, 20, 40, 80}, B[] = {6, 7, 20, 80, 100},C[] = {3, 4, 15, 20, 30, 70, 80, 120};
		
		commonElements(A,B,C);
		
	}

	private static void commonElements(int[] a, int[] b, int[] c) {
		
		int aSize=a.length,bSize=b.length,cSize=c.length,i=0,j=0,k=0;
		
		ArrayList<Integer> commonEleList=new ArrayList<Integer>();
		
		while(i<aSize && j<bSize && k<cSize)
		{
			if(a[i]==b[j] && b[j]==c[k])
			{
				if(!commonEleList.contains(a[i]))
				{
					commonEleList.add(a[i]);
				}
				i++;j++;k++;
			}
			else if(a[i]<b[j])
			{
				i++;
			}
			else if(b[j]<c[k])
			{
				j++;
			}
			else
			{
				k++;
			}
		}
		
		System.out.println(commonEleList);
		
	}
}
