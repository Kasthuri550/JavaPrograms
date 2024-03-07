package Stringprograms;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

	public static void main(String[] args) {
		
		String s="  hello world  ";
		String reverseWords = reverseWords(s);
		System.out.println(reverseWords);

	}
	
	public static String reverseWords(String s) {

        String str[]=s.trim().split("\\s+");

        Collections.reverse(Arrays.asList(str));

        return String.join(" ",str);
        
    }

}
