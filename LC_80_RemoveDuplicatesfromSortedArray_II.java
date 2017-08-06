/**
 * Created by monkeyzxr on 2017/8/5.
 *
 Follow up for "Remove Duplicates":   第26题
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
 *
 *
 */

//题目说，给定的array是已经sorted的了。
//我自己写，和第26题差不多，快慢连个指针
public class LC_80_RemoveDuplicatesfromSortedArray_II {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int pSlow = 1;
        for (int i = 2; i < nums.length; i++){  //i 就是p_Fast的指针。因为可以允许2次重复，所以i从第2个index开始loop
            if (nums[i] == nums[pSlow-1]) {   // 1 1 1 2 2 3
                continue;
            }
            else if (nums[i] != nums[pSlow-1]){
                pSlow++;
                nums[pSlow] = nums[i];
            }
        }

        return pSlow+1;

    }

    public static void main(String[] args) {


    }
}
