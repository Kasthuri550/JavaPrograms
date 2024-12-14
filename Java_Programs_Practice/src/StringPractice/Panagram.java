package StringPractice;

public class Panagram {

	public static void main(String[] args) {
		
		String str="The quick brown fox jumps over the lazy dog12345 89989";
		
		System.out.println(isPanagram1(str.toLowerCase()));
		System.out.println(isPanagram2(str));

	}

	private static boolean isPanagram2(String str) {
		
		int n=str.length();
		int count[]=new int[26];
		
		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)>='a' && str.charAt(i)<='z')
			{
				count[str.charAt(i)-'a']++;
			}
			else if(str.charAt(i)>='A' && str.charAt(i)<='Z')
			{
				count[str.charAt(i)-'A']++;
			}
		}
		
		for(int i=0;i<26;i++)
		{
			if(count[i]==0)
				return false;
		}
		return true;
	}

	private static boolean isPanagram1(String str) {
		
		int n=str.length();
		
		if(str.length()<26)
		{
			return false;
		}
		else
		{
			for(char ch='a';ch<='z';ch++)
			{
				if(str.indexOf(ch)<0)
				{
					return false;
				}
			}
		}
		return true;
	}
}
