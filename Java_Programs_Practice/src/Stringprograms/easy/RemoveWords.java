package Stringprograms.easy;

public class RemoveWords {

	public static void main(String[] args) {
		
		 String str = "This is the prepinsta";
	     String word = "the";
	     
	     removeWords1(str,word);
	     removeWords2(str,word);
	}

	private static void removeWords1(String str, String word) {
		
		System.out.println(str.replaceAll(word, ""));
		
	}

	private static void removeWords2(String str, String word) {
		
		String[] splitWords = str.split(" ");
		
		StringBuilder sb=new StringBuilder();
		
		for(String words:splitWords)
		{
			if(!words.equals(word))
			{
				sb.append(words);
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
