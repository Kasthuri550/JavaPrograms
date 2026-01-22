package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(4^n)
 * Space Complexity: O(n*4^n)
 * */
public class LetterCombinationsOfAPhoneNumber {

	static String map[]= {
			"",
			"",
			"abc",
			"def",
			"ghi",
			"jkl",
			"mno",
			"pqrs",
			"tuv",
			"wxyz"	
	};

	public static void main(String[] args) {

		String digits = "23";

		List<String> result=letterCombinations(digits);
		System.out.println(result);
	}

	private static List<String> letterCombinations(String digits) {

		List<String> result=new ArrayList<>();

		if(digits==null || digits.length()==0)
			return result;

		backTrack(digits,0,new StringBuilder(),result);

		return result;
	}

	private static void backTrack(String digits, int index, StringBuilder current, List<String> result) {

		if(index==digits.length())
		{
			result.add(current.toString());
			return;
		}

		String letters=map[digits.charAt(index)-'0'];

		for(char letter:letters.toCharArray())
		{
			current.append(letter);
			backTrack(digits, index+1, current, result);
			current.deleteCharAt(current.length()-1);
		}
	}
}
