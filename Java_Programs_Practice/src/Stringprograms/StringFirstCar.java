package Stringprograms;

import java.util.Arrays;

public class StringFirstCar {

	public static void main(String[] args) {

		String strings[]= {"Kasthuri","Abby","Arun","Sam","Kavya","K"};
		
		String str="Kasthuri$Abby$Arun";
		String[] split = str.split("[$]");
		System.out.println(Arrays.toString(split));

//		for(String str:strings)
//		{
//			if(startsWith(str))
//			{
//				System.out.println(str);
//			}
//		}
		String str1="hdsghs352hjh";
		String replaceAll = str1.replaceAll("[^0-9]", "");
		System.out.println(replaceAll);

	}

	private static boolean startsWith(String str) {

		if(str.length()<2)
		{
			return false;
		}
		
		
		return str.charAt(0)=='K' && str.charAt(1)=='a';	
	}
}
