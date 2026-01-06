package ArrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Brute	O(n)	O(n)
Better	O(n)	O(n)
Optimal	O(n)	O(n)
inplace o(n) o(1)
 * */
public class RearrangeArrayPositiveAndNegative {

	public static void main(String[] args) {
		
		int[] arr = {-1, 6, -2, 3, -4, 9};
		
//		rearrangePosNegBrute(arr);
//		rearrangePosNegBetter(arr);
		rearrangePosNegOptimal(new int[] {-1, 6, -2, 3, -4, 9,7,1,0});
//		rearrangePosNegInPlace(new int[] {-1, 6, -2, 3, -4, 9,7,1,0});
		
	}
	
	private static void rearrangePosNegInPlace(int[] arr) {

	    int n = arr.length;
	    int posIndex = 0, negIndex = 1;

	    while (posIndex < n && negIndex < n) {

	        // correct position, move ahead
	        if (arr[posIndex] > 0) {
	            posIndex += 2;
	        }
	        else if (arr[negIndex] < 0) {
	            negIndex += 2;
	        }
	        // swap incorrect elements
	        else {
	            int temp = arr[posIndex];
	            arr[posIndex] = arr[negIndex];
	            arr[negIndex] = temp;

	            posIndex += 2;
	            negIndex += 2;
	        }
	    }

	    System.out.println(Arrays.toString(arr));
	}

	private static void rearrangePosNegOptimal(int[] arr) {
		
		int n=arr.length;
		ArrayList<Integer> pos=new ArrayList<>();
		ArrayList<Integer> neg=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				pos.add(arr[i]);
			}
			else
			{
				neg.add(arr[i]);
			}
		}
		
		if(pos.size()<neg.size())
		{
			for(int i=0;i<pos.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=2*pos.size();
			for(int i=pos.size();i<neg.size();i++)
			{
				arr[index]=neg.get(i);
				index++;
			}
		}
		else
		{
			for(int i=0;i<neg.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=2*neg.size();
			for(int i=neg.size();i<pos.size();i++)
			{
				arr[index]=pos.get(i);
				index++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void rearrangePosNegBetter(int[] arr) {
		
		int n=arr.length,posIndex=0,negIndex=1;
		
		ArrayList<Integer> result=new ArrayList<Integer>(Collections.nCopies(n,0));
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				result.set(posIndex,arr[i]);
				posIndex+=2;
			}
			else
			{
				result.set(negIndex, arr[i]);
				negIndex+=2;
			}
		}
		
		System.out.println(result);
		
	}

	private static void rearrangePosNegBrute(int[] arr) {
		
		int n=arr.length;
		
		ArrayList<Integer> pos=new ArrayList<>();
		ArrayList<Integer> neg=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				pos.add(arr[i]);
			}
			else
			{
				neg.add(arr[i]);
			}
		}
		
		for(int i=0;i<n/2;i++)
		{
			arr[2*i]=pos.get(i);
			arr[2*i+1]=neg.get(i);
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
