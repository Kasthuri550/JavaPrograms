package Stringprograms;

import java.util.Arrays;

public class RemoveSubstring {

	public static void main(String[] args) {
		
		String originalString="Kasthuri is a good girl girl good";
		String substringToRemove="good";
		
		System.out.println(remove(originalString,substringToRemove));
	}

	private static String remove(String originalString, String substringToRemove) {
		
		String modifiedString="";
		String words[]=originalString.split("\\s+");
		
		for(String word:words)
		{
			if(!word.equals(substringToRemove))
			{
				modifiedString=modifiedString+word+" ";			
			}
			
		}
		
		return modifiedString.trim();
	}

}
