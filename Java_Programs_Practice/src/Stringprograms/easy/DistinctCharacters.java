package Stringprograms.easy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctCharacters {

	public static void main(String[] args) {
		
		String str = "kasthuri sathyamoorthy";
        String distinctChars = getDistinctCharacters(str);
        System.out.println(distinctChars);
	}
	
	public static String getDistinctCharacters(String str) {
        String distinctChars = str.chars()
                                .mapToObj(c -> (char) c)
                                .filter(Character::isLetter)
                                .map(Character::toLowerCase)
                                .distinct()
                                .map(Object::toString)
                                .collect(Collectors.joining());
        
        return distinctChars;
    }
}
