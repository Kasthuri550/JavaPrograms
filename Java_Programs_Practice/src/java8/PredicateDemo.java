package java8;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,8,15,7};
		Predicate<Integer> p1=i -> i%3==0;
		Predicate<Integer> p2=j -> j%5==0; 
		
		for(int i=0;i<arr.length;i++)
		{
			if(p1.and(p2).test(arr[i]))
			{
				System.out.println("and"+arr[i]);
			}
			
			if(p1.or(p2).test(arr[i]))
			{
				System.out.println("or"+arr[i]);
			}
			
			if(p1.negate().test(arr[i]))
			{
				System.out.println("negate"+arr[i]);
			}
		}
		
		Predicate<String> equalPredicate= Predicate.isEqual("cat");
		System.out.println(equalPredicate.test("cat"));
	
	}

}
