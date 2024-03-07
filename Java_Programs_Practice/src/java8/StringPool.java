package java8;

public class StringPool {

	public static void main(String[] args) {
		
		String str1="java";
		String str2="java";
		String str3=new String("java").intern();
		
		System.out.println(str1==str2);
		System.out.println(str2==str3);
		final String str4="Chennai";
		
		
		try {
		      System.exit(0);
		    } finally {
		      System.err.println("I'm not dead yet!");
		      System.exit(1);
		    }
	}

}
