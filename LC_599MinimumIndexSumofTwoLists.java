import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/2.
 *
 Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum.

 If there is a choice tie between answers, output all of them with no order requirement.

 You could assume there always exists an answer.

 Example 1:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".

 Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

 Note:
 The length of both lists will be in the range of [1, 1000].
 The length of strings in both lists will be in the range of [1, 30].
 The index is starting from 0 to the list length minus 1.
 No duplicates in both lists.
 *
 *
 */


//http://www.jianshu.com/p/e52ea70bdacc
//思路是，如果遇到index sum相同的饭店，就保存起来；如果遇到index sum更小的饭店，就把这个res清空，更新minSum，重新开始保存。

import java.util.*;
public class LC_599MinimumIndexSumofTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++){       //hashmap保存list1的String和index
            map1.put(list1[i], i);
        }

        List<String> result = new LinkedList<>(); //用linkedlist来保存返回的结果

        int minSumIndex = list1.length + list2.length - 2;  //或者是30+30

        for (int i = 0; i < list2.length; i++){   //历遍list2
            if (map1.containsKey(list2[i])){         //check list2里面有没有list1的element
                int list1index = map1.get(list2[i]);
                if (list1index + i == minSumIndex){
                    result.add(list2[i]);           //如果index的sum，等于当前最小sum值，就都加到result的list中。
                }
                else
                    if (list1index + i < minSumIndex){   // 如果index的sum，小于当前的sum值，就把result list清空。把新结果加入。
                    minSumIndex = list1index + i;
                    result.clear();
                    result.add(list2[i]);
                    }

            }
        }
        //String[] arr = list.toArray(new String[list.size()]);  // 怎样把 list 转化成 array！！！！记住了！

        String[] resultArray = result.toArray(new String[result.size()]);
        return resultArray;
    }

    public static void main(String[] args) {
        String[] test1_list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] test1_list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(test1_list1,test1_list2)));

        String[] test2_list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] test2_list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(test2_list1,test2_list2)));

        String[] test3_list1 = {"Shogun", "KFC", "Burger King"};
        String[] test3_list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(test3_list1,test3_list2)));
    }
}
