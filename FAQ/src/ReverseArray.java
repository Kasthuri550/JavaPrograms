import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

	public static void main(String[] args) {
		
		int [] arr = {10, 20, 30, 40, 50}; 
//		reverse1(arr,arr.length);
//		reverse2(arr,arr.length);
//		reverse3(arr,arr.length);
//		reverse4(arr,arr.length);
		reverse5(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void reverse5(int[] arr, int start, int end) {
		
		if(start>=end)
			return;
		
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		reverse5(arr,start+1,end-1);						
	}

	private static void reverse4(int[] arr, int length) {
		
		int start=0,end=length-1;
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		
		for(int a:arr)
		{
			System.out.print(a+" ");
		} 
		
	}

	private static void reverse3(int[] arr, int length) {
		
		Collections.reverse(Arrays.asList(arr));
		System.out.println(Arrays.toString(arr));
		
	}

	private static void reverse2(int[] arr, int length) {
		
		for(int i=0;i<length/2;i++)
		{
			int t=arr[i];
			arr[i]=arr[length-1-i];
			arr[length-1-i]=t;
		}
		
		for(int l:arr)
		{
			System.out.print(l+" ");
		}
		
	}

	private static void reverse1(int[] arr, int length) {
		
		int t[]=new int[length];
		int j=length;
		for(int i=0;i<length;i++)
		{
			t[j-1]=arr[i];
			j=j-1;
		}
		
		
		for(int k:t)
		{
			System.out.print(k+" ");
		}
		
	}

}
