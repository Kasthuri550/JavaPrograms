package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByFrequency {

	public static void main(String[] args) {

		int A[] = {9,9,9,2,5};

		System.out.println(sort1(A,A.length));

	}

	private static ArrayList<Integer> sort1(int[] arr, int n) {

		Integer a[]=new Integer[n];
		Map<Integer,Integer> frequencyMap=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			a[i]=arr[i];
			frequencyMap.put(a[i],frequencyMap.getOrDefault(a[i],0)+1);
		}

		Arrays.sort(a,(x,y)->frequencyMap.get(x)==frequencyMap.get(y)?x-y:frequencyMap.get(y)-frequencyMap.get(x));

		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			resultList.add(a[i]);
		}
		return resultList;
	}

}
