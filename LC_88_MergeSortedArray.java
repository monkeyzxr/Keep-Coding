import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/31.
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.

 */

//注意：https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/88md.html
        //nums1會有有足夠的空間可以塞入兩個陣列(nums1.length = m+n)，m為nums1的元素數量，n為nums2的元素數量
        //範例： nums1 = [1,1,2,4,6,null,null,null], m = 5, nums2 = [2,3,7], n = 3
        //合併後 nums1 = [1,1,2,2,3,4,6,7]

  //  這題可以分成兩個步驟就會變得很簡單，先把nums2的值放到nums1裡面
          //  ex. nums1 = [1,2,6,null,null] , nums2 = [4,5] --> [1,2,6,4,5]
          //  然後將nums1裡面的元素重新排序 [1,2,4,5,6]
    // 我觉得这个方法违规了，不能用。
//////////////////////////////////////
/////////////////////////////////////


//思路：从后往前填空。
// The key to solve this problem is moving element of A and B backwards.
// If B has some elements left after A is done, also need to handle that case.

    //http://www.cnblogs.com/anne-vista/p/4848342.html
    //http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
  //http://bangbingsyb.blogspot.com/2014/11/leetcode-merge-sorted-array.html
public class LC_88_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while(i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[index--] = nums1[i--];   //先赋值，再递减。只能这样写index--，不能写--index！
            else
                nums1[index--] = nums2[j--];
        }

        while (j >= 0){   //此时，为了防止nums1已经历遍完了，但是nums2还剩余element没有历遍。直接把剩下的nums2插入到nums1上。
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
      //  int[] nums1 = {1,1,2,4,6,null,null,null};
        int[] nums1 = new int[8];
        nums1[0] = 1;
        nums1[1] = 1;
        nums1[2] = 2;
        nums1[3] = 4;
        nums1[4] = 6;

        int[] nums2 = {2,3,7};
        merge(nums1,5,nums2,3);

        System.out.println(Arrays.toString(nums1));  //[1, 1, 2, 2, 3, 4, 6, 7]
    }
}
