package Stringprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllSubsequenceInString {

	public static void main(String[] args) {
		
		String str = "abc";
		System.out.println(AllPossibleStrings(str));
	}
	
	public static List<String> AllPossibleStrings(String s)
    {
        List<String> result = new ArrayList<>();
        generateSubsequences("", s, result);
        Collections.sort(result);
        return result;
    }
    
     private static void generateSubsequences(String current, String remaining, List<String> result) {
        if (remaining.length() == 0) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        generateSubsequences(current + remaining.charAt(0), remaining.substring(1), result);

        generateSubsequences(current, remaining.substring(1), result);
    }

}
