package Stringprograms;

import java.util.ArrayList;

public class PrintAllSubsequences {

	public static void main(String[] args) {
		
		int arr[]= {3,1,2};
		subsequences(arr,0,arr.length,new ArrayList<Integer>());
	}

	private static void subsequences(int[] arr, int start, int end, ArrayList<Integer> arrayList) {
				
		if(start>=end)
		{
			System.out.println(arrayList);
			return;
		}
		
		arrayList.add(arr[start]);
		subsequences(arr,start+1,end, arrayList);
		arrayList.remove(arrayList.size()-1);
	    subsequences(arr,start+1,end, arrayList);	
	}

}
