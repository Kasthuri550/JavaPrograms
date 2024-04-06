package Stringprograms.easy;

public class RemoveBracketsAlgebraic {

	public static void main(String[] args) {
		
		String s = "(a+b)=c";
		
		removeBrackets1(s);
		removeBrackets2(s);

	}

	private static void removeBrackets2(String s) {
		
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) != '(' && s.charAt(i) != '[' && s.charAt(i) != ']' &&
		        s.charAt(i) != ')' && s.charAt(i) != '{' && s.charAt(i) != '}') {
		        result.append(s.charAt(i));
		    }
		}

		System.out.println(result.toString());

		
	}

	private static void removeBrackets1(String s) {
		String removeBrackets = s.replaceAll("[(){}]", "");
		
		System.out.println(removeBrackets);
	}

}
