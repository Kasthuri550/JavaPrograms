package Recursion.medium;

import java.util.ArrayList;

/*TC=O(9^k)
SC=O(k) (recursion)+O(k⋅C(9,k)) */


public class CombinationSumIII {

	public static void main(String[] args) {
		
		int k = 3, n = 9;
		
		System.out.println(combinations(k,n));

	}

	private static ArrayList<ArrayList<Integer>> combinations(int k, int n) {
		
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		
		backTrack(1,k,n,result,new ArrayList<>());
		
		return result;		
	}

	private static void backTrack(int start, int k, int n, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList) {

		if(tempList.size()==k && n==0)
		{
			result.add(new ArrayList<Integer>(tempList));
			return;
		}
		else if(tempList.size()>k && n<0)
		{
			return;
		}
		
		for(int i=start;i<=9;i++)
		{
			tempList.add(i);
			backTrack(i+1, k, n-i, result,tempList);
			tempList.remove(tempList.size()-1);
		}
	}
}
