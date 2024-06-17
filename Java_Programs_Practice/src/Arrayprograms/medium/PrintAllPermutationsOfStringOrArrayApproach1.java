package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintAllPermutationsOfStringOrArrayApproach1 {

	public static void main(String[] args) {
		
		String str="ABC";
		char chars[]=str.toCharArray();
		ArrayList<ArrayList<String>> resultList=new ArrayList<>();
		ArrayList<String> ds=new ArrayList<String>();
		boolean frequency[]=new boolean[chars.length];
		
		recurPermutate(chars,ds,resultList,frequency);
		
		 Collections.sort(resultList,new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
				for(int i=0;i<Math.min(arg0.size(), arg1.size());i++)
				{
					int compare=arg0.get(i).compareTo(arg1.get(i));
					if(compare!=0)
					{
						return compare;
					}
				}
				return Integer.compare(arg0.size(), arg1.size());
			}
		});
		System.out.println(resultList);

	}

	private static void recurPermutate(char[] chars, ArrayList<String> ds, ArrayList<ArrayList<String>> resultList,
			boolean[] frequency) {
		
		int n=chars.length;
		
		if(ds.size()==n)
		{
			resultList.add(new ArrayList<String>(ds));
			return;
		}
		for(int i=0;i<n;i++)
		{
			if(!frequency[i])
			{
				frequency[i]=true;
				ds.add(chars[i]+"");
				recurPermutate(chars, ds, resultList, frequency);
				ds.remove(ds.size()-1);
				frequency[i]=false;				
			}
		}
		
	}
}
