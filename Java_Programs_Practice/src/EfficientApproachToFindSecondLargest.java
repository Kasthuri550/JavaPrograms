import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EfficientApproachToFindSecondLargest {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(78,56,34,21,90));
		
		Set<Integer> set=new TreeSet<Integer>(list);
		
		list.clear();
		
		for(Integer value:set)
		{
			list.add(value);
		}
				
		int n=set.size();
		
		System.out.println(list.get(n-2));

	}

}
