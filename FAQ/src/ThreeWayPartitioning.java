
public class ThreeWayPartitioning {

	public static void main(String[] args) {

		int array[]= {6,3,2,1,5};
		int n=array.length;
		int a=3,b=4;
		threeWayPartition(array,n,a,b);
		
		for(int arr:array)
		{
			System.out.print(arr+" ");
		}
	}

	private static void threeWayPartition(int[] array, int n, int a, int b) {
		
		int l=0;
		int r=array.length-1;
		
		for(int i=0;i<=r;i++)
		{
			if(array[i]<a)
			{
				swap(array,i,l);
				l++;
			}
			
			if(array[i]>b)
			{
				swap(array,i,r);
				r--;
				i--;
			}
		}
		
	}

	private static void swap(int[] array, int x, int y) {
		
		int temp=array[x];
		array[x]=array[y];
		array[y]=temp;
	}

}
