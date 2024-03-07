package Arrayprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagrams {

	public static void main(String[] args) {
		
		String arr[] = {"geeksquiz", "geeksforgeeks", "abcd", "forgeeksgeeks", "zuiqkeegs", "cat", "act", "tca"};
        System.out.println(anagrams(arr));
	}

	private static List<List<String>> anagrams(String[] arr) {
		
		int n=arr.length;		
		Map<String,List<String>> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			String str=arr[i];
			char ch[]=str.toCharArray();
			Arrays.sort(ch);
			String s=String.valueOf(ch);
			if(map.containsKey(s))
			{
				map.get(s).add(str);
			}
			else
			{
				List<String> list=new ArrayList<>();
				list.add(arr[i]);
				map.put(s,list);
			}
		}
		
		List<List<String>> listString=new ArrayList<List<String>>();
		for(List<String> ml:map.values())
		{
			listString.add(ml);
		}
		
		return listString;
	}

}
