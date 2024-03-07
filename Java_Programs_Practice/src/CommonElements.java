import java.util.ArrayList;

public class CommonElements {

	public static void main(String[] args) {
		
		int n1 = 7;
		int[] A = {1, 5, 10, 20, 40, 80,45};
		int n2 = 6; 
		int[] B = {6, 7, 20, 80, 100,45};
		int n3 = 9; 
		int[] C = {3, 4, 15, 20, 30, 70, 80, 120,45};
		
		ArrayList<Integer> al=commonElements(A,B,C,n1,n2,n3);
		al.forEach(System.out::println);
	}
	
	static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
		ArrayList<Integer> al=new ArrayList<Integer>();
		int i=0,j=0,k=0;
		
		
		while(i<n1 && j<n2 &&k<n3)
		{
			if(A[i]==B[j] && B[j]==C[k])
			{
				if(al.contains(A[i])!=true)
				{
					al.add(A[i]);
				}
				i++;
				j++;
				k++;
			}
			else if(A[i]<B[j])
			{
				i++;
			}
			else if(B[j]<C[k])
			{
				j++;
			}
			else
			{
				k++;
			}
				
		}
		
		return al;
    
    }

}
