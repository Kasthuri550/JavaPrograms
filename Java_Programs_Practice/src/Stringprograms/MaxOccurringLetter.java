package Stringprograms;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class MaxOccurringLetter {

	public static void main(String[] args) {

		String str = "hello world";

		char character=getMaxOccurringLetter(str);
		System.out.println(character);
	}

	private static char getMaxOccurringLetter(String str) {

		int freq[]=new int[26];

		for(char c:str.toCharArray())
		{
			if(c>='a' && c<='z')
				freq[c-'a']++;
		}

		int max=0,index=0;

		for(int i=0;i<26;i++)
		{
			if(freq[i]>max)
			{
				max=freq[i];
				index=i;
			}
		}

		return (char)(index+'a');
	}
}
