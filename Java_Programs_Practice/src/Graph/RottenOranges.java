package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N*M)
 * Space Complexity: O(N*M)+O(N*M*4) ~ O(N*M)
 * */
public class RottenOranges {

	public static void main(String[] args) {

		int mat[][] = 
			{{0, 1, 2}, 
					{0, 1, 2}, 
					{2, 1, 1}};

		System.out.println(rottenOranges(mat));
	}

	private static int rottenOranges(int[][] mat) {

		if(mat==null || mat.length==0) return 0;

		int rows=mat.length,cols=mat[0].length,count_fresh=0;

		Queue<int[]> queue=new LinkedList<>();

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(mat[i][j]==2)
				{
					queue.add(new int[] {i,j});
				}

				if(mat[i][j]!=0)
				{
					count_fresh++;
				}
			}
		}

		if(count_fresh==0) return 0;

		int count=0,count_min=0;

		int dx[]= {0,0,1,-1},dy[]= {1,-1,0,0};

		while(!queue.isEmpty())
		{
			int size=queue.size();

			count=count+size;

			for(int i=0;i<size;i++)
			{
				int point[]=queue.poll();

				for(int j=0;j<4;j++)
				{
					int x=point[0]+dx[j];
					int y=point[1]+dy[j];

					if(x<0 || y<0 || x>=rows || y>=cols || mat[x][y]==0 || mat[x][y]==2) continue;

					mat[x][y]=2;

					queue.offer(new int[] {x,y});
				}
			}

			if(queue.size()!=0)
			{
				count_min++;
			}
		}

		return count_fresh==count?count_min:-1;
	}
}
