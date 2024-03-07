import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		
		TreeSet ts=new TreeSet();
		ts.add(10);
		ts.add(90);
		ts.add(67);
//		ts.add(new String("Kasthuri"));
//		ts.add(new String("Arun"));
//		ts.add(null);
//		ts.add(new StringBuffer("Kasthuri"));
//		ts.add(new StringBuffer("Arun"));
//		ts.add(new StringBuilder("Kasthuri"));
//		ts.add(new StringBuilder("Arun"));
		
		System.out.println(ts);
		
		System.out.println("A".compareTo("Z"));
		System.out.println("Z".compareTo("B"));
		System.out.println("A".compareTo("A"));

	}

}
