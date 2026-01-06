import java.util.regex.Pattern;

public class ReverseWords {

	public static void main(String[] args) {
		
		String s1 = "Welcome to geeksforgeeks";
		
		reverse(s1);

	}

	private static void reverse(String s1) {
		
		Pattern pattern=Pattern.compile("\\s");
		System.out.println(pattern);
		
		String[] temp = pattern.split(s1);
		String result="";
		
		for(int i=temp.length-1;i>=0;i--)
		{
			result=result+temp[i]+" ";
		}
		
		System.out.println(result);
		
	}

}
