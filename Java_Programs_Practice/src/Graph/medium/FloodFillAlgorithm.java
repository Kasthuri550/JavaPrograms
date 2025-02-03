package Graph.medium;

import java.util.Arrays;

/*
 * Time Complexity: O(N*M)+O(N*M*4) ~ O(N*M)
 * Space Complexity: O(N*M)+O(N*M) ~ O(N*M)
 * */
public class FloodFillAlgorithm {

	public static void main(String[] args) {

		int image[][] = {{1,1,1},{1,1,0},{1,0,1}}, sr = 1, sc = 1, newColor = 2;

		int result[][]=floodFill(sr,sc,image,newColor);
		printArray("Flood-Filled Image", result);

	}

	private static int[][] floodFill(int sr, int sc, int[][] image, int newColor) {

		int initialColor=image[sr][sc];

		if (initialColor == newColor) return image;

		int ans[][] = new int[image.length][image[0].length];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				ans[i][j] = image[i][j];
			}
		}

		int dx[]= {0,0,1,-1};
		int dy[]= {1,-1,0,0};

		dfs(sr,sc,image,ans,newColor,initialColor,dx,dy);
		printArray("Original Image", image);
		return ans;
	}

	private static void printArray(String string, int[][] image) {

		System.out.println(string);

		for(int row[]:image)
		{
			System.out.println(Arrays.toString(row));
		}

	}

	private static void dfs(int sr, int sc, int[][] image, int[][] ans, int newColor,int initialColor,int[] dx, int[] dy) {


		ans[sr][sc]=newColor;

		int m=image.length,n=image[0].length;

		for(int i=0;i<4;i++)
		{
			int nrow=sr+dx[i];
			int ncol=sc+dy[i];

			if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && image[nrow][ncol]==initialColor && ans[nrow][ncol]!=newColor)
			{
				dfs(nrow,ncol,image,ans,newColor,initialColor,dx,dy);
			}
		}
	}
}
