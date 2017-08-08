import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/7.
 *
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
 ]

 *
 */

//题意：给你两个整数 n和k，从1-n中选择k个数字的组合。比如n=4，那么从1,2,3,4中选取两个数字的组合
//http://www.jiuzhang.com/solutions/combinations/
//http://blog.csdn.net/ebowtang/article/details/50835803

public class LC_77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(result, list, n, k, 1);  //起始的数字，从1开始

        return result;

    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int startNumber){
        if (list.size() == k){  // base 条件。如果找到了一个满足条件的list，add到res里。
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = startNumber; i <= n; i++){
            list.add(i);

            // the new start should be after the next number after i
            helper(res,list, n, k, i+1);

            list.remove(list.size()-1);  //回溯到上一层
        }

    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));

    }
}
