import java.util.Arrays;

public class SortCharacters {
	
	private static final int MAX_CHAR=26;

	public static void main(String[] args) {
		
		String s = "geeksforgeeks";
		
//		sortString1(s);
//		sortString2(s);
		sortString3(s);

	}

	private static void sortString3(String s) {
		
		char c[]=s.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			for(int j=i+1;j<c.length;j++)
			{
				if(c[i]>c[j])
				{
					char temp=c[i];
					c[i]=c[j];
					c[j]=temp;
				}
			}
		}
		
		for(char ch:c)
		{
			System.out.println(ch);
		}
		
	}

	private static void sortString2(String s) {
		
		char character[]=s.toCharArray();
		
		Arrays.parallelSort(character);
		
		for(int chars:character)
		{
			System.out.println((char)chars);
		}
		
	}

	private static void sortString1(String s) {
		
		char[] c=s.toCharArray();
		int[] count=new int[MAX_CHAR];
		for(char ch:c)
		{
			count[ch-'a']++;
		}
		
		for(int i=0;i<MAX_CHAR;i++)
		{
			for(int j=0;j<count[i];j++)
			{
				System.out.print((char)(i+'a'));
			}
		}
		
	}

}
