import java.util.LinkedList;
import java.util.Queue;

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

    /*
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
*/



//BFS方法：
//BFS: 所谓的一层，是指从起点到这个点的最短距离相同的点属于一层
//http://www.jiuzhang.com/solutions/number-of-islands/
//每次都从队列中取出一个点，看这个点的上下左右能不能走，再看有没有走过，没走过且能走就加入进队列，直到走到终点，所谓的一层，是指从起点到这个点的最短距离相同的点属于一层

public class LC_200_NumberofIslands {

    public class Coordinate{  //构建一个坐标的class，相当于一个pair
        int x, y;
        public Coordinate(int x, int y){  //1.Constructor name must be same as its class name 2.Constructor must have no explicit return type
            this.x = x;
            this.y = y;
        }
    }

    public void markByBFS(char[][] grid, int x, int y){
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};   //X和Y为一组：依次是： （0，1：上） （1，0 ：右）（-1，0： 左）（0，-1： 下）

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = '0';

        while (!queue.isEmpty()){
            Coordinate currCoor = queue.poll();
            for (int i = 0; i < 4; i++){
                //当前坐标依次向四个方向走，建立新的adjacent坐标
                Coordinate adjCoor = new Coordinate(currCoor.x+directionX[i], currCoor.y+directionY[i]);

                if (!checkInBound(adjCoor, grid)){
                    continue;
                }

                if (grid[adjCoor.x][adjCoor.y] == '1'){
                    grid[adjCoor.x][adjCoor.y] = '0';  //grid[x][y] == true的时候是岛，grid[x][y] == false的时候是水。
                                                        //标记成为访问过，就是变成水，之后就不会重复计算了。
                    queue.offer(adjCoor);
                }

            }
        }
    }


    public boolean checkInBound(Coordinate coor, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }


    public  int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int isIsland = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m ; j++){
                if (grid[i][j] == '1'){
                    markByBFS(grid, i, j);
                    isIsland++;
                }
            }
        }

        return isIsland;



    }



    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(new LC_200_NumberofIslands().numIslands(grid));

    }
}
