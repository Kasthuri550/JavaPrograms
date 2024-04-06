package Stringprograms.easy;

public class DetectCapitals {

	public static void main(String[] args) {
		
		String word = "FlaG";
		
		System.out.println(detectCaps(word));
		
	}

	private static boolean detectCaps(String word) {
		
		int countUpperCase=0,countLowerCase=0;
		
		for(int i=0;i<word.length();i++)
		{
			char ch=word.charAt(i);
			
			if(ch>='A' && ch<='Z')
			{
				countUpperCase++;
			}
			else
			{
				countLowerCase++;
			}
		}
		
		return (countLowerCase==word.length()||
				countUpperCase==word.length()||
				Character.isUpperCase(word.charAt(0)) && countLowerCase==word.length()-1);	
	}
}
