package sorting;

public class SelectionSortPractice {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		
		selectionSortAsc(arr);
		selectionSortDesc(arr);
		selectionSortStr("kasthuri");

	}

	private static void selectionSortStr(String str) {
		
		int n=str.length();
		char charArray[]=str.toCharArray();
		
		for(int i=0;i<n-1;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(charArray[j]<charArray[min])
				{
					min=j;
				}
			}
			
			char temp=charArray[min];
			charArray[min]=charArray[i];
			charArray[i]=temp;	
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(charArray[i]+" ");
		}
		
	}

	private static void selectionSortDesc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n-1;i++)
		{
			int max=i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[max]<arr[j])
				{
					max=j;
				}
			}
			
			int temp=arr[max];
			arr[max]=arr[i];
			arr[i]=temp;
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}

	private static void selectionSortAsc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n-1;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}
			
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}

}
