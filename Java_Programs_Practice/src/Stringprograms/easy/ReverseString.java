package Stringprograms.easy;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

	public static void main(String[] args) {
		
		String str="todo auto-generated method stub";
		
//		reverse1(str);
//		reverse2(str);
//		System.out.println(reverse3(str));
//		reverse4(str);
//		reverse5(str);
//		reverse6(str);
		reverse7(str);

	}

	private static void reverse7(String str) {
		
		String reversedString = str.chars().mapToObj(c -> (char)c)
		.collect(Collectors.collectingAndThen(Collectors.toList(),list -> {
			Collections.reverse(list);
			return list.stream()
					.collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
			}
		)).toString();
		
		System.out.println(reversedString);
		
	}

	private static void reverse6(String str) {
		
		String reversedString = Stream.of(str)
		.map(words -> new StringBuilder(words).reverse())
		.collect(Collectors.joining());
		
		System.out.println(reversedString);
		
	}

	private static void reverse5(String str) {
		
		StringBuilder sb=new StringBuilder(str);
		sb.reverse();
		
		System.out.println(sb.toString());
	}

	private static void reverse4(String str) {
		
		String reversedString = str.chars()
		.mapToObj(c -> (char)c)
		.reduce("",(a,b)-> (String)(b+a),(a,b)->(String)(b+a));
		
		System.out.println(reversedString);
		
	}

	private static String reverse3(String str) {
		
		if(str.isEmpty())
		{
			return str;
		}
		
		return reverse3(str.substring(1))+str.charAt(0);		
	}

	private static void reverse2(String str) {
		
		char[] charArray=str.toCharArray();
		int n=str.length();
		
		
		for(int i=0;i<n/2;i++)
		{
			char ch=charArray[i];
			charArray[i]=charArray[n-i-1];
			charArray[n-i-1]=ch;
		}
		
		System.out.println(charArray);
		
	}

	private static void reverse1(String str) {
		
		String reverse="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			reverse+=str.charAt(i);
		}
		
		System.out.println(reverse);
		
	}
}
