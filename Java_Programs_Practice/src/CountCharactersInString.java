import java.util.HashMap;
import java.util.Scanner;

public class CountCharactersInString {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			String str = scanner.nextLine();

//			approach1(str);
//			approach2(str);
		}

	}

	
	private static void approach2(String str) {

		str=str.replace(" ","");
		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (hashMap.containsKey(str.charAt(i)))
				hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
			else
				hashMap.put(str.charAt(i), 1);
		}
		
		System.out.println(hashMap);

	}

	private static void approach1(String str) {

		int count;

		str = str.replace(" ", "");
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					count++;
			}
			System.out.println(str.charAt(i) + " = " + count);
		}

	}

}
