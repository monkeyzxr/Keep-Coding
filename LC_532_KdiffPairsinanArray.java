/**
 * Created by monkeyzxr on 2017/5/23.
 *
 Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.

 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).

 Note:
 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].
 */
import java.util.HashMap;


//思路：每个pair(a,b)，其中a<=b，a-b=k。
// 可以看到只要确定了a和k，就可以找到b，
// 并且为了保证pair的唯一性，找到b以后，b不能再作为其他pair的右半部分 （看test5）
//也就是，一旦b被使用了一次，就不能再有pair用b当作右半边了。不然是同一个pair。

public class LC_532_KdiffPairsinanArray {
    public static int findPairs(int[] nums, int k) {
        if(k < 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if((map.containsKey(nums[i]+k)) && (map.get(nums[i]+k)!= i)){ //后半截，保证不能出现（a，a）
                map.remove(nums[i]+k);  //删除的是map ，array还是存在的
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]test1 = {3, 1, 4, 1, 5};
        System.out.println(findPairs(test1,2));

        int[]test2 = {1, 2, 3, 4, 5};
        System.out.println(findPairs(test2,1));

        int[]test3 = {1, 3, 1, 5, 4};
        System.out.println(findPairs(test3,0));

        int[]test4 = {1, 2, 3, 4, 5};
        System.out.println(findPairs(test4,-1));

        int[]test5 = {1, 1, 1, 2, 1};
        System.out.println(findPairs(test5,1));

    }


}
