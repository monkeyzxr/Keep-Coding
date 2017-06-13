import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 */


//类似题： 383
//http://www.jiuzhang.com/solutions/intersection-of-two-arrays-ii/
    //http://www.programcreek.com/2014/05/leetcode-intersection-of-two-arrays-ii-java/
//我自己写：
    /*
public class LC_350_IntersectionTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums1){      //map存放array nums1的 值和次数
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }

        List<Integer> list = new ArrayList<>();  //list 存放结果

        for (int i : nums2){  //历遍nums2 array
            if (map.containsKey(i) && map.get(i) > 0){  //要check map里含有的这个数的个数，是大与1的，是存在的。
                list.add(i);
                map.put(i, map.get(i)-1);  // 存在一个，map的个数就减一个。
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        while(i < list.size()){
            result[i] = list.get(i);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};

        System.out.println(Arrays.toString(intersect(num1,num2)));

    }
}
*/

    //如果array是排好序的？怎么办？

    //http://www.programcreek.com/2014/05/leetcode-intersection-of-two-arrays-ii-java/
    // 用双指针！
public class LC_350_IntersectionTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);  // 1，1，2，2
        Arrays.sort(nums2);   // 2,2

        int p1 = 0;  //p1 指向nums1
        int p2 = 0;  // p2指向nums2

        List<Integer> list = new ArrayList<>(); //存放结果

        while(p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] < nums2[p2]){
                p1++;
            }
            else if (nums1[p1] > nums2[p2]){
                p2++;
            }
            else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        while (i < list.size()){
            result[i] = list.get(i);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};

        System.out.println(Arrays.toString(intersect(num1,num2)));

    }
}


