package Stringprograms.medium;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		
		String s = "egg", t = "add";
		
		if(isomorphic(s,t))
		{
			System.out.println("Isomorphic");
		}
		else
		{
			System.out.println("Not Isomorphic");
		}

	}

	private static boolean isomorphic(String s, String t) {
		
		HashMap<Character,Character> charMap=new HashMap<Character, Character>();
		
		if(s.length()!=t.length())
		{
			return false;
		}
		
		for(int i=0;i<s.length();i++)
		{
			if(charMap.containsKey(s.charAt(i)))
			{
				if(charMap.get(s.charAt(i))!=t.charAt(i))
				{
					return false;
				}
			}
			else
			{
				if(charMap.containsValue(t.charAt(i)))
				{
					return false;
				}
				
				charMap.put(s.charAt(i),t.charAt(i));
			}
		}
		
		return true;		
	}
}
