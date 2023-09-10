public class Solution64 {

    /*
        Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.



        Example 1:


        Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        Output: 7
        Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
        Example 2:

        Input: grid = [[1,2,3],[4,5,6]]
        Output: 12


        Constraints:

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 200
        0 <= grid[i][j] <= 200
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // init 1st row step value
        if (row > 1) {
            for (int i = 1; i < row; i++) {
                grid[i][0] += grid[i - 1][0];
            }
        }

        // init 1st column step value
        if (col > 1) {
            for (int j = 1; j < col; j++) {
                grid[0][j] += grid[0][j - 1];
            }
        }

        if (row == 1) return grid[0][col - 1];
        if (col == 1) return grid[row - 1][0];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }

}
