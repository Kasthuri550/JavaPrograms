package Stringprograms;

import java.util.Map;
import java.util.TreeMap;

public class wordCount {

	public static void main(String[] args) {
		
		String str="Learn with Arun";
		
		wcount(str);
		frequency(str);
	}

	private static void frequency(String str) {
		
		int n=str.length();
		Map<Character,Integer> map=new TreeMap<Character, Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)!=' ')
			{
				map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
			}
		}
		
		for(Map.Entry<Character,Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}

	private static void wcount(String str) {
		
		int n=str.length(),wordcount=0,vowelcount=0,uppercount=0;
		
		for(int i=0;i<n;i++)
		{
			char ch=str.charAt(i);
			if(ch==' '||ch=='.')
			{
				wordcount++;
			}
			
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
			{
				vowelcount++;
			}
			
			if(ch>=65 && ch<=90)
			{
				uppercount++;
			}
		}
		System.out.println("Words "+(wordcount+1));
		System.out.println("Vowels "+vowelcount);
		System.out.println("Uppercase "+uppercount);
		
	}

}
