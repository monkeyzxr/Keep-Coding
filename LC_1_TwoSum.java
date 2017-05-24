import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/5/22.
 *
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 */


// 我写：不够效率。 o(n^2) which is not fast enough compare to the posted O(n) running time。
//方法1：
/*
public class LC_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0 ; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        return result;
    }

    public static void main(String[] args){
        int[] test = {2,7,11,9};
        int[] res = twoSum(test,9);
        System.out.println(Arrays.toString(res));  // how to print an array!!

    }
}
*/

// 方法2：
// 那么只能想个O(n)的算法来实现，整个实现步骤为：先遍历一遍数组，建立map数据，然后再遍历一遍，开始查找，找到则记录index。

public class LC_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);  // 生成一个map，array的值作为map的key，array的index作为map的value

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i){  //满足：map存在diff作为key。同一个array的值不能用第二次。
                                                             // 例如：test2中，3+3 = 6 不能用。要用2 + 4 = 6！！！
                result[0] = i;
                result[1] = map.get(diff);
                break;     //一旦找到满足条件，马上终止这个loop .！ ！因为题目假定了只有一个结果。
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] test1 = {2,7,11,9};
        int[] res1 = twoSum(test1,9);
        System.out.println(Arrays.toString(res1));  // how to print an array!!

        int[] test2 = {3,2,4};
        int[] res2 = twoSum(test2,6);
        System.out.println(Arrays.toString(res2));  // how to print an array!!

        int[] test3 = {3,2,4,2,4};
        // 生成map时候，2和4对应的value都会被重制一次。本来2对应1（index），变成了2对应3。
        // 如果节点已经存在就替换old value(保证key的唯一性)
        int[] res3 = twoSum(test3,6);
        System.out.println(Arrays.toString(res3));  // how to print an array!!

    }
}