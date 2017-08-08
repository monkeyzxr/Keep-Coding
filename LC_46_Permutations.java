import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/7.
 *
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
 ]
 *
 *
 */

/*
http://www.cnblogs.com/yrbbest/p/4436346.html
用DFS+Backtracking来做。这里需要建立一个helper函数permute和一个辅助List<Integer> onePerm。
当onePerm.size() == nums.size()的时候，我们把这个辅助list加入到结果中。
否则我们进行从0到nums.length - 1的遍历，在这个遍历过程中我们使用了DFS+回溯。
我们假设给定nums中不含重复元素， 一个重要的去重步骤是，假如当前辅助List里已经有nums[i]了，那么我们进行跳过。
 */
//回溯法：
//https://www.jiuzhang.com/solutions/permutations/
public class LC_46_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null)
            return result;
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }

        //本题不用排序。和第47题比较一下。
        ArrayList<Integer> list = new ArrayList<>();

        helper(result, list, nums);

        return result;


    }

    //in this problem we assume no duplicate exists in input array
    public static void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));

    }
}
