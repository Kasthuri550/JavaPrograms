
public class ShowStringImmutable {

	public static void main(String[] args) {
		
		String str1="Java";
		String str2=str1;
		System.out.println(str1==str2);
		
		str1="Python";
		
		System.out.println(str1==str2);
		
		System.out.println(str2);

	}

}
