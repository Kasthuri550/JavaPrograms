package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllsubsequencesWithGivenSum {

	public static void main(String[] args) {
		
		int arr[]= {1,2,1},K=2;
		
		List<List<Integer>> resultList=new ArrayList<>();
		List<Integer> list=new ArrayList<Integer>();
		
		solver(arr,0,0,K,resultList,list);
		
		System.out.println(resultList);

	}

	private static void solver(int[] arr, int sum, int index, int k,List<List<Integer>> resultList,List<Integer> list) {
		
		if(index==arr.length)
		{
			if(sum==k)
			{
				resultList.add(new ArrayList<Integer>(list));
			}
			return;
		}
		
		list.add(arr[index]);
		solver(arr,sum+arr[index],index+1,k,resultList,list);
		
		list.remove(list.size()-1);
		solver(arr,sum,index+1,k,resultList,list);
		
	}

}
