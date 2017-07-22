import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/21.
 *
 Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
       [2],
      [3,4],
     [6,5,7],
     [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

//题意： 自顶向下寻找一条路径使得路径上每个节点的值的和，是所有路径中最小的。
// !!!!!!! 限制条件：每次只能选下一行的邻接节点。

    /* http://blog.csdn.net/nk_test/article/details/49456237
    采用由下到上的思想（这样最后只需要取出dp[0][0]就是答案），
    本层每个结点的结果根据下面一行的路基累计和而计算，
    要么取左边的，要么取右边的，
    两者取最小的即可。
    状态转移方程：triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])
     */

    //https://discuss.leetcode.com/topic/1669/dp-solution-for-triangle/20
public class LC_120_Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        for (int i = triangle.size()-2; i >= 0; i--){
            for (int j = 0; j <=i; j++) {//第n行，有n+1个元素
                List<Integer>  nextRow = triangle.get(i+1);   //第i+1行的 一行数字
                int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);

                triangle.get(i).set(j, sum);
            }
        }

        return triangle.get(0).get(0);


    }

    public static void main(String[] args) {

    }
}


//变成array 更好看：

/*  http://blog.csdn.net/nk_test/article/details/49456237

class Solution {
public:
  int minimumTotal(vector<vector<int> > &triangle) {
    for (int i = triangle.size() - 2; i >= 0; --i)
      for (int j = 0; j <= i; ++j){

        triangle[i][j] +=min(triangle[i+1][j+1],triangle[i+1][j]);
      }

    return triangle[0][0];
  }
};



http://blog.csdn.net/ebowtang/article/details/50687182

//path[i][j]为第i行第j列（从0算起）到底部的最小路径和
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        vector< vector<int> > path(triangle);  //新array，要初始化
        for(int i=triangle.size()-2;i>=0;i--)//从倒数第二行开始递推
            for(int j=0; j < triangle[i].size();j++)
                path[i][j] = min( path[i+1][j], path[i+1][j+1])+triangle[i][j];
        return path[0][0];
    }
};
 */