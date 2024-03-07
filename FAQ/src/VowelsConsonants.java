
public class VowelsConsonants {

	public static void main(String[] args) {
		
		String str="Kasthuri";
		vowelsConson(str);

	}

	private static void vowelsConson(String str) {
		
		int vowel=0;
		int consonent=0;
		for(int i=0;i<str.length();i++)
		{
			if(isVowel(str.charAt(i)))
			{
				vowel++;
			}
			else
			{
				consonent++;
			}
			
		}
		
		System.out.println(vowel);
		System.out.println(consonent);
		
	}

	private static boolean isVowel(char c) {
		
		char ch=Character.toUpperCase(c);
		return (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U');
	}

}
