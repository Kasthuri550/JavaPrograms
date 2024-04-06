package Stringprograms.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		String input="eeeejkljls";
		
//		char firstNonRepeatChar=nonRepeatingCharBrute(input);
//		char firstNonRepeatChar=nonRepeatingCharBetter(input);
//		char firstNonRepeatChar=nonRepeatingCharOptimal1(input);
		char firstNonRepeatChar=nonRepeatingCharOptimal2(input);
		System.out.println(firstNonRepeatChar);
	}

	private static char nonRepeatingCharOptimal2(String input) {
		
		int frequency[]=new int[256];
		
		for(char c:input.toCharArray())
		{
			frequency[c]++;
		}
		
		for(char c:input.toCharArray())
		{
			if(frequency[c]==1)
			{
				return c;
			}
		}
		return 0;
	}

	private static char nonRepeatingCharOptimal1(String input) {
		
		if(input==null || input.isEmpty())
		{
			return ' ';
		}
		
		Map<Character,Integer> frequencyMap=new LinkedHashMap<Character, Integer>();
		
		for(char c:input.toCharArray())
		{
			frequencyMap.put(c, frequencyMap.getOrDefault(c,0)+1);
		}
		
		for(Map.Entry<Character,Integer> entry : frequencyMap.entrySet())
		{
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}
		return 0;
	}

	private static char nonRepeatingCharBetter(String input) {
		
		if(input == null || input.isEmpty())
		{
			return ' ';
		}
		
		Map<Character,Integer> frequencyMap=new HashMap<Character, Integer>();
		
		for(char c:input.toCharArray())
		{
			frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
		}
		
		for(char c:input.toCharArray())
		{
			if(frequencyMap.get(c)==1)
			{
				return c;
			}
		}
		return 0;
	}

	private static char nonRepeatingCharBrute(String input) {
		
		if (input == null || input.isEmpty()) {
            return ' ';
        }

        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char character = input.charAt(i);
            boolean repeated = false;
            for (int j = 0; j < inputLength; j++) {
                if (i != j && character == input.charAt(j)) { 
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                return character;
            }
        }
        return '\0';
	}
}
