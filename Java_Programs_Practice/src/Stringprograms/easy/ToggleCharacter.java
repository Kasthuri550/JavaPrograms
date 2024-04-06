package Stringprograms.easy;

import java.util.Arrays;

public class ToggleCharacter {

	public static void main(String[] args) {
		
		String str="kasthuri sathyamoorthy";
		
		String concat="";
				
		for(int i=0;i<str.length();i++)
		{
			if(i%2==0)
			{
				concat+=String.valueOf(str.charAt(i)).toUpperCase();
			}
			else
			{
				concat+=String.valueOf(str.charAt(i));
			}
		}
		
		System.out.println(concat);
	}
}
