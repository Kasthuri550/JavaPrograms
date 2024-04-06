package Stringprograms.easy;

public class ReplaceSubstring {

	public static void main(String[] args) {
		
		String originalString="Hello World Hello World Hello World";
		String substringToReplace="World";
		String replacement="Java";
		
		String replacedString = replaceSubstringBuiltIn(originalString,substringToReplace,replacement);
		
//		String replacedString = replaceSubstringCustom(originalString,substringToReplace,replacement);
		
		System.out.println(replacedString);
		
	}

	private static String replaceSubstringCustom(String originalString, String substringToReplace, String replacement) {
		
		String[] splitWords = originalString.split(" ");
		
		StringBuilder concat=new StringBuilder();
		
		for(String word:splitWords)
		{
			if(word.equals(substringToReplace))
			{
				concat.append(replacement);
			}
			else
			{
				concat.append(word);
			}
			concat.append(" ");
		}
		return concat.toString().trim();
	}

	private static String replaceSubstringBuiltIn(String originalString, String substringToReplace, String replacement) {
		
		if(!originalString.contains(substringToReplace))
		{
			return originalString;
		}
		
		String replacedString = originalString.replaceAll(substringToReplace, replacement);
		
		return replacedString;
	}
}
