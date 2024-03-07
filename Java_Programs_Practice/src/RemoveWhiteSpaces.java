
public class RemoveWhiteSpaces {

	public static void main(String[] args) {

		System.out.println(removewhiteSpace("abj  jjsd     353"));
	}

	public static String removewhiteSpace(String str)
	{
		StringBuilder sb=new StringBuilder();
		char[] c=str.toCharArray();
		for(char ch:c)
		{
			if(!Character.isWhitespace(ch))
			{
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}

}
