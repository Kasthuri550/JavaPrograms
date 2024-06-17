package stack;

import java.util.Arrays;

public class NextGreaterElementToTheRight {

	public static void main(String[] args) {
		
		int arr[]= {3, 4, 2, 7, 5, 8, 10, 6};
		int queries = 2;
		int indices[] = {0, 5};
		int result[]=new int[queries];
		
		for(int i=0;i<queries;i++)
		{
			int count=0;
			int index=indices[i];
			int element=arr[index];
			for(int j=index+1;j<arr.length;j++)
			{
				if(arr[j]>element)
				{
					count++;
				}
			}
			
			result[i]=count;
		}
		
		System.out.println(Arrays.toString(result));

	}

}
