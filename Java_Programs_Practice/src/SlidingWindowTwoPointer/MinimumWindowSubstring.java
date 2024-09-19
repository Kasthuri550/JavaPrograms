package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC", t = "ABC";

		System.out.println(minimumWindowSubstringApproach0(s,t));
//		System.out.println(minimumWindowSubstringApproach1(s,t));
//		System.out.println(minimumWindowSubstringApproach2(s, t));

	}

	private static String minimumWindowSubstringApproach0(String s, String t) {

		int minLength=Integer.MAX_VALUE,n=s.length();
		String minWindow="";
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				String subStr=s.substring(i,j+1);
				if(containsAll(subStr,t))
				{
					if(subStr.length()<minLength)
					{
						minLength=subStr.length();
						minWindow=subStr;
					}
				}
			}
		}
		return minWindow;
	}

	private static boolean containsAll(String s, String t) {

		Map<Character, Integer> map=new HashMap<Character, Integer>();
		
		for(char c:t.toCharArray())
		{
			map.put(c,map.getOrDefault(c,0)+1);
		}
		
		for(char c:s.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c,map.get(c)-1);
				if(map.get(c)==0)
				{
					map.remove(c);
				}
			}
		}
		
		return map.isEmpty();
	}

	private static String minimumWindowSubstringApproach2(String s, String t) {

		int n=s.length(),m=t.length(),right=0,left=0,matched=0,minLength=Integer.MAX_VALUE,start=0;

		Map<Character,Integer> mapT=new HashMap<Character, Integer>();

		for(int i=0;i<m;i++)
		{
			mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
		}

		Map<Character,Integer> window=new HashMap<Character, Integer>();

		while(right<n)
		{
			char c=s.charAt(right);
			window.put(c,window.getOrDefault(c,0)+1);

			if(mapT.containsKey(c) && mapT.get(c).intValue()==window.get(c).intValue())
			{
				matched++;
			}

			while(matched==mapT.size())
			{
				if(right-left+1<minLength)
				{
					minLength=right-left+1;
					start=left;
				}

				char leftChar=s.charAt(left);
				window.put(leftChar,window.get(leftChar)-1);
				if(mapT.containsKey(leftChar) && window.get(leftChar)<mapT.get(leftChar))
				{
					matched--;
				}
				left++;
			}
			right++;
		}
		
	return minLength==Integer.MAX_VALUE?"":s.substring(start,start+minLength);
}

private static String minimumWindowSubstringApproach1(String s, String t) {

	if(s.length()==0 || t.length()==0) return "";

	int left=0,right=0,start=0,count=0;
	int minLength=Integer.MAX_VALUE,tLength=t.length();

	Map<Character,Integer> map=new HashMap<Character,Integer>();

	for(int i=0;i<tLength;i++)
	{
		map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
	}

	while(right<s.length())
	{
		char c=s.charAt(right);
		if(map.containsKey(c))
		{				
			map.put(c,map.get(c)-1);
			if(map.get(c)>=0)
			{
				count++;
			}
		}
		while(count==tLength)
		{
			if(right-left+1<minLength)
			{
				minLength=right-left+1;
				start=left;
			}

			char temp=s.charAt(left);
			if(map.containsKey(temp))
			{
				map.put(temp,map.get(temp)+1);
				if(map.get(temp)>0)
				{
					count--;
				}
			}
			left++;
		}
		right++;
	}

	return minLength==Integer.MAX_VALUE?"":s.substring(start,start+minLength);
}
}
