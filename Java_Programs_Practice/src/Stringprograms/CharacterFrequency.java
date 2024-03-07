package Stringprograms;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

	public static void main(String[] args) {

		String s="Arun     kumar";
		s=s.replaceAll("[\\s+]","");
//		charFrequency1(s);
		charFrequency2(s);
	}


	private static void charFrequency1(String s) {

		Map<Character,Integer> map=new HashMap<Character,Integer>();

		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
		}

		for(Map.Entry<Character,Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}
	
	private static void charFrequency2(String s) {
		
		int charFrequency[]=new int[256];
		
		for(int i=0;i<s.length();i++)
		{
			charFrequency[s.charAt(i)]++;
		}
		
		for(int j=0;j<charFrequency.length;j++)
		{
			if(charFrequency[j]>0)
			{
				System.out.println((char)j+" - "+charFrequency[j]);
			}
		}
	}
}
