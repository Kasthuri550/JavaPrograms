package Arrayprograms.hard;

import java.util.Arrays;

public class Closest3Sum {

	public static void main(String[] args) {
		
		int[] Arr = {1, 2, 3, 4, -1, -2, -5, 5};
        int N = Arr.length,X=3;
        
        System.out.println(sum3closest(Arr,N,X));
	}

	private static int sum3closest(int[] Arr, int N, int X) {
		
		 Arrays.sort(Arr);

	        int closestSum = Integer.MAX_VALUE;

	        for (int i = 0; i < N - 2; i++) {
	            int left = i + 1, right = N - 1;

	            while (left < right) {
	                int currentSum = Arr[i] + Arr[left] + Arr[right];

	                if (Math.abs(X - currentSum) < Math.abs(X - closestSum) || 
	                	(Math.abs(X - currentSum) == Math.abs(X - closestSum) &&
	                	currentSum > closestSum)) {
	                    closestSum = currentSum;
	                }

	                if (currentSum < X) {
	                    left++;
	                } else {
	                    right--;
	                }
	            }
	        }

	        return closestSum;
	}

}
