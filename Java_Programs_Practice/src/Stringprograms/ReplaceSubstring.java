package Stringprograms;

public class ReplaceSubstring {

	public static void main(String[] args) {
		
		String originalString="Kasthuri is a good girl girl good";
		String substringToReplace="good";
		String replacement="bad";
		
		System.out.println(replace1(originalString,substringToReplace,replacement));
		System.out.println(replace2(originalString,substringToReplace,replacement));
	}

	private static String replace2(String originalString, String substringToReplace, String replacement) {
		
		StringBuilder stringBuilder=new StringBuilder();
		String[] words=originalString.split("\\s+");
		for(String word:words)
		{
			if(word.equals(substringToReplace))
			{
				stringBuilder.append(replacement).append(" ");
			}
			else
			{
				stringBuilder.append(word).append(" ");
			}
			
		}
		return stringBuilder.toString().trim();
	}

	private static String replace1(String originalString, String substringToReplace, String replacement) {
		
		if(!originalString.contains(substringToReplace))
		{
			return originalString;
		}
		
		String modifiedString=originalString.replaceAll(substringToReplace,replacement);
		
		return modifiedString;
	}

}
