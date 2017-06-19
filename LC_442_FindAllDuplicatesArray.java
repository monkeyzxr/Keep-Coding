import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 *
 */


//http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
    //http://www.cnblogs.com/grandyang/p/6209746.html

//正负替换的方法，这类问题的核心是就是找nums[i]和nums[nums[i] - 1]的关系，
// 我们的做法是，对于每个nums[i]，我们将其对应的nums[nums[i] - 1]取相反数，
// 如果其已经是负数了，说明之前存在过，我们将其加入结果res中即可
public class LC_442_FindAllDuplicatesArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list  = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;

            if (nums[idx] < 0)   //如果遇见的nums是个负数，说明它已经被 转换成负数了，说明之前遇见它一次了。
                list.add(idx+1);

            nums[idx] = - nums[idx];
        }

        return list;
    }

    public static void main(String[] args) {
        int[]test = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(test));
    }
}
