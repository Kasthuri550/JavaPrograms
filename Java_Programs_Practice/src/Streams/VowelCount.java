package Streams;

public class VowelCount {

	public static void main(String[] args) {
		
		String str="kasthuri sathyamoorthy";
		
		long count = str.chars().filter(c -> c=='a'||c=='e'||c=='i'||c=='o'||c=='u').count();
		System.out.println(count);
	}

}
