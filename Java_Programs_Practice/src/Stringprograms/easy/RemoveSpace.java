package Stringprograms.easy;

public class RemoveSpace {

	public static void main(String[] args) {
		
		String s ="    geeks  for geeks";
		
		remove1(s);
		remove2(s);
	}

	private static void remove2(String s) {
		
		
		String removeSpace = s.replaceAll("[\\s+]", "");
		
		System.out.println(removeSpace);
	}

	private static void remove1(String s) {
		
		StringBuilder result=new StringBuilder();
		
		String[] splitStr = s.split("\\s");
		
		
		for(String str:splitStr)
		{
			result.append(str);
		}
		System.out.println(result.toString());
	}

}
