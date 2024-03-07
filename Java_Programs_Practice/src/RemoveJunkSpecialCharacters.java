
public class RemoveJunkSpecialCharacters {

	public static void main(String[] args) {
		
		String str1="##%#%@%#%#%#% jskjjsjhfGSGDGD FRR";
		str1=str1.replaceAll("[^a-zA-Z0-9]","");
		System.out.println(str1);
		
		String str2="jgsjjsh  HJJHJKJ";
		str2=str2.replaceAll("([a-z])","");
		System.out.println(str2);
		
		String str3="jksjs jksdgjk    jfks";
		str3=str3.replaceAll("[\\s]","");
		System.out.println(str3);
	}
}
