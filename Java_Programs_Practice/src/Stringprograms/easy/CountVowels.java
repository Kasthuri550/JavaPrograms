package Stringprograms.easy;

public class CountVowels {

	public static void main(String[] args) {
		
		String str="kasthuri KASTHURI";
		vowelCount1(str);
		vowelCount2(str);
		System.out.println(vowelCount3(str,str.length()));
	}

	private static int vowelCount3(String str,int n) {
		
		if(n==1)
				return isVowel(str.charAt(n-1));
		
		return vowelCount3(str,n-1)+isVowel(str.charAt(n-1));
		
	}

	private static int isVowel(char ch) {
		
		char c=Character.toUpperCase(ch);
		
		if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			return 1;
		else	
			return 0;
	}

	private static void vowelCount2(String str) {
		
		int count=0;
		
		for(int i=0;i<str.length();i++)
		{
			char ch=Character.toUpperCase(str.charAt(i));
			if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
			{
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	private static void vowelCount1(String str) {
		
		String newStr=str.replaceAll("[aeiouAEIOU]", "");
		System.out.println(newStr);
		
		System.out.println(str.length()-newStr.length());
	}
}
