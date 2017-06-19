import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 *
 */


//http://www.geeksforgeeks.org/?p=7953

//看网上，正负号标记
//mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
// In this way all the numbers that we have seen will be marked as negative.
//In the second iteration, if a value is not marked as negative,
// it implies we have never seen that index before, so just add it to the return list.

    //令nums[abs(i)-1]=-abs(nums[abs(i)-1])，即让每个元素所对应的下标的元素值变成一个负值。
public class LC_448_FindAllNumbersDisappearedArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0)                   // 4,3,2,7,8,2,3,1 : idx = 3, nums[3] = -nums[3] = -7
                nums[idx] = -nums[idx];
        }                                      //经过这个操作后数组变为：[-4, -3, -2, -7, 8, 2, -3, -1]

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                list.add(i+1);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] test = {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(test));

    }

}

/*

idx :  0    1    2    3    4    5    6    7
nums:  4    3    2    7    8    2    3    1
------------------------------------------------
                     -7
                 -2
            -3
                                    -3
                                          -1
      -4


 */