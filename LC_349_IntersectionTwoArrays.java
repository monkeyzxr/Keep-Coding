import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/2.
 *
 * Given two arrays, write a function to compute their intersection.（交集）

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 *
 */


//我写：
public class LC_349_IntersectionTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);                 // set存放nums1 array，数值unique。
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])){
                resultSet.add(nums2[i]);       //resultSet 存放交集，数值unique。
            }
        }

       // Integer[] result = resultSet.toArray(new Integer[resultSet.size()]);
        int[]result = new int[resultSet.size()];
        int i = 0;

        Iterator<Integer> iter = resultSet.iterator();
        while (iter.hasNext()){
            result[i++] = iter.next();
        }

        //for (Integer num : resultSet) {     或者这么历遍resultSet
        //    result[i++] = num;
        //}

        return result;
    }

    public static void main(String[] args) {
        int[]nums1 = {1, 2, 2, 1};
        int[]nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}
