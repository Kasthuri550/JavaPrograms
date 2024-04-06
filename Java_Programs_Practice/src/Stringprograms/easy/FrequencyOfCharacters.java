package Stringprograms.easy;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfCharacters {

	public static void main(String[] args) {

		String input="eeeejkljls";
		
//		frequencyCharsBrute(input);
//		frequencyCharsBetter(input);
		frequencyCharsOptimal(input);
	}

	private static void frequencyCharsOptimal(String input) {
		
		int frequency[]=new int[256];
		
		for(char c:input.toCharArray())
		{
			frequency[c]++;
		}
		
		for(char c:input.toCharArray())
		{
			if(frequency[c]>0)
			{
				System.out.println(c+" - "+frequency[c]);
			}
		}
		
	}

	private static void frequencyCharsBetter(String input) {
				
		Map<Character, Integer> frequencyMap=new HashMap<Character, Integer>();
		
		for(char c:input.toCharArray())
		{
			frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
		}
		
		for(char c:input.toCharArray())
		{
			System.out.println(c+" - "+frequencyMap.get(c));
		}
		
	}

	private static void frequencyCharsBrute(String input) {
		
		int n=input.length();
		
		for(int i=0;i<n;i++)
		{
			char character=input.charAt(i);
			int repeatedCount=0;
			for(int j=0;j<n;j++)
			{
				if(i!=j && input.charAt(j)==character)
				{
					repeatedCount++;
				}
			}
			
				System.out.println(character+" "+(repeatedCount+1));
		}
	}
}
