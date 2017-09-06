import java.util.*;

/**
 * Created by monkeyzxr on 2017/9/5.
 *
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3
 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 *
 */

//好图示：
//https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation
//Basic idea: Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the data structure.
//Some observations: For every numbers in nums1, its best partner(yields min sum) always strats from nums2[0] since arrays are all sorted;
// And for a specific number in nums1, its next candidate sould be [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)

//http://blog.csdn.net/qq508618087/article/details/51864835

    //我觉得挺对的，但是leetcode报错
public class LC_373_FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[nums1.length][nums2.length];

        //构建min-heap，存放最小num1与num2之和的 index array
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {//heap里存放的的数据结构int[]，是2个元素大小的数组，代表index
            @Override
            public int compare(int[] o1, int[] o2) { //o1,o2 代表 两组不同的index。 o1和o2各自有两个元素。
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);  //升序，因此是min-heap
            }
        });

        heap.add(new int[]{0,0});  //把nums1的第0位，num2的第0位，加进heap
        visited[0][0] = true;

        while (!heap.isEmpty() && result.size() < k){
            int index[] = heap.poll(); //第一个元素来自sum1的index，第二个元素来自sum2的index
            result.add(new int[]{nums1[index[0]], nums2[index[1]]});

            if (index[1] + 1 < nums2.length && visited[index[0]][index[1]+1] == false){
                heap.add(new int[]{index[0], index[1]+1});
                visited[index[0]][index[1]+1] = true;
            }

            if (index[0] + 1 < nums1.length && visited[index[0]+1][index[1]] == false){
                heap.add(new int[]{index[0]+1, index[1]});
                visited[index[0]+1][index[1]] = true;

            }

        }

        return result;










    }

    public static void main(String[] args) {

    }
}
