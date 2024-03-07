import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateTwoLists {

	public static void main(String[] args) {
		
		List<Integer> list1=new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2=new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		List<Integer> mergedLists1=new ArrayList<Integer>(list1);
		mergedLists1.addAll(list2);
		
		System.out.println(mergedLists1);
		
		List<Integer> mergedLists2=Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
		
		System.out.println(mergedLists2);
		
//		List<Integer> mergedLists3=ListUtils.union(list1,list2);
		
	}

}
