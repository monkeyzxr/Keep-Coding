import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/26.
 *
 Given a matrix of m x n elements (m rows, n columns),
 return all elements of the matrix in spiral 螺旋的 order.

 For example,
 Given the following matrix:

 [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 *
 */

//http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
//If more than one row and column left, it can form a circle and we process the circle.
// Otherwise, if only one row or column left, we process that column or row ONLY.

public class LC_54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int px = 0;
        int py = 0;

        while (m > 0 && n > 0){
            //处理如果只有一行或者一列的情况，此时无circle
            if(m == 1){
                for (int i = 0; i < n; i++){
                    result.add(matrix[px][py++]);
                }
                break;
            }
            else if (n == 1){
                for (int i = 0; i < m; i++){
                    result.add(matrix[px++][py]);
                }
                break;
            }

            //处理circle：

            //top - move right
            for (int i = 0; i < n-1; i++){  //每一个循环，只到最后一个数的前一个，这样4个循环就不会又重叠的数
                result.add(matrix[px][py++]);
            }

            //right - move down
            for (int i = 0; i < m-1; i++){
                result.add(matrix[px++][py]);
            }

            // bottom - move left
            for (int i = 0; i < n-1; i++){
                result.add(matrix[px][py--]);
            }

            //left - move up
            for (int i = 0; i < m-1; i++){
                result.add(matrix[px--][py]);
            }

            px++;  //x,y 的开始位置变成上一次开始位置的  右下斜对角的数。如例子中从1，变成5
            py++;

            m = m-2;  //每走完一圈，少2个行，少2个列
            n = n-2;
        }

        return result;


    }

    public static void main(String[] args) {
        int[][]test = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spiralOrder(test));


    }
}
