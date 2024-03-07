
public class SwapNumbers {

	public static void main(String[] args) {
		
//		approach1(7,8);
//		approach2(10,20);
//		approach3(999,23);
//		approach4(23,78);
		approach5(45,78);

	}

	private static void approach5(int a, int b) {
		
		System.out.println("a= "+a+" b= "+b);
		a=a+b-(b=a);
		System.out.println("a= "+a+" b= "+b);
		
	}

	private static void approach4(int a, int b) {
		System.out.println("a= "+a+" b= "+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a= "+a+" b= "+b);
		
	}

	private static void approach3(int a, int b) {
		System.out.println("a= "+a+" b= "+b);
		a=a*b;
		b=a/b;
		a=a/b;
		System.out.println("a= "+a+" b= "+b);
	}

	private static void approach2(int a, int b) {
		
		System.out.println("a= "+a+" b= "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a= "+a+" b= "+b);
	}

	private static void approach1(int a,int b) {
		
		System.out.println("a= "+a+" b= "+b);
		int t=a;
		a=b;
		b=t;		
		System.out.println("a= "+a+" b= "+b);
	}

}
