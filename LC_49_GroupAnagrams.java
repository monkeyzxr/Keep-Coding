import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/21.
 *
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
   ["ate", "eat","tea"],
   ["nat","tan"],
   ["bat"]
 ]
 Note: All inputs will be in lower-case.
 *
 */

//首先对每个string转换成char array然后排下序，HashMap里面的key存sort后的词，value存原始的词。
// 然后如果这个排好序的词没在HashMap中出现过，那么就把这个sorted word和unsortedword put进HashMap里面。
// 如果一个sorted word是在HashMap里面存在过的，则直接加入HashMap中对应的位置。
// 最后将HashMap中的每一个value都加入result中即可。

    //http://www.programcreek.com/2014/04/leetcode-anagrams-java/
public class LC_49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> map  = new HashMap<>(); //map的key为每一个单词的字母个数组成的String
                             //map 的value是Arraylist<Sting>， 存放的是 单词 String

        for (String str : strs){
            char[] arr = new char[26];

            for (int i = 0; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;  // increment the value in the array indexed by s.charAt(i) - 'a'.
                                             // counts up the number of occurrences of each letter in String str
                                             /*
                                             'A' - 'A' == 0
                                             'B' - 'A' == 1
                                             'C' - 'A' == 2
                                             比如 apple：arr[0] = 1, arr[21] = 2,.. 这里的次数，定义为char

                                              */

            }

            String ns = new String(arr); //ns是用 出现的次数的char，组成的一个String

            if (map.containsKey(ns)){
                map.get(ns).add(str);  //map.get:得到了map的value，是一个arraylist。然后.add，是list的API，用于往list中加element
            }
            else {  //如果map里没有ns这个key，也就是，遇见一个新的单词
               ArrayList<String> al = new ArrayList<>();
               al.add(str);
               map.put(ns, al);
            }
        }

        result.addAll(map.values());  //把map的value 全部加到result list里
        return result;

    }

    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test));

    }
}
