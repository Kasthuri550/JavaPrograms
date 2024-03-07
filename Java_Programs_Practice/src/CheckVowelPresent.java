
public class CheckVowelPresent {

	public static void main(String[] args) {
		
		System.out.println(vowelPresent("Hello"));
		System.out.println(vowelPresent("TV"));
	}
	
	public static boolean vowelPresent(String str)
	{
		return str.toLowerCase().matches(".*[aeiou].*");
	}

}
