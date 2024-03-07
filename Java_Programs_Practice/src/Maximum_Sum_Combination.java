import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Maximum_Sum_Combination {

	public static void main(String[] args) {

		int A[] = { 1, 4, 2, 3 };
		int B[] = { 2, 5, 1, 6 };

		List<Integer> maxCombinations = maxCombinations(4, 3, A, B);
		
		Iterator<Integer> iterator=maxCombinations.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}

	}

	static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {

		PriorityQueue<Integer> p = new PriorityQueue<>();
		Arrays.sort(A);  // {1,2,3,4}
		Arrays.sort(B);  // {1,2,5,6}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				int t = A[i] + B[j];
				if (p.size() < K) {
					p.add(t);
				} else if (p.peek() < t) {
					p.poll();
					p.add(t);
				} else {
					break;
				}
			}

		}
		List<Integer> l = new ArrayList<>();
		while (!p.isEmpty()) {
			l.add(p.poll());
		}
		Collections.sort(l, Collections.reverseOrder());
		return l;

	}

}
