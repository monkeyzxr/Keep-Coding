import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/8.
 *
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
     [3],～
     [1], ～
     [2],～
     [1,2,3],～
     [1,3],～
     [2,3],～
     [1,2],～
     []～
 ]
 *
 */

//http://www.jiuzhang.com/solutions/subsets/


    //我有一个疑问： 空集合，是怎么得到的？？？？？？？？？？？？？？？？？？

public class LC_78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) return result;


        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);  //数组要事先排序
        helper(list, nums, 0, result);

        return result;
    }

    public static void helper(List<Integer> list, int[] nums, int startIndex, List<List<Integer>> res){

        res.add(new ArrayList<>(list));   // base 条件： 不想其他的回溯题，要满足一个if，才res.add 因为结果list的长度无限制

        for (int i = startIndex; i < nums.length; i++){
            list.add(nums[i]);
            helper(list, nums, i+1, res);  //递归到下一层：寻找以当前数开头的集合，加入到res里。例如 以1开头的 所有的lists。

            list.remove(list.size()-1);   //回溯到上一层，回到只有1开头的那个初始的list。 下一个for循环加上1，然后递归寻找以1，2开头的所有lists， 加入到res里。

        }

    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));

    }
}
