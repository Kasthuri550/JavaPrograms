package Stringprograms;

public class NonRepeatingCharacter {

	public static void main(String[] args) {
		
		String s="madam";
		
		System.out.println(nonrepeat1(s));
		System.out.println(nonrepeat2(s));

	}

	private static char nonrepeat2(String s) {
		
		for(int i=0;i<s.length();i++)
		{
			if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))
			{
				return s.charAt(i);
			}
		}
		return '$';
	}

	private static char nonrepeat1(String s) {
		
		int charFrequency[]=new int[256];
		
		for(int i=0;i<s.length();i++)
		{
			charFrequency[s.charAt(i)]++;
		}
		
		for(int j=0;j<s.length();j++)
		{
			if(charFrequency[s.charAt(j)]==1)
			{
				return s.charAt(j);
			}
		}
		
		return '$';
	}

}
