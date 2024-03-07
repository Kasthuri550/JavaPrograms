import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Find_All_Four_Sum_Numbers {

	public static void main(String[] args) {
		
		int A[] = {10,2,3,4,5,7,8};
		int K=23;
		
		ArrayList<ArrayList<Integer>> fourSum = fourSum(A,K);
		System.out.println(fourSum);

	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {

		Arrays.sort(arr);
		int n = arr.length;
		Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
		// Because it does not contain duplicate
		for (int i = 0; i < n-3; i++) {
			int first = arr[i];
			for (int j = i + 1; j < n-2; j++) {
				int second = arr[j];
				int l = j + 1, r = n - 1;
				while (l < r) {
					int sum = first + second + arr[l] + arr[r];
					if (sum == k) {
						ArrayList<Integer> list1 = new ArrayList<>();
						list1.add(first);
						list1.add(second);
						list1.add(arr[l]);
						list1.add(arr[r]);
						set.add(list1);
						r--;
					} else if (sum > k) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(set);
		return list2;
	}

}
