package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PrintAllPermutationsOfStringOrArrayApproach2 {

	public static void main(String[] args) {

		String S="ABC";
		 ArrayList<String> result=new ArrayList<>();
	        char c[]=S.toCharArray();
	        
	        recurPermutate(0,c,result);
	        
	        Collections.sort(result);
	        
	        System.out.println(result);

	}

	private static void recurPermutate(int index, char[] chars, ArrayList<String> result) {

		int n=chars.length;
		if(index==n)
		{
			String concat = new String(chars);
			result.add(concat);
			return;
		}

		Set<Character> swapped = new HashSet<>();
		for(int i=index;i<n;i++)
		{
			if (swapped.add(chars[i])) {
				swap(i,index,chars);
				recurPermutate(index+1,chars,result);
				swap(i,index,chars);
			}
		}
	}

	public static void swap(int x,int y,char[] chars)
	{
		char temp=chars[x];
		chars[x]=chars[y];
		chars[y]=temp;
	}
}
