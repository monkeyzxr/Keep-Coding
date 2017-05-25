import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/5/24.
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */

//我写： Wrong！
    /*
public class LC_219_ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],i);

        for (int i = 0 ; i < nums.length; i++){
            int index = map.get(nums[i]);
            if(map.containsKey(nums[i]) &&  index != i){
                if(Math.abs(i-index) < k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,3,5};
        System.out.println(containsNearbyDuplicate(test1,10));

        int[]test2 = {1,2,3,4,5,3};
        System.out.println(containsNearbyDuplicate(test2,3));
    }
}
*/

public class LC_219_ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                if(i - preIndex <= k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;

    }

    public static void main(String[] args) {
        int[]test1 = {1,2,3,4,3,5};
        System.out.println(containsNearbyDuplicate(test1,10));

        int[]test2 = {1,2,3,4,5,3};
        System.out.println(containsNearbyDuplicate(test2,3));

        int[]test3 = {-1,-1};
        System.out.println(containsNearbyDuplicate(test3,1));
    }
}