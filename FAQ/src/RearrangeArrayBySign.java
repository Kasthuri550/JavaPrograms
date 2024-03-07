import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayBySign {

	public static void main(String[] args) {
		
		int A[] = {1,2,-4,-5};
//		int[] modifiedArray = approach1(A,A.length);
//		int[] modifiedArray = approach2(A,A.length);
		int[] modifiedArray = approach3(A,A.length);
		System.out.println(Arrays.toString(modifiedArray));
	}




	//	Brute force
	private static int[] approach1(int[] a, int length) {
		
		ArrayList<Integer> pos=new ArrayList<Integer>();
		ArrayList<Integer> neg=new ArrayList<Integer>();
		
		for(int i=0;i<length;i++)
		{
			if(a[i]<0)
			{
				neg.add(a[i]);
			}
			else
			{
				pos.add(a[i]);
			}
			
		}
		
		for(int i=0;i<length/2;i++)
		{
			a[2*i]=pos.get(i);
			a[2*i+1]=neg.get(i);
		}
		
		return a;
		
	}

	private static int[] approach2(int[] a, int length) {
		
		int arr[]=new int[length];
		int neg=1,pos=0;
		
		for(int i=0;i<length;i++)
		{
			if(a[i]<0)
			{
				arr[neg]=a[i];
				neg+=2;
			}
			else
			{
				arr[pos]=a[i];
				pos+=2;
			}
		}
		return arr;
	}
	
	private static int[] approach3(int[] a, int length) {
		
		ArrayList<Integer> pos=new ArrayList<Integer>();
		ArrayList<Integer> neg=new ArrayList<Integer>();
		
		int arr[]=new int[length];
		
		for(int i=0;i<length;i++)
		{
			if(a[i]<0)
			{
				neg.add(a[i]);
			}
			else
			{
				pos.add(a[i]);
			}
			
		}
		if(pos.size()>neg.size())
		{
			for(int i=0;i<neg.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=neg.size()*2;
			for(int j=neg.size();j<pos.size();j++)
			{
				arr[index]=pos.get(j);
				index++;
			}
		}
		else
		{
			for(int i=0;i<neg.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=pos.size()*2;
			for(int j=pos.size();j<neg.size();j++)
			{
				arr[index]=neg.get(j);
				index++;
			}
			
		}
		return arr;		
	}
}
