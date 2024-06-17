package Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctOrDuplicate {

	public static void main(String[] args) {

		int nums[]={1,2,3,1};
		
		System.out.println(distinctOrDuplicate(nums));
		
	}

	private static boolean distinctOrDuplicate(int[] nums) {
		List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		Set<Integer> set=new HashSet<>(collect);
		
		if(set.size()==collect.size())
		{
			return false;
		}
		
		return true;
	}
}
