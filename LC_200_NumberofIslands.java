/**
 * Created by monkeyzxr on 2017/8/28.
 *
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 *
 */

//题意：给定的一个二维网格的地图（’1’（陆地）和0（水）），计数岛的数量。岛屿是四面环水，是由相邻的陆地水平或垂直连接而形成的。你可以假设该网格的所有四个边都被水包围。

//http://blog.csdn.net/DERRANTCM/article/details/47970795
//对网格每个元素时行深度优先遍，统计岛的数目
public class LC_200_NumberofIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        boolean[][]visited = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                // 如果此位置没有被访问过，并且此位置是岛，就DFSs遍历
                if (!visited[i][j] && grid[i][j] == '1'){
                    result++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return result;

    }

    public static void dfs(char[][] grid, boolean[][]visited, int row, int col){
        if (row >= 0 && row < grid.length   // 行合法
                && col >= 0 && col < grid[0].length  // 列合法
                && !visited[row][col]  // 没有访问过
                && grid[row][col] == '1'){  // 是岛上陆地

            visited[row][col] = true; // 标记此位置已经访问过了

            dfs(grid, visited, row-1, col);  //上
            dfs(grid, visited, row, col+1);  //右
            dfs(grid, visited, row+1, col);  //下
            dfs(grid, visited, row, col-1); // 左
        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));

    }
}

//BFS方法：
//http://www.jiuzhang.com/solutions/number-of-islands/