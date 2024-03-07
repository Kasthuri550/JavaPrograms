

public class DeleteElementUnSortedArray {

	public static void main(String[] args) {
		
		int arr[] = { 10, 50, 30, 40, 20 };
		
		int element=20;

		int arrayLength = deleteElementArray(arr,arr.length,element);
		
		for(int j=0;j<arrayLength;j++)
		{
			System.out.print(arr[j]+" ");
		}
		
	}

	private static int deleteElementArray(int[] arr, int length, int element) {
		
		int pos=findElement(arr,element);
		if(pos==-1)
		{
			System.out.println("Element not found");
			return length;
		}
		
		for(int i=pos;i<length-1;i++)
		{
			arr[i]=arr[i+1];
		}
		
		return length-1;
	}

	private static int findElement(int[] arr, int element) {
		
		
		for(int i=0;i<arr.length;i++)
		{
			if(element==arr[i])
				return i;
		}
		
		return -1;
		
	}

}
