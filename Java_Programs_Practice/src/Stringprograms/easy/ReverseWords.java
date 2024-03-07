package Stringprograms.easy;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		
		String S = "i.like.this.program.very.much";
		
		reverseWords(S);
	}

	private static void reverseWords(String s) {
		
		String[] st = s.split("[.]");
		String str="";
		
		int n = st.length;
		for(int i=n-1;i>=0;i--)
		{
			if(i==0)
			{
				str+=st[i];
			}
			else
			{
			str+=st[i]+".";
			}
		}
		
		System.out.println(str);
	}
}
