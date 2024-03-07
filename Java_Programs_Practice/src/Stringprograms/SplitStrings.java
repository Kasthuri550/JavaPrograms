package Stringprograms;

import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitStrings {

	public static void main(String[] args) {
		
		String str="91-9344136334";
		String[] splitString1 = str.split("-");
		printString(splitString1,"-----Split method------");
		List<String> listString=Pattern.compile("-").splitAsStream(str).collect(Collectors.toList());
		System.out.println("-----Pattern class--------");
		for(String s:listString)
		{
			System.out.println(s);
		}
		
		StringTokenizer stringTokenizer=new StringTokenizer(str,"-");
		System.out.println("-----StringTokenizer--------");
		while(stringTokenizer.hasMoreTokens())
		{
			System.out.println(stringTokenizer.nextToken());
		}
		
//		String splitString2[]=StringUtils.split(str,"-");
//		printString(splitString2,"--------stringutils class-----");
//		
//		Iterable<String> splitString3=Splitter.on(str).split("-");
//		printString(splitString3, "------guava------");
		
	}

	private static void printString(String[] splitString1,String approach) {
		
		System.out.println(approach);
		for(String s:splitString1) {
			
			System.out.println(s);
			
		}
		
	}

}
