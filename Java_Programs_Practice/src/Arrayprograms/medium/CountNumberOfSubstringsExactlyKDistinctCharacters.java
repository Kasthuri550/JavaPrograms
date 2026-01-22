package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 * */
public class CountNumberOfSubstringsExactlyKDistinctCharacters {

	public static void main(String[] args) {

		String s = "pqpqs";
		int k = 2;

		System.out.println(countNumberOfSubstrings(s,k));
	}

	private static int countNumberOfSubstrings(String s, int k) {

		return atMostKDistinct(s,k) - atMostKDistinct(s,k-1);
	}

	private static int atMostKDistinct(String s, int k) {

		int left=0,right=0,n=s.length(),result=0;

		Map<Character,Integer> freqMap=new HashMap<>();

		while(right<n)
		{
			char rightChar=s.charAt(right);
			freqMap.put(rightChar,freqMap.getOrDefault(rightChar, 0)+1);

			while(freqMap.size()>k)
			{
				char leftChar=s.charAt(left);
				freqMap.put(leftChar,freqMap.get(leftChar)-1);
				if(freqMap.get(leftChar)==0)
					freqMap.remove(leftChar);
				left++;
			}

			result+=(right-left+1);
			right++;
		}

		return result;
	}
}
