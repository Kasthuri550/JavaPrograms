package Arrayprograms;

public class LargestRectangleAreaHistogram {

	public static void main(String[] args) {
		
		int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
        System.out.println("The largest area in the histogram is " + largestarea(arr, n));

	}

	private static int largestarea(int[] arr, int n) {
		
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
}
