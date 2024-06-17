package Stringprograms.medium;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsString {

	public static void main(String[] args) {
		
		String s = "  hello world  ";
		
		reverseWordsI(s);
		reverseWordsII(s);

	}

	private static void reverseWordsII(String s) {
		
		int n=s.length();
		String name[]= {"kasthuri","Abby"};
		
		String words[]=s.trim().split("\\s+");
		
		Collections.reverse(Arrays.asList(words));
		
		String joinString = String.join(" ",words);
		System.out.println(joinString);
		
		System.out.println(String.join("-", name));
	}

	private static void reverseWordsI(String s) {
		
		int n=s.length();
		
		String words[]=s.trim().split("\\s+");
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=words.length-1;i>=0;i--)
		{
			sb.append(words[i]);
			
			if(i!=0)
			{
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
