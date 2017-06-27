import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/26.
 *
 Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 */

//用二分法：
    //http://blog.csdn.net/xujian_2014/article/details/50553830
public class LC_34_SearchforaRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

     //   if (nums == null || nums.length == 0)
     //       return result;
        int start = 0;
        int end  = nums.length - 1;

        while (start <= end){
            int mid = (start + end)/2;
            int midValue = nums[mid];

            if (midValue == target){
                //找到目标值后，先搜索其左边有没有与目标值相等的数，取其最左边的索引值放入result中
                int leftIndex = mid;
                while ((leftIndex-1) >= 0 && nums[leftIndex-1] == target)
                    leftIndex--;
                result[0] = leftIndex;

                //同理找右边的index
                int rightIndex = mid;
                while ((rightIndex+1) < nums.length && nums[rightIndex+1] == target)
                    rightIndex++;
                result[1] = rightIndex;

                return result;  //这里必须要又返回！ 不然无限循环。就是说，找到结果了，就返回，不然while一直在循环，但无显示结果

            }
            else if (target < midValue)
                end = mid - 1;

            else
                start = mid =1;
        }

        return result;


    }

    public static void main(String[] args) {
        int[] test = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(test, 8)));

    }
}
