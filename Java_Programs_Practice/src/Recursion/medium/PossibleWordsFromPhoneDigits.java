package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*Time Complexity = O(4^N)
Space Complexity = O(N * 4^N)*/

public class PossibleWordsFromPhoneDigits {

	private static final String[] KEYPAD= {
			"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
	};

	public static void main(String[] args) {

		int N = 3, a[] = {2, 3, 4};

		System.out.println(phoneDigits(N,a));
	}

	private static List<String> phoneDigits(int n, int[] a) {

		List<String> result=new ArrayList<>();

		if(n==0)
		{
			return result;
		}

		backTrack(n,a,0,new StringBuilder(),result);

		return result;		
	}

	private static void backTrack(int n, int[] a, int index, StringBuilder current, List<String> result) {

		if(index==n)
		{
			result.add(current.toString());
			return;
		}

		String letters=KEYPAD[a[index]];

		for(char letter:letters.toCharArray())
		{
			current.append(letter);
			backTrack(n, a, index+1, current, result);
			current.deleteCharAt(current.length()-1);
		}
	}
}
