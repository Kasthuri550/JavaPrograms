package Stringprograms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintAllPermutationsOfString {

	public static void main(String[] args) {
				
		String str="ABSG";
		
		List<List<String>> result=new ArrayList<>();
		List<String> ds=new ArrayList<String>();
		boolean frequency[]=new boolean[str.length()];
		
		permutation(str,result,ds,frequency);
		Collections.sort(result, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> list1, List<String> list2) {
				
				String str1 = String.join("", list1);
                String str2 = String.join("", list2);
                return str1.compareTo(str2);
			}
		});
		
		for(List<String> values:result)
		{
			System.out.println(values);
		}
	}

	private static void permutation(String str, List<List<String>> result, List<String> ds, boolean[] frequency) {
		
		if(ds.size()==str.length()) 
		{
			result.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i=0;i<str.length();i++)
		{
			if(!frequency[i])
			{
				frequency[i]=true;
				ds.add(String.valueOf(str.charAt(i)));
				permutation(str, result, ds, frequency);
				ds.remove(ds.size()-1);
				frequency[i]=false;
			}
		}
	}
}
