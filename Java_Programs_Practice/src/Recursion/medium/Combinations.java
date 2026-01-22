package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(k*C(n,k))
 * Space Complexity: O(k*C(n,k))
 * */
public class Combinations {

	public static void main(String[] args) {

		int n = 4, k = 2;

		List<List<Integer>> result=combinations(n,k);
		System.out.println(result);
	}

	private static List<List<Integer>> combinations(int n, int k) {

		List<List<Integer>> result=new ArrayList<>();
		List<Integer> current=new ArrayList<Integer>();

		backTrack(1,n,k,current,result);

		return result;
	}

	private static void backTrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {

		if(current.size()==k)
		{
			result.add(new ArrayList<>(current));
			return;
		}

		for(int i=start;i<=n;i++)
		{
			current.add(i);
			backTrack(i+1, n, k, current, result);
			current.remove(current.size()-1);
		}
	}
}
