import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/8.
 *
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
     [2],
     [1], ～
     [1,2,2],
     [2,2],
     [1,2],～
     []
 ]
 *
 */

//https://www.jiuzhang.com/solutions/subsets-ii/
//http://bangbingsyb.blogspot.com/2014/11/leetcode-subsets-i-ii.html

//与第78题类比。本题的nums数组有重复数字，但是结果不能重复
public class LC_90_Subsets_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;

        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums, 0, list, result);

        return result;

    }

    public static void helper(int[] nums, int startIndex, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list)); // base条件

        for (int i = startIndex; i < nums.length; i++){
            if (i != startIndex && nums[i] == nums[i-1]){  //如果已经有一个相同的数加入到list了，则进入下一个循环。例如，list加入了1，2（第二个2），就不能再加入1，2（第三个2）
                continue;
            }

            list.add(nums[i]);
            helper(nums, i+1, list, res);

            list.remove(list.size()-1); // 回溯到上一层
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};

        System.out.println(subsetsWithDup(nums));

    }
}
