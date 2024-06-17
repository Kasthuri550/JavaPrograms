package Stringprograms;

public class VowelPresentOrNot {

	public static void main(String[] args) {
		
		System.out.println(isVowel("Hello world"));
		System.out.println(isVowel("TV"));

	}

	private static boolean isVowel(String string) {
		return string.toLowerCase().matches(".*[aeiou].*");
	}

}
