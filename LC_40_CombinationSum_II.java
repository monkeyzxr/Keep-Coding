import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/6.
 *
 Given a collection of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
 ]

 *
 */

//http://www.jiuzhang.com/solutions/combination-sum-ii/
    //和第39题很想，只不过Each number in C may only be used once in the combination.
    //回溯法
public class LC_40_CombinationSum_II {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return results;

        Arrays.sort(candidates);  //array要进行排序

        List<Integer> list = new ArrayList<>();

        helper(candidates, 0, list, target, results);

        return results;
    }

    public static void helper(int[] candidates, int startIndex, List<Integer> list, int target, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            // each time start from different element。作用于已经sort的array，在主程序里，要sort array。
            if (i != startIndex && candidates[i] == candidates[i-1])
                continue;

            if (target < candidates[i])
                break;

            list.add(candidates[i]);

            //下一次递归，startIndex要从i+1开始，因为每一个element只能用一次。这里和第39题不一样
            helper(candidates, i+1, list, target-candidates[i], res);

            list.remove(list.size()-1);  //回溯到上一层

        }
    }


    public static void main(String[] args) {
        int[] test = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(test, 8));

    }
}
