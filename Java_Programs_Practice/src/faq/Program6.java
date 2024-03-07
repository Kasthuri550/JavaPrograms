package faq;

public class Program6 {

	public static void main(String[] args) {
		
		String str="CloudTech";
		
		System.out.println(str.replace("c", "").replace("C", ""));
		
		removeCharacter(str,'c');
	}

	private static void removeCharacter(String str, char c) {
		
		String finalStr="";
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(c!=ch && c!=Character.toLowerCase(ch))
			{
				finalStr+=ch;
			}
		}
		
		System.out.println(finalStr);
		
	}

}
