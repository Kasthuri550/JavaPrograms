package Stringprograms.medium;

public class CountNumberSubstrings {

	public static void main(String[] args) {
		
		String S = "aba";
		int K = 2;
		
		long a=countSubstrings(S,K);
		long b=countSubstrings(S, K-1);
		
		System.out.println(a-b);

	}

	private static long countSubstrings(String s, int k) {
		
		int n=s.length(),i=0,j=0,size=0,result=0;
		
		int map[]=new int[26];
		
		while(j<n)
		{
			char c=s.charAt(j);
			
			if(map[c-'a']==0) size++;
			
			map[c-'a']++;
			
			while(size>k)
			{
				char ch=s.charAt(i);
				map[ch-'a']--;
				if(map[ch-'a']==0) size--;
				i++;
			}
			
			result+=j-i+1;
			j++;
		}
		
		return result;
	}

}
