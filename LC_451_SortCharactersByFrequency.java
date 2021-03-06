import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by monkeyzxr on 2017/6/20.
 *
 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.


 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.
 *
 */

//https://discuss.leetcode.com/topic/66024/java-o-n-bucket-sort-solution-o-nlogn-priorityqueue-solution-easy-to-understand/2
public class LC_451_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()){
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>>  pq = new PriorityQueue<>(  //相当于heap
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();  //由大向小 排序 ....第二个减第一个。记住了！！！
                    }
                }
        );

        /*
        boolean	add(E e)
                    Ensures that this collection contains the specified element (optional operation).
        boolean	addAll(Collection<? extends E> c)
                   Adds all of the elements in the specified collection to this collection (optional operation).
         */
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            Map.Entry e = pq.poll(); //Retrieves and removes the head of this queue
            for (int i = 0 ; i < (int)e.getValue(); i++){  //循环object e的次数
                sb.append(e.getKey());  //把这个字母，n次添加到sb里
            }
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));

    }
}
