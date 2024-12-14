package ArrayPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElementsInAnArray  {

	public static void main(String[] args) {

		int[] array = {3, 4, 4, 4, 4,1, 2, 2, 3, 3};

		brute(array);
		better(array);
		optimal(array);

	}

	private static void optimal(int[] arr) {
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int a:arr)
		{
			map.put(a, map.getOrDefault(a,0)+1);
		}
		
		System.out.println(map);
		
	}

	private static void better(int[] arr) {
		
		int n=arr.length,count=0;
		
		Arrays.sort(arr);
		
		for(int i=1;i<n;i++)
		{
			if(arr[i]==arr[i-1])
			{
				
				count++;
			}
			else
			{
				System.out.println(arr[i-1]+"-> "+count);
				count=1;
			}
		}
		
		System.out.println(arr[n-1]+"-> "+count);
		
	}

	private static void brute(int[] arr) {

		int n=arr.length;
		boolean visited[]=new boolean[arr.length];

		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				int count=1;
				for(int j=i+1;j<n;j++)
				{
					if(arr[i]==arr[j])
					{
						count++;
						visited[j]=true;
					}	
				}

				System.out.println(arr[i]+" -> "+count);
			}
		}

	}

}
