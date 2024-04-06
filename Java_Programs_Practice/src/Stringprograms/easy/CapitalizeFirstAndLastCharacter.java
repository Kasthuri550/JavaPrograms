package Stringprograms.easy;

public class CapitalizeFirstAndLastCharacter {

	public static void main(String[] args) {
		
		String input = "hello world this is a test";
		
		String capitalizedString = capitalize1(input);
		
		System.out.println(capitalizedString);
	}

	private static String capitalize1(String input) {
		
		if(input == null || input.isEmpty())
		{
			return "";
		}
		
		String[] words = input.split("\\s+");
		
		StringBuilder result=new StringBuilder();
		
		for(String word:words)
		{
			if(word.length()>1)
			{
				char firstLetter=(char)(word.charAt(0)-32);
				String middleLetters=word.substring(1,word.length()-1);
				char lastLetter=(char)(word.charAt(word.length()-1));
				result.append(firstLetter).append(middleLetters).append(lastLetter);
			}
			else
			{
				result.append(word.toUpperCase());
			}
			
			result.append(" ");
		}
		
		return result.toString().trim();
	}
}
