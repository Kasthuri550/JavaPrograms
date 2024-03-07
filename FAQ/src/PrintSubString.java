
public class PrintSubString {

	public static void main(String[] args) {
		
		String str = "abcd";
		
//		approach1(str);
		approach2(str);

	}

	private static void approach2(String str) {
		
		for(int i=0;i<str.length();i++)
		{
			String subString="";
			for(int j=i;j<str.length();j++)
			{
				subString+=str.charAt(j);
				System.out.println(subString);
			}
		}
		
	}

	private static void approach1(String str) {
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
			{
				System.out.println(str.substring(i,j));
			}
		}
		
	}

}
