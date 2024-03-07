import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		
		int arr[] = { 1, 1, 2, 1, 3, 5, 1,2,2,2,2,2,2 };
		
		int majority = majority(arr);
		System.out.println(majority);

	}

	private static int majority(int[] arr) {
		
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				map.put(arr[i],map.get(arr[i])+1);
			}
			else
			{
				map.put(arr[i],1);
			}
			
		}
		
		for(Map.Entry<Integer, Integer> me: map.entrySet())
		{
			if(me.getValue()>(arr.length)/2)
			{
				return me.getKey();
			}
				
		}
		
		return -1;
		
	}

}
