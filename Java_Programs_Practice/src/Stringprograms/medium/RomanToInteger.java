package Stringprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		
		String s = "MCMXCIV";
		
		romanToIntegerNum(s);
	}

	private static void romanToIntegerNum(String s) {
		
		int n=s.length();
		
		Map<Character,Integer> map= new HashMap<>();
		map.put('I', 1);
		map.put('V',5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		
		int result=map.get(s.charAt(s.length()-1));
		
		for(int i=n-2;i>=0;i--)
		{
			if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
			{
				result-=map.get(s.charAt(i));
			}
			else
			{
				result+=map.get(s.charAt(i));
			}
		}
		
		System.out.println(result);
	}
}
