package GreedyAlgorithm;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LeastRecentlyUsedPageReplacementAlgorithm {

	public static void main(String[] args) {

		int N = 9, C = 4,pages[] = {5, 0, 1, 3, 2, 4, 1, 0, 5};

		System.out.println(LRUPageReplacementAlgo(N,C,pages));

	}

	private static int LRUPageReplacementAlgo(int n, int c, int[] pages) {
		
		LinkedHashSet<Integer> memory=new LinkedHashSet<Integer>(c);
		
		int pageFaults=0;
		
		for(int i=0;i<n;i++)
		{
			int currentPage=pages[i];
			
			if(memory.contains(currentPage))
			{
				memory.remove(currentPage);
				memory.add(currentPage);
			}
			else
			{
				if(memory.size()==c)
				{
					Iterator<Integer> it=memory.iterator();
					it.next();
					it.remove();
				}
				
				memory.add(currentPage);
				pageFaults++;				
			}
		}
		
		return pageFaults;
	}
}
