import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Given an array consists of non-negative integers,
 your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 Example 1:
 Input: [2,2,3,4]
 Output: 3

 Explanation:
 Valid combinations are:
 2,3,4 (using the first 2)
 2,3,4 (using the second 2)
 2,2,3

 Note:
 The length of the given array won't exceed 1000.
 The integers in the given array are in the range of [0, 1000].
 *
 */

//http://www.geeksforgeeks.org/find-number-of-triangles-possible/
    //http://bookshadow.com/weblog/2017/06/11/leetcode-valid-triangle-number/
//三角形：两边之和大于第三边
public class LC_611_ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        //现排序，升序
        Arrays.sort(nums);
        int count = 0;


        // i，j，k，k,k,k.............k
        //i 是排序之后的最左端，最小的数； j是比i大一个的数。i和j作为两条小边
        for (int i = 0; i < nums.length-2; i++){
            if (nums[i] == 0) continue;  //如果首先遇到了0，就pass过去


            int k = i + 2;  //k是第三边。k初始化为i的 下下一个数。k要慢慢升高。

            for (int j = i+1; j < nums.length-1; j++){
                while(k < nums.length && nums[i]+nums[j] > nums[k])
                    k++;

                count += k - j - 1;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] test = {2,2,3,4};
        System.out.println(triangleNumber(test));

    }
}
