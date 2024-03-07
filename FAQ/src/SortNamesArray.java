import java.util.Arrays;

public class SortNamesArray {

	public static void main(String[] args) {
		
		int n = 4;
	       
        String names[]= { "Rahul", "ajay", "Gourav", "Riya" };
//		sortArray1(names,n);
        sortArray2(names,n);
	}

	private static void sortArray2(String[] names, int n) {
		
		Arrays.parallelSort(names);
		
		for(String name:names)
		{
			System.out.println(name);
		}
		
	}

	private static void sortArray1(String[] names, int n) {
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(names[i].compareToIgnoreCase(names[j])>0)
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		
		for(String name:names)
		{
			System.out.println(name);
		}
	}

}
