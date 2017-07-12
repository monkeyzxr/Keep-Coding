import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/11.
 *
 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]


 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]

 */

//回溯法!!!!!!!!!!!!
//题目大意：寻找所有满足k个数之和等于n的组合，只允许使用数字1-9，并且每一种组合中的数字应该是唯一的。
    //http://www.programcreek.com/2014/05/leetcode-combination-sum-iii-java/
    //http://www.bkjia.com/ASPjc/1047677.html
public class LC_216_CombinationSum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(result, curr, k, 1, n);
        return result;

    }

    public static void helper(List<List<Integer>> result,
                       List<Integer> curr,
                       int k,
                       int start,
                       int sum){

        if (sum < 0)
            return;

        if (sum == 0 && curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= 9; i++){
            curr.add(i);
            helper(result, curr, k, i+1, sum-i);
            curr.remove(curr.size()-1); //这里不明白？？？？？？？？？？
        }


    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));

    }
}
