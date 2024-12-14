package Basicmaths;

public class RemoveSpaces {

	public static void main(String[] args) {
		
		String s = "Prepinsta     is best";
		
		System.out.println(s.replaceAll("\\s+",""));
		System.out.println(s.replaceAll("[\\s]",""));
		System.out.println("kasthuri$arun$kumar".replaceAll("[$]",""));
	}
}
