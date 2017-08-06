/**
 *
 * Created by monkeyzxr on 2017/8/4.
 *
 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 *
 */

//输入数组是有序的，让我们在O(log n)的时间内完成计算，看到这个时间复杂度，应该有很敏锐的意识应该用二分查找法
//我们最先初始化left和right为0和数组长度len-1，然后取中间值mid，比较citations[mid]和len-mid做比较，
// 如果前者大，则right移到mid之前，反之right移到mid之后，终止条件是left>right，最后返回len-left即可

    //http://www.cnblogs.com/grandyang/p/4782695.html
public class LC_275_HIndex_II {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        int len = citations.length;
        int left = 0;    //输入的数组 是有序的了。 升序
        int right = len-1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (citations[mid] == len-mid)   //找mid对应的数 和 len-mid 之间的关系
                return len-mid;
            else if (citations[mid] < len-mid)
                left = mid + 1;  //此时为了让 citation增加，index要在右半边里面找
            else
                right = mid - 1;
        }

        return len - left;


    }

    public static void main(String[] args) {

    }
}
