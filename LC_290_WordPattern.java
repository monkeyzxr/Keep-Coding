import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/6/2.
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 */
import java.util.*;

//http://blog.csdn.net/xudli/article/details/48932055
// 我写：
public class LC_290_WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");

        if (pattern.length() != word.length)   //input check
            return false;

        Map<Character, String> map = new HashMap<>();  //map的key存放pattern的char，value存放String的单词
        Set<String> set = new HashSet<>();   //set 用来验证新char对应的单词，是不是已经存在过了。如果存在了，false。见例子4。

        for (int i  = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(word[i])){   //如果map key已经存在了当前char，如果map里char对应的单词和当前的单词不同，false。
                    return false;
                }
            }

            //map的key里没有char c
            else{
                if(set.contains(word[i]))  //如果set里已经存在当前这个单词了，就是false。看test例子4。
                    return false;

                set.add(word[i]);
                map.put(pattern.charAt(i), word[i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
