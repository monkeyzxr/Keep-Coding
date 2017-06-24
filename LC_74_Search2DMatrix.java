/**
 * Created by monkeyzxr on 2017/6/23.
 *
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 */



//http://blog.csdn.net/geekmanong/article/details/50551128
//二分查找法:

// 将m*n的矩阵看成数组，即: matrix[x][y] => a[x*n+y]
//数组也可以转回m*n矩阵，即: a[x] => matrix[x/n][x%n]

public class LC_74_Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;   //一维数组的最小值 和 最大值的 index
        int high = m * n - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            int value = matrix[mid/n][mid%n];

            if (value == target)
                return true;

            else if (value < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return false;



    }

    public static void main(String[] args) {
        int [][]test = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(new LC_74_Search2DMatrix().searchMatrix(test, 11));
        System.out.println(new LC_74_Search2DMatrix().searchMatrix(test, 23));


    }
}
