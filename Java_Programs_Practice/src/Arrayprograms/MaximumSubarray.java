package Arrayprograms;

import java.util.ArrayList;

public class MaximumSubarray {

	public static void main(String[] args) {
		
	    int a[] = {2,1,-1,2,1};
	    int n = a.length;
	    ArrayList<Integer> subarray = findSubarray(a,n);
	    System.out.println(subarray);
	}

	static ArrayList<Integer> findSubarray(int a[], int n) {

		ArrayList<Integer> subarray = new ArrayList<Integer>();

		int sum = 0, maxSum = Integer.MIN_VALUE, start = 0, begin = -1, end = -1, currentLength = 0, maxLength = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				sum += a[i];
				currentLength++;
			} else {
				sum = 0;
				start = i + 1;
				currentLength = 0;
			}

			if (sum > maxSum || (sum == maxSum && currentLength > maxLength))
//				||(sum==maxSum && currentLength==maxLength)) 
				{
				maxSum = sum;
				begin = start;
				end = i;
				maxLength = currentLength;
			}
		}

		if (begin != -1 && end != -1) {
			for (int i = begin; i <= end; i++) {
				subarray.add(a[i]);
			}
		} else {
			subarray.add(-1);
		}
		
		System.out.println(begin+" "+end);

		return subarray;
	}

}
