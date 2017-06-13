import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/12.
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 *
 */

//我写，正确。类似350题

public class LC_383_RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr_magazine = magazine.toCharArray();

        for (char c : arr_magazine){   //把 magazine的字母的个数放到map里
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }

        char[] arr_ransomNote = ransomNote.toCharArray();

        for (char c : arr_ransomNote){
            if (!map.containsKey(c))
                return false;

            if (map.get(c) <= 0)  // 这里if必须先验证个数  //下一个if才能个数减1
                return false;

            if (map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c)-1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
