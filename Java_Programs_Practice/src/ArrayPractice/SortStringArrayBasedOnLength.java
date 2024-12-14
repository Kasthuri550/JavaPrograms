package ArrayPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortStringArrayBasedOnLength {

	public static void main(String[] args) {
		
		String strs[]= {"pineapple","apple","orange","banana","guava"};
		
		Map<String,Integer> map=new HashMap<>();
		
		for(String str:strs)
		{
			map.put(str,str.length());
		}
		
//		Arrays.sort(strs,(s1,s2)->map.get(s1)-map.get(s2));
		
		Arrays.sort(strs,(s1,s2)->s2.length()-s1.length());
		
		System.out.println(Arrays.toString(strs));

	}
}
