import java.util.PriorityQueue;

/**
 * Created by monkeyzxr on 2017/8/30.
 *
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */

//https://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
//We can use a min heap to solve this problem.
// The heap stores the top k elements. Whenever the size is greater than k, delete the min.
public class LC_215_KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //natural ordering,就是由小到大
        for (int i : nums){
            pq.offer(i);

            if (pq.size() > k){
                pq.poll(); //Retrieves and removes the head of this queue,就是删除root
            }
        }

//我们使用最小堆，每次堆的size() > k的话就poll()，最后堆顶元素就是第k大的，堆内其他元素都比堆顶元素大。
        return pq.peek();


    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));

    }
}
