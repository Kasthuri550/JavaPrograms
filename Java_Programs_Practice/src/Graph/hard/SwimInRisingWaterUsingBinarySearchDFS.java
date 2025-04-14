package Graph.hard;

public class SwimInRisingWaterUsingBinarySearchDFS {

	private static final int dx[]= {0,1,0,-1};
	private static final int dy[]= {1,0,-1,0};

	public static void main(String[] args) {

		int[][] grid = {
				{0, 1, 2},
				{5, 4, 3},
				{6, 7, 8}
		};

		System.out.println(swimInRisingWater(grid));
	}

	private static int swimInRisingWater(int[][] grid) {

		int n=grid.length;
		int left=grid[0][0],right=n*n-1;

		while(left<right)
		{
			int mid=(left+right)/2;

			boolean visited[][]=new boolean[n][n];
			if(canReach(grid,0,0,n,visited,mid))
			{
				right=mid;
			}
			else
			{
				left=mid+1;
			}
		}

		return left;
	}

	private static boolean canReach(int[][] grid, int x, int y, int n, boolean[][] visited, int mid) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > mid)
            return false;

        if (x == n - 1 && y == n - 1)
            return true;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canReach(grid, newX, newY, n, visited, mid)) {
                return true;
            }
        }

        return false;
    }
}
