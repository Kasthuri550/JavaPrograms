package Stringprograms;

import java.util.Stack;

public class RemoveOuterMostParantheses {

	public static void main(String[] args) {
		
		String s="(()())(())";
//		System.out.println(removeOuterParentheses1(s));
//		System.out.println(removeOuterParentheses2(s));
		System.out.println(removeOuterParentheses3(s));
	}

	public static String removeOuterParentheses1(String s) {

		Stack<Character> bracket = new Stack<>();
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				if(bracket.size()>0){
					sb.append(s.charAt(i));
				}
				bracket.push(s.charAt(i));
			}else{
				bracket.pop();
				if(bracket.size()>0){
					sb.append(s.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	
	public static String removeOuterParentheses2(String S) {
//"(()())(())"
        StringBuilder sb = new StringBuilder();
        int open=0, close=0, start=0;
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '(') {
                open++;
            } else if(S.charAt(i) == ')') {
                close++;
            }
            if(open==close) {
                sb.append(S.substring(start+1, i));
                start=i+1;
            }
        }
        return sb.toString();       
    }
	
	public static String removeOuterParentheses3(String s) {

	       int count = 0;
	        StringBuilder result = new StringBuilder();

	        for (char c : s.toCharArray()) {
	            if (c == '(') {
	                if (count != 0) {
	                    result.append(c);
	                }
	                count++;
	            } else {
	                if (count != 1) {
	                    result.append(c);
	                }
	                count--;
	            }
	        }

	        return result.toString();
	    }

}
