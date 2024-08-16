package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {

	public static void main(String[] args) {
		
		int n=3;
		
		List<String> resultList=new ArrayList<>();
		
		generateBinaryStrings(n,"",0,resultList);
		
		System.out.println(resultList);

	}

	private static void generateBinaryStrings(int n, String string, int i, List<String> resultList) {
		
		
		if(i==n)
		{
			resultList.add(string);
			return;
		}
		
		if(i!=0 && string.charAt(i-1)=='1')
		{
			generateBinaryStrings(n, string+'0', i+1, resultList);
		}
		else
		{
			generateBinaryStrings(n,string+'0', i+1, resultList);
			generateBinaryStrings(n, string+'1', i+1, resultList);
		}
	}
}
