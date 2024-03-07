package Stringprograms;

public class RemoveCharacter {

	public static void main(String[] args) {
		
		String str="abcdefghijklmnopqrstuvwxyz";
		String temp=str;
		
		char[] charArray = str.toCharArray();
		
//		String replace = str.replace(String.valueOf(str.charAt(0)),"");
//		System.out.println(replace);
		
		System.out.println("Original string "+str);
		for(int i=2;i<charArray.length;i+=3)
		{
			temp=temp.replace(String.valueOf(charArray[i]),"");
		}
		
		System.out.println("Modified string "+temp);
	}
}
