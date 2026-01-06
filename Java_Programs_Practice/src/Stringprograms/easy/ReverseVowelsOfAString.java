package Stringprograms.easy;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "practice";
		
		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s)
	{
		int left=0,right=s.length()-1;
		
		char c[]=s.toCharArray();
		
		while(left<right)
		{
			while(left<right && !isVowels(c[left]))
			{
				left++;
			}
			
			while(left<right && !isVowels(c[right]))
			{
				right--;
			}
			
			char temp=c[left];
			c[left]=c[right];
			c[right]=temp;
			left++;
			right--;
		}
		
		return new String(c);
	}
	
	private static boolean isVowels(char c) {

		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
	}
}
