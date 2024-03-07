import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 6, 5, 4};
		
		List<Integer> nextPermutation = nextPermutation(arr);
		System.out.println(nextPermutation);

	}

	private static List<Integer> nextPermutation(int[] arr) {
		
		
		List<Integer> a=new ArrayList<Integer>();
		
		for(int i:arr)
		{
			a.add(i);
		}
		int ind=-1;
		int n=a.size();
		
		for(int i=n-2;i>=0;i--)
		{
			if(a.get(i)<a.get(i+1))
			{
				ind=i;
				break;
			}
		}
		
		if(ind==-1)
		{
			Collections.reverse(a);
		}
		
		for(int j=n-1;j>ind;j--)
		{
			if(a.get(j)>a.get(ind))
			{
				int temp=a.get(j);
				a.set(j,a.get(ind));
				a.set(ind,temp);
				break;				
			}
		}
		
		
		List<Integer> subList=a.subList(ind+1,n);
		Collections.reverse(subList);
		
		return a;
	}

}
