package sorting;

public class MergeSortPractice {

	public static void main(String[] args) {
		
		int arr[]={3,2,8,5,1,4,23};
		
		mergeSort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

	private static void mergeSort(int[] arr, int l, int r) {
		
		if(l>=r)
		{
			return;
		}
		
		int m=(l+r)/2;
		mergeSort(arr,l,m);
		mergeSort(arr, m+1, r);
		merge(arr,l,m,r);
		
	}

	private static void merge(int[] arr, int l, int m, int r) {
		
		int i=l,j=m+1,k=0;
		int temp[]=new int[r-l+1];
		
		while(i<=m && j<=r)
		{
			if(arr[i]<arr[j])
			{
				temp[k]=arr[i];
				i++;
			}
			else
			{
				temp[k]=arr[j];
				j++;
			}
			k++;
		}
		
		while(i<=m)
		{
			temp[k++]=arr[i++];
		}
		while(j<=r)
		{
			temp[k++]=arr[j++];
		}
		
		
		for(int p=0,q=l;p<temp.length;p++,q++)
		{
			arr[q]=temp[p];
		}
	}
}
