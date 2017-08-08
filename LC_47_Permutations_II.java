import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/7.
 *
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
     [1,1,2],
     [1,2,1],
     [2,1,1]
 ]
 *
 */


/*
https://www.tianmaying.com/tutorial/LC47

以样例为例，[1,1,2]这样的排列会被遍历到许多次，这就导致最后输出的答案存在着重复。

那么如何解决这样的重复呢？

我们先看看这样的重复是如何产生的，不难发现，[1,1,2]在之前描述的回溯中会枚举2次。
如果不用数值而是用这个数在nums中的下标来表示的话，[1,1,2]被枚举的两次分别是[0,1,2]和[1,0,2]，即下标为0的“1”和下标为1的“1”在枚举的过程中被考虑成了两个不同的选择，但是在最后的答案中却没有什么不同。

而这样产生的重复也非常好解决，就是对于一个位置的同一个取值，只枚举一次，
也就是说如果已经在第1个位置上枚举了“1”这个数字，那么即使之后仍然有“1”的取值，也都跳过不进行枚举。

在实际的实现中，我们不妨这样枚举，即将nums数组排序后，只有nums[i]不等于nums[i+1]时，才将nums[i]视作一种可能的取值

特别的，当加入了used[]数组用于判断一个数字是否被使用过之后，由于每次使用的一定是所有相同数字中最右侧的一个，
所以对于一个取值，如果它右侧的数字是已经被使用过了的，就同样说明这个数是当前所有相同数字中最右侧的可用的了
 */

//http://www.jiuzhang.com/solutions/permutations-ii/
public class LC_47_Permutations_II {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null)
            return result;

        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);  // 本题一定要 把数组排序

        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];

        for (int v : visited){  //flag 初始化
            v = 0;
        }

        helper(result, list, visited, nums);

        return result;
    }

    public static void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] visited, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0)){
                continue;   //先排序，每次使用的一定是所有相同数字中最右侧的一个
            }
            visited[i] = 1;

            list.add(nums[i]);
            helper(res, list, visited, nums);
            list.remove(list.size()-1);  //回溯到上一层
            visited[i] = 0;   //把flag的值复原！！！！！！！！！！！！！！！
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));

    }
}
