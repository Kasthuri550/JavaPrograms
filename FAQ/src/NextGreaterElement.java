
public class NextGreaterElement {

	public static void main(String[] args) {

		 int arr[]= {11, 13, 21, 3}; 
		 greater(arr);
	}

	private static void greater(int[] arr) {
		
		for(int i=0;i<arr.length;i++)
		{
			int next=-1;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					next=arr[j];
					break;
				}
			}
			System.out.println(arr[i]+"<--->"+next);
		}
		
	}

}
