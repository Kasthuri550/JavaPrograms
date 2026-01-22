package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Time Complexity: O(n*klogk)
 * Space Complexity: O(n*k)
 * */
public class GroupAnagrams {

	public static void main(String[] args) {

		String strs[] = {"eat","tea","tan","ate","nat","bat"};

		System.out.println(groupAnagrams(strs));
	}

	private static List<List<String>> groupAnagrams(String[] strs) {

		Map<String,List<String>> result=new HashMap<>();

		for(String word:strs)
		{
			char[] charArray=word.toCharArray();

			Arrays.sort(charArray);

			String sortedArray=new String(charArray);

			result.computeIfAbsent(sortedArray,k-> new ArrayList<>()).add(word);
		}

		return new ArrayList<>(result.values());
	}
}
