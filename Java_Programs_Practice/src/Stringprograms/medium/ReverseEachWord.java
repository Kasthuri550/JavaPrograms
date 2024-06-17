package Stringprograms.medium;

public class ReverseEachWord {

	public static void main(String[] args) {
		
		String str="Java Programming";
		
		reverseEachWord(str);

	}

	private static void reverseEachWord(String str) {
		
		int n=str.length();
		
		String words[]=str.split(" ");
		
		StringBuilder sb=new StringBuilder();
		
		for(String word:words)
		{
			String reverseWord=reverse(word);
			sb.append(reverseWord).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}

	private static String reverse(String word) {
		
		String rev="";
		
		for(int i=word.length()-1;i>=0;i--)
		{
			rev=rev+word.charAt(i);
		}
		
		return rev;
	}
}
