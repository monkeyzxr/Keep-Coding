import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/12.
 *
 Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
     [7],
     [2, 2, 3]
 ]
 */
//https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/3

//http://www.jiuzhang.com/solutions/combination-sum/
    //http://blog.csdn.net/qq_32199531/article/details/52745884
    //https://www.tianmaying.com/tutorial/LC39

//回溯法：
//基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。
//以beginIndex记录我们选到了第几个值，并且一直往后选，这样可以避免选到重复的子集。
public class LC_39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null)
            return result;

        List<Integer> combination = new ArrayList<>();

        Arrays.sort(candidates);  //排序，为了避免选到重复的子集

        helper(candidates, 0, target, combination, result);

        return result;

    }

    public static void helper(int[] candidates, int beginIndex, int target, List<Integer> combination, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        // 我认为，想象成tree，从顶层往leaf找
        for (int i = beginIndex; i < candidates.length; i++){
            if (candidates[i] > target)
                break;
            if (i != beginIndex && candidates[i] == candidates[i-1])
                continue;

            combination.add(candidates[i]);
            helper(candidates, i, target-candidates[i], combination, result);

            //递归条件不满足，返回上一步继续递归 （这个必须有！！！）,就是删除刚刚加入到combination里面的那个node，换别的path继续走。
            combination.remove(combination.size()-1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));


    }
}
