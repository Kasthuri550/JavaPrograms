package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(2^T)
 * Space Complexity: O(T)
 * */
public class CombinationSum {

	public static void main(String[] args) {

		int candidates[] = {2,3,6,7}, target = 7;

		List<List<Integer>> result=combinationSumOptimal(candidates,target);
		System.out.println(result);
	}

	private static List<List<Integer>> combinationSumOptimal(int[] candidates, int target) {

		List<List<Integer>> result=new ArrayList<>();

		backTrack(0,candidates,target,new ArrayList<>(),result);

		return result;
	}

	private static void backTrack(int index, int[] candidates, int target,List<Integer> current,
			List<List<Integer>> result) {

		if(target==0)
		{
			result.add(new ArrayList<Integer>(current));
			return;
		}

		if(target<0)
			return;

		for(int i=index;i<candidates.length;i++)
		{
			current.add(candidates[i]);
			backTrack(i, candidates, target-candidates[i], current, result);	
			current.remove(current.size()-1);
		}
	}
}
