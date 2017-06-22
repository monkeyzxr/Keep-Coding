import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/21.
 *
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */

//http://www.jiuzhang.com/solutions/top-k-frequent-elements
    //http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/


// 我自己写，正确
public class LC_347_TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }

        //pq用于map里的次数排序
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();  //pq 里面，按照次数由大到小排列
                    }
                }
        );

        pq.addAll(map.entrySet());

        while(k != 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            list.add(entry.getKey());

            k--;

        }
        return list;

    }

    public static void main(String[] args) {
        int[] test = {1,1,1,2,2,3};
        System.out.println(topKFrequent(test, 2));

    }
}
