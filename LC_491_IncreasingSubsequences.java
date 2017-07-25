import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by monkeyzxr on 2017/7/24.
 *
 Given an integer array, your task is to find all the 「different」 possible increasing subsequences of the given array,
 and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.

 *
 */

//回溯法：
    //http://blog.csdn.net/qq_31129455/article/details/54691351
public class LC_491_IncreasingSubsequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();  //用set，为了除去重复的结果list
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, 0);

        return new ArrayList<>(result);

    }

    public static void helper(Set<List<Integer>> result, List<Integer> sublist, int[]nums, int startIndex){
        if (sublist.size() >= 2)
            result.add(new ArrayList<Integer>(sublist));

        for (int i = startIndex; i < nums.length; i++){  //从startIndex开始循环

            //如果当前的sublist为空，或者list的最后一个数小于当前的nums【i】，则把nums【i】加入到sublist中
            if (sublist.size() == 0 || sublist.get(sublist.size()-1) <= nums[i]){
                sublist.add(nums[i]);
                helper(result, sublist, nums, i+1);
                sublist.remove(sublist.size()-1);  //回溯
                // 作用就是每次清除一个空位 让后续元素加入。寻找成功，最后一个元素要退位，寻找不到，方法不可行，那么我们回退，也要移除最后一个元素
            }
        }

    }

    public static void main(String[] args) {
        int[] test = {4, 6, 7, 7};
        System.out.println(findSubsequences(test));


    }
}
