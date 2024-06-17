package sorting;

public class BubbleSortPractice {

	public static void main(String[] args) {
		
		int arr[]={4, 1, 3, 9, 7};
		String strArray[]= {"kasthuri","arun","kumar","suseela","sathya","moorthy"};
		bubbleSortAsc(arr);
		bubbleSortDesc(arr);
		bubbleSortStr(strArray);
	}

	private static void bubbleSortStr(String[] strArray) {
		
		int n=strArray.length;
		
		for(int i=0;i<n-1;i++)
		{
			int didSwap=0;
			for(int j=0;j<n-i-1;j++)
			{
				if(strArray[j].compareTo(strArray[j+1])>0)
				{
					String tempStr=strArray[j];
					strArray[j]=strArray[j+1];
					strArray[j+1]=tempStr;
					didSwap=1;
				}
			}
			
			if(didSwap==0)
			{
				break;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(strArray[i]+", ");
		}
		
	}

	private static void bubbleSortDesc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n-1;i++)
		{
			int didSwap=0;
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]<arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					didSwap=1;
				}
			}
			
			if(didSwap==0)
			{
				break;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void bubbleSortAsc(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n-1;i++)
		{
			int didSwap=0;
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					didSwap=1;
				}
			}
			if(didSwap==0)
			{
				break;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
}
