package Stringprograms.easy;

public class AlphabetOrNot {

	public static void main(String[] args) {
		
		char c='9';
		
		if((c>='A' && c<='Z')||(c>='a' && c<='z'))
		{
			System.out.println("Alphabet");
		}
		else
		{
			System.out.println("Not Alphabet");
		}
		
		if((c>=65 && c<=90 )||(c>=97 && c<=122))
		{
			System.out.println("Alphabet");
		}
		else
		{
			System.out.println("Not Alphabet");
		}

	}
}
