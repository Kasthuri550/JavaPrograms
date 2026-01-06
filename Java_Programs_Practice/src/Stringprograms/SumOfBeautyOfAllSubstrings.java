package Stringprograms;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings {

	public static void main(String[] args) {

		String s = "aabcb";
		//		System.out.println(substring1(s));
		System.out.println(substring2(s));
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int substring2(String s) {

		int strLength=s.length(),beauty=0;

		for(int i=0;i<strLength;i++)
		{
			Map<Character,Integer> freqMap=new HashMap<Character,Integer>();
			for(int j=i;j<strLength;j++)
			{
				char currentChar = s.charAt(j);
				freqMap.put(currentChar,freqMap.getOrDefault(currentChar,0)+1);

				int minFrequency=Integer.MAX_VALUE,maxFrequency=Integer.MIN_VALUE;

				for(int f:freqMap.values())
				{
					minFrequency=Math.min(minFrequency,f);
					maxFrequency=Math.max(maxFrequency,f);
				}

				beauty+=maxFrequency-minFrequency;
			}
		}

		return beauty;
	}

	private static int substring1(String s) {

		int frequency[]=new int[26],beauty=0;

		for(int i=0;i<s.length();i++)
		{
			StringBuilder sb=new StringBuilder();
			frequency=new int[26];
			for(int j=i;j<s.length();j++)
			{
				frequency[s.charAt(j)-'a']++;

				sb.append(s.charAt(j));
				System.out.println(sb);

				int maxFrequency=0,minFrequency=Integer.MAX_VALUE;

				for(int frequencyOfChar:frequency)
				{
					if(frequencyOfChar>0)
					{
						maxFrequency=Math.max(maxFrequency,frequencyOfChar);
						minFrequency=Math.min(minFrequency, frequencyOfChar);
					}
				}

				beauty+=maxFrequency-minFrequency;

				//				System.out.println(s.substring(i,j+1)+" - "+(maxFrequency-minFrequency));
			}
		}

		return beauty;
	}
}
