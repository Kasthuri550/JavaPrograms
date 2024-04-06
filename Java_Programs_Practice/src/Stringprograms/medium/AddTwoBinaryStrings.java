package Stringprograms.medium;

public class AddTwoBinaryStrings {

	public static void main(String[] args) {
		
		String str1="1101";
		String str2="111";
		
		String str3=add(str1,str2);
		System.out.println(str3);
	}

	private static String add(String str1, String str2) {
		
		int i=str1.length()-1,j=str2.length()-1;
		char carry='0';
		
		StringBuilder sb=new StringBuilder();
		
		while(i>=0 || j>=0)
		{
			char tempA=(i>=0)?str1.charAt(i):'0';
			char tempB=(j>=0)?str2.charAt(j):'0';
			
			if(tempA==tempB)
			{
				if(carry=='0')
				{
					sb.insert(0,'0');
				}
				else
				{
					sb.insert(0,'1');
				}
				carry=tempA;
			}
			else if(tempA!=tempB)
			{
				if(carry=='0')
				{
					sb.insert(0,'1');
				}
				else
				{
					sb.insert(0,'0');
					carry='1';
				}
			}
			i--;
			j--;
		}
		
		if(carry=='1')
		{
			sb.insert(0,'1');
		}
		
//		sb.reverse();
		while(1<sb.length() && sb.charAt(0)=='0')
		{
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}

}
