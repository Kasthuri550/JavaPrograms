import java.util.HashSet;

public class IntersectionOfElementsInTwoArray {

	public static void main(String[] args) {
		
		int[] arr1 = { 1, 2, 4, 5, 6,2,2,5,7,7};
        int[] arr2 = { 2, 3, 5, 7 ,2};
        
//		findIntersection1(arr1,arr2);
		findIntersection2(arr1,arr2);

	}

	private static void findIntersection2(int[] arr1, int[] arr2) {
		
		int i=0,j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				i++;
			}
			else if(arr2[j]<arr1[i])
			{
				j++;
			}
			else
			{
				System.out.println(arr2[j++]);
				i++;
			}
		}
		
	}

	private static void findIntersection1(int[] arr1, int[] arr2) {
		
		HashSet<Integer> set=new HashSet<Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			set.add(arr1[i]);
		}
		
		for(int j=0;j<arr2.length;j++)
		{
			if(set.contains(arr2[j]))
			{
				System.out.println(arr2[j]);
			}
		}
				
	}

}
