import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by monkeyzxr on 2017/5/24.
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 */

//方法1；我写，用hashmap
    /*
public class LC_217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,5};
        System.out.println(containsDuplicate(test1));

        int[]test2 = {1,2,3,3,4,5};
        System.out.println(containsDuplicate(test2));
    }
}
*/

//方法2：用hashset

public class LC_217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if (!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,5};
        System.out.println(containsDuplicate(test1));

        int[]test2 = {1,2,3,3,4,5};
        System.out.println(containsDuplicate(test2));
    }
}


//方法3：把array 排序，比较相邻两个数字是否相等
    /*
public class LC_217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,5};
        System.out.println(containsDuplicate(test1));

        int[]test2 = {1,2,3,3,4,5};
        System.out.println(containsDuplicate(test2));
    }
}
*/

