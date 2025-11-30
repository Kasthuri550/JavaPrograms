package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringPractice {

	public static void main(String[] args) {
		
		String s = "ADOBECODEBANC", t = "ABC";
		
		System.out.println(minimumWindowSubstringBrute(s,t));
		System.out.println(minimumWindowSubstringOptimal(s, t));
	}
	
	private static String minimumWindowSubstringOptimal(String s, String t) {

		int n=s.length(),m=t.length();
		
		if(n<m)
			return "";
		
		int left=0,right=0,minLen=Integer.MAX_VALUE,sIndex=-1,required=0;
		
		Map<Character,Integer> freqMap=new HashMap<>();
		
		for(int i=0;i<m;i++)
		{
			char tChar=t.charAt(i);
			freqMap.put(tChar,freqMap.getOrDefault(tChar,0)+1);
		}
		
		while(right<n)
		{
			char rightChar=s.charAt(right);
			if(freqMap.containsKey(rightChar))
			{
				if(freqMap.get(rightChar)>0)
				{
					required++;
				}
				freqMap.put(rightChar,freqMap.getOrDefault(rightChar,0)-1);
			}
			
			while(required==m)
			{
				int windowLength=right-left+1;
				
				if(windowLength<minLen)
				{
					minLen=windowLength;
					sIndex=left;
				}
				
				char leftChar=s.charAt(left);
				if(freqMap.containsKey(leftChar))
				{
					freqMap.put(leftChar,freqMap.getOrDefault(leftChar,0)+1);
					if(freqMap.get(leftChar)>0)
					{
						required--;
					}
				}
				
				left++;
			}
			right++;
		}
		
		return sIndex==-1?"":s.substring(sIndex,sIndex+minLen);
	}

	private static String minimumWindowSubstringBrute(String s,String t)
	{
		int n=s.length(),m=t.length();
		
		if(n<m)
			return "";
		
		int sIndex=-1,minLen=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
			Map<Character,Integer> freqMap=new HashMap<>();
			
			for(int j=0;j<m;j++)
			{
				char tChar=t.charAt(j);
				freqMap.put(tChar,freqMap.getOrDefault(tChar,0)+1);
			}
			
			int required=0;
			
			for(int j=i;j<n;j++)
			{
				char sChar=s.charAt(j);
				if(freqMap.containsKey(sChar) && freqMap.get(sChar)>0)
				{
					freqMap.put(sChar,freqMap.getOrDefault(sChar,0)-1);
					required++;
				}
				
				if(required==m)
				{
					int windowLength=j-i+1;
					
					if(windowLength<minLen)
					{
						minLen=windowLength;
						sIndex=i;
					}
					
					break;
				}
			}
		}
		
		return sIndex==-1?"":s.substring(sIndex,sIndex+minLen);
	}
}
