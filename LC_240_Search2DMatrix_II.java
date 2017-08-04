/**
 * Created by monkeyzxr on 2017/8/3.
 *
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 *
 *
 */
/*
题目大意：
编写一个高效的算法，从一个m × n矩阵中寻找一个值。矩阵具有如下性质：

每一行的整数从左向右递增
每一列的整数从上往下递增
 */


//http://www.cnblogs.com/yrbbest/p/5005947.html
    //http://blog.csdn.net/xudli/article/details/47015825
//这道题是经典题, 有人在微软和YELP的onsite和电面的时候都遇到了.
//这里我们用了一个很巧妙的方法，从矩阵的右上角开始找，相当于把这个元素当作mid，
// 目标比mid大，则row + 1，小则col + 1，相等则返回mid。也是类似二分查找的思想。
public class LC_240_Search2DMatrix_II {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int rowNum = matrix.length;    //行数
        int colNum = matrix[0].length;  //列数

        int i = 0, j = colNum-1;  //找出矩阵右上角的坐标

        while (i < rowNum && j >= 0){
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;   //到下一行
            else
                j--;   //到左一列
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
