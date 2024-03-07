import java.util.ArrayList;

public class TwoSumPair {

	public static void main(String[] args) {
		
		int A[]={1,4,-1,6,35};
	    int size=A.length;
	    int x=10;
	    ArrayList<Integer> al=new ArrayList<Integer>();
	    for (int i = 0; i < size; i++) {
            for (int j = (i + 1); j < size; j++) {
                if (A[i] + A[j] == x) {
                    al.add(A[i]);
                    al.add(A[j]);
                }
            }
        }
	    
	    System.out.print(al);
	    System.out.println((int)Math.log10(A[4])+1);

	}

}
