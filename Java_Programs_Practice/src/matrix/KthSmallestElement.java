package matrix;

import java.util.Arrays;

public class KthSmallestElement {

	public static void main(String[] args) {
		
		int[][] matrix = {
	            {1,  5,  9},
	            {10, 11, 13},
	            {12, 13, 15}
	        };
	        int k = 8;

	        int result = kthSmallest(matrix, k);
	        System.out.println("The " + k + "th smallest element is: " + result);
	        
	        System.out.println(kthSmallest1(matrix,k));
	}
	
	 private static int kthSmallest1(int[][] matrix, int k) {
		 
		 int rows=matrix.length;
		 int cols=matrix[0].length;
		 int flattened[]=new int[rows*cols];
		 int index=0;
		 
		 for(int row[]:matrix)
		 {
			 for(int element:row)
			 {
				 flattened[index++]=element;
			 }
		 }
		 
		 Arrays.sort(flattened);
		 
		 return flattened[k-1];
	}

	public static int countLessEqual(int[][] matrix, int target) {
	        int count = 0;
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int row = rows - 1; // Start from bottom-left corner

	        for (int col = 0; col < cols; col++) {
	            while (row >= 0 && matrix[row][col] > target) {
	                row--;
	            }
	            count += (row + 1);
	        }

	        return count;
	    }

	    public static int kthSmallest(int[][] matrix, int k) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;

	        int low = matrix[0][0];
	        int high = matrix[rows - 1][cols - 1];

	        while (low < high) {
	            int mid = low + (high - low) / 2;
	            int count = countLessEqual(matrix, mid);

	            if (count < k) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }

	        return low;
	    }
}
