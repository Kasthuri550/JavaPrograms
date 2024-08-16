package Arrayprograms.medium;

import java.util.HashMap;
import java.util.HashSet;

public class CountSubstringsWithKDistinctChars {

	public static void main(String[] args) {
		
		String s = "pqpqs";
		int k=2;
		
//		countSusbtringBrute(s,k);
//		countSubstringBetter(s, k);
		countSubstringOptimal(s, k);
	}

	private static void countSubstringOptimal(String s, int k) {
		
		int n = s.length();
        int count = 0;
        int left = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            count += right - left + 1;
        }

      System.out.println(count);
		
	}

	private static void countSubstringBetter(String s, int k) {
		
		int n=s.length(),count=0;
		
		for(int i=0;i<n;i++)
		{
			HashMap<Character,Integer> hashMap=new HashMap<>();
			for(int j=i;j<n;j++)
			{
				hashMap.put(s.charAt(j),hashMap.getOrDefault(s.charAt(j),0)+1);
				
				if(hashMap.size()==k)
				{
					count++;
				}
				else if(hashMap.size()>k)
				{
					break;
				}
			}
		}
		
		System.out.println(count);
		
	}

	private static void countSusbtringBrute(String s, int k) {
		
		int n=s.length(), count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				String substr=s.substring(i,j+1);
				
				if(countSubstringChar(substr,k))
				{
					count++;
				}
			}
		}
		System.out.println(count);
		
	}

	private static boolean countSubstringChar(String substr, int k) {
		
		HashSet<Character> hashSet=new HashSet<Character>();
		
		for(char c:substr.toCharArray())
		{
			hashSet.add(c);
		}
		return hashSet.size()==k;
	}
}
