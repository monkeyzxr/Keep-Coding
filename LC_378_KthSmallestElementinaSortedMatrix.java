/**
 * Created by monkeyzxr on 2017/9/4.
 *
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
     [ 1,  5,  9],
     [10, 11, 13],
     [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n^2.
 *
 */



//二分法：
    //http://www.cnblogs.com/grandyang/p/5727892.html
    //https://www.hrwhisper.me/leetcode-kth-smallest-element-sorted-matrix/
    //https://www.programcreek.com/2016/08/leetcode-kth-smallest-element-in-a-sorted-matrix-java/
    //http://www.jiuzhang.com/solutions/kth-smallest-number-in-sorted-matrix/

//方法1： 二分法：只要求行有序，和列有木有序并没有关系。 （或者列有序，行有序无序都没关系）
//设L = min(matrix) R= max(matrix)  , mid =( L + R ) / 2 ，mid为我们猜测的答案。
//然后对于每一行，找它在该行中第几大（也是二分，找上界），累加和K比较。
    /*
将查找上下限设为矩阵的右下角与左上角元素
查找过程中对中值在矩阵每一行的位置进行累加，记该值为loc
根据loc与k的大小关系调整上下限
     */


    /*
public class LC_378_KthSmallestElementinaSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int rowNum =  matrix.length;
        int colNum = matrix[0].length;
        int left = matrix[0][0];                 //而这里的left，right， mid是数值value
        int right = matrix[rowNum-1][colNum-1];

        while (left < right){
            int mid = left + (right - left)/2; //直接平均可能會溢位，所以用此算法

            int tmp = 0;  //tmp是index的累积
            for (int i  = 0 ; i < rowNum; i++){
                tmp += binarySearch(matrix[i], colNum, mid);
            }

            if (tmp < k){
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }

        return left;
    }

    //找target在这行里，是第几大
    public static int binarySearch(int[] row, int right, int target){
        int left = 0;      //这里的left, right,mid是index
        while (left < right){
            int mid = left + (right - left)/2;
            if (row[mid] <= target){
                left = mid + 1;  //index是从零开始的
            }
            else {
                right = mid;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));

    }
}
*/



    //方法2：方法1的解法并没有利用到列有序的性质。而下面的解法利用了列有序的性质
    //类似第240题：The start point of such a sorted matrix is left-bottom corner
    //从矩阵左下角到右上角的“阶梯型”遍历。
/*
设L = min(matrix) R= max(matrix) , mid =( L + R ) / 2 ，mid为我们猜测的答案。
对于mid，我们不必再所有的行或列种执行二分查找，我们可以从左下角出发，若matrix[i][j] <= mid，则下一次查询在右边（j++），并且，该列的所有元素均比mid小，因此可以cnt += (i+1)
对于matrix[i][j] > mid，则 i – – 。
 */
public class LC_378_KthSmallestElementinaSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[rowNum-1][colNum-1];

        while (left < right){
            int mid = left + (right-left)/2;
            int count = searchLowerThanMid(matrix, mid);

            if (count < k){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;


    }

    public static  int searchLowerThanMid(int[][]matrix, int target){
        int i = matrix.length-1;  //行
        int j  = 0;   //列                    //(i, j)为左下角

        int count = 0;   //count是index的累积
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] <= target){
                count += i+1;  //优先级 + 大于 +=
                j++;
            }
            else {
                i--;
            }
        }

        return count;
    }




    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));

    }
}

//总结：题意：给定一个矩阵，该矩阵满足：每一行和每一列均为升序。给定一个数target，让你判断这个数是否在矩阵中。
//https://www.hrwhisper.me/leetcode-binary-search/    最底部
/*
第二种思路是设定初始点为最左下角或者最右上角。以最左下角为例，
当matrix[i][j] == target: 返回true不解释
当matrix[i][j] < target: 说明我们应该向右查找（行为升序）
当matrix[i][j] > target:：说明我们应该向上查找（列为降序）
这样复杂度为O(m+n)
 */