import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UnionOfElementInTwoArray {

	public static void main(String[] args) {
		
		 int[] arr1 = { 1, 2, 4, 5, 6 };
	     int[] arr2 = { 2, 3, 5, 7 };
//		 UnionTwoArray1(arr1,arr2);
//		 UnionTwoArray2(arr1,arr2);
	     UnionTwoArray3(arr1,arr2);
	}

	private static void UnionTwoArray3(int[] arr1, int[] arr2) {
		
		int i=0,j=0;
		
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				System.out.println(arr1[i++]);
			}
			else if(arr2[j]<arr1[i])
			{
				System.out.println(arr2[j++]);
			}
			else
			{
				System.out.println(arr2[j++]);
				i++;
			}
		}
		
		while(i<arr1.length)
			System.out.println(arr1[i++]);
		
		while(j<arr2.length)
			System.out.println(arr2[j++]);
		
	}

	private static void UnionTwoArray2(int[] arr1, int[] arr2) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			if(map.containsKey(arr1[i]))
			{
				map.put(arr1[i],map.get(arr1[i])+1);
			}
			else
			{
				map.put(arr1[i],1);
			}
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(map.containsKey(arr2[i]))
			{
				map.put(arr2[i],map.get(arr2[i])+1);
			}
			else
			{
				map.put(arr2[i],1);
			}
		}
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(Integer i:map.keySet())
		{
			al.add(i);
		}
		
		System.out.println(al.toString());
	
	}

	private static void UnionTwoArray1(int[] arr1, int[] arr2) {
		
		HashSet<Integer> set=new HashSet<Integer>();
		
		
		for(int i=0;i<arr1.length;i++)
		{
			set.add(arr1[i]);
		}
		
		for(int j=0;j<arr2.length;j++)
		{
			if(!set.contains(arr2[j]))
			{
				set.add(arr2[j]);
			}
		}
		
		ArrayList<Integer> al=new ArrayList<Integer>(set);
		
		for(Integer i:al)
		{
			System.out.println(i);
		}
		
	}

}
