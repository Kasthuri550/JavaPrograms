package Arrayprograms;

import java.util.ArrayList;
import java.util.List;

public class ArraySubset {

	public static void main(String[] args) {
		
		int arr1[] = {11, 7, 1, 13, 21, 3, 7, 3};
		int arr2[] = {11, 3, 7, 1, 7};
	     
//	     subset1(arr1,arr2);
	     boolean status=subset2(arr1,arr2);
	     
	     if(status)
			{
				System.out.println("Arrays are subset");
			}
			else
			{
				System.out.println("Arrays are not subset");
			}

	}

	private static boolean subset2(int[] a1, int[] a2) {
		int n=a1.length,m=a2.length;
		List<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
        {
            al.add(a1[i]);
        }
        
        
        for(int j=0;j<m;j++)
        {
            if(al.contains(a2[j]))
            {            	
                al.remove(Integer.valueOf(a2[j]));
            }
            else
            {
                return false;
            }
            
        }
        
        return true;
		
	}

	private static void subset1(int[] arr1, int[] arr2) {
		
		boolean status=true;
		
		for(int i=0;i<arr2.length;i++)
		{
			int j;
			for(j=0;j<arr1.length;j++)
			{
				if(arr2[i]==arr1[j])
					break;
			}
			
			if(j==arr1.length)
			{
				status=false;
			}
		}
		
		if(status)
		{
			System.out.println("Arrays are subset");
		}
		else
		{
			System.out.println("Arrays are not subset");
		}
		
	}

}
