package Basicmaths;

import java.util.ArrayList;
import java.util.List;

public class FindListOdd {

	public static void main(String[] args) {

		List<Integer> list=new ArrayList<Integer>() {
			private static final long serialVersionUID = 1L;

		{
			add(11);
			add(13);
			add(7);
		}};
		list.add(10);
		
		System.out.println(oddNumberOnly(list));
		System.out.println(oddNumberOnlyStream(list));
	}

	private static boolean oddNumberOnlyStream(List<Integer> list) {
		
		return list.stream().allMatch(x->x%2!=0);
	}

	private static boolean oddNumberOnly(List<Integer> list) {
		
		for(int value:list)
		{
			if((value & 1) == 0)
			{
				return false;
			}
		}
		
		return true;
	}

}
