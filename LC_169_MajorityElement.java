import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/6/1.
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 */

//我自己写：用hashmap
public class LC_169_MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); //hashmap存：key为array的element，value为element出现的次数。
        double threshold = Math.floor((double)nums.length/2);

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]))       //构建hashmap
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i],1);

            if (map.get(nums[i]) > threshold)   //验证
                return nums[i];
        }
        return -99;   //如果无结果，就返回-99。但是题目设定了，一定有结果。
    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,5,2,2,2,2};
        System.out.println(majorityElement(test1));

        int[]test2 = {1,2,3,4,5,2,2};
        System.out.println(majorityElement(test2));

        int[]test3 = {6};
        System.out.println(majorityElement(test3));
    }
}


// 网上其他做法：
//有一个比较巧妙的思路是，就是不断将数组中两两不同的数同时去除，极端情况是每个其他数值都与一个数量最多的数同时去除，
// 即使这样，最后剩下的数值也是那个数量超过总数一半的数值。
//https://shenjie1993.gitbooks.io/leetcode-python/169%20Majority%20Element.html

//http://www.programcreek.com/2014/02/leetcode-majority-element-java/

//http://blog.csdn.net/DERRANTCM/article/details/47902549