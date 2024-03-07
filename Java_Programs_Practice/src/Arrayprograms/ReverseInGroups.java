package Arrayprograms;

import java.util.Arrays;
import java.util.List;

public class ReverseInGroups {

	public static void main(String[] args) {
		
		int n = 5, k = 3;
		List<Integer> arr=Arrays.asList(1,2,3,4,5);
		
		 for (int i = 0; i < n; i += k) {
	            int left = i;
	            int right = Math.min(i + k - 1, n - 1);
	            while (left < right) {
	                int temp = arr.get(left);
	                arr.set(left, arr.get(right));
	                arr.set(right, temp);
	                left++;
	                right--;
	            }
	        }
		 
		 System.out.println(arr);

	}

}
