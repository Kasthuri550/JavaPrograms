package Stringprograms.medium;

import java.util.Arrays;

public class ArrangeWordsByLength {

	public static void main(String[] args) {
		
		String sentence="I am a good girl ";
		
		arrangeWords(sentence);

	}

	private static void arrangeWords(String sentence) {
		
		String[] words=sentence.split(" ");
		
		Arrays.sort(words,(s1,s2)->s1.length()!=s2.length()?Integer.compare(s1.length(),s2.length()):0);
		
		System.out.println(Arrays.toString(words));
		
	}
}
