package Arrayprograms;

import java.math.BigInteger;

public class MaxRectangle {

	public static void main(String[] args) {
		
		int[][] mat = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int n = 4, m = 5;
        int maxArea = maximalAreaOfSubMatrixOfAll1(mat, n, m);
        System.out.println("The maximum area is: " + maxArea);

	}
	
	static int largestRectangleArea(int[] arr, int n) {
		
		int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int maxArea = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height,height.length);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        
    }

}
