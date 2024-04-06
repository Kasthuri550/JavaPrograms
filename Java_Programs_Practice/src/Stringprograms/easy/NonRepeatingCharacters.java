package Stringprograms.easy;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacters {

	public static void main(String[] args) {
		
		String input="eeeejkljls";
		
//		nonRepeatCharsBrute(input);
//		nonRepeatCharsBetter(input);
		nonRepeatCharsOptimal(input);

	}

	private static void nonRepeatCharsOptimal(String input) {
		
		int frequency[]=new int[256];
		
		for(char c: input.toCharArray())
		{
			frequency[c]++;
		}
		
		for(char c:input.toCharArray())
		{
			if(frequency[c]==1)
			{
				System.out.println(c);
			}
		}
		
	}

	private static void nonRepeatCharsBetter(String input) {
		
		Map<Character,Integer> frequencyMap=new HashMap<>();
		
		for(char c:input.toCharArray())
		{
			frequencyMap.put(c, frequencyMap.getOrDefault(c,0)+1);
		}
		
		for(char c:input.toCharArray())
		{
			if(frequencyMap.get(c)==1)
			{
				System.out.println(c);
			}
		}
		
	}

	private static void nonRepeatCharsBrute(String input) {
		
		int n=input.length();
		
		for(int i=0;i<n;i++)
		{
			char character=input.charAt(i);
			boolean repeated=false;
			for(int j=0;j<n;j++)
			{
				if(i!=j && input.charAt(j)==character)
				{
					repeated=true;
					break;
				}
			}
			
			if(!repeated)
			{
				System.out.println(character);
			}
		}	
	}

}
