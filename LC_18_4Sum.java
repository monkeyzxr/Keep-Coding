import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/5.
 *
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
 ]
 *
 */

//http://www.jiuzhang.com/solutions/4sum/
public class LC_18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++){  //循环a,b,c,d里面的一个数，例如a
            if (i != 0 && nums[i] == nums[i-1])
                continue;    //直接进入下一次循环。略过重复的数, 只取一次的a，来验证。

            for (int j = i+1; j < nums.length-2; j++){   //用一个内循环来确定 第二个数，例如b
                if (j !=i+1 && nums[j] == nums[j-1])
                    continue;

                int left = j+1;  //第三个数
                int right = nums.length-1;  //第四个数

                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target){
                        left++;
                    }
                    else if (sum > target){
                        right--;
                    }
                    else {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);

                        res.add(tmp);

                        left++;   //找到了一个结果后，指针要继续走。继续找其他的可能的结果。
                        right--;


                        //这里写的和 3sum不一样。因为这里是先left++和right--了，所以while里面的验证和3sum不一样：
                        while (left < right && nums[left] == nums[left-1])  //处理左 右端若有重复的数
                            left++;

                        while (left < right && nums[right] == nums[right+1])
                            right--;
                    }
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(test, 0));

    }
}
