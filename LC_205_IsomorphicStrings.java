import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by monkeyzxr on 2017/6/3.
 *
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.
 两个字母不能map到同一个字母

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 *
 */

//自己写：  思路：就是 同一个字母的map值，必须是不变的字母。如例子1，g字母要永远指向d字母。
    /*
public class LC_205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();  //构建一个map，s的字母为key，t的字母为value。就是s的字母指向t的字母。

        for (int i = 0; i < t.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if (map.containsKey(schar)){ // 如果map里有s的字母，但s字母对应的t字母，和当前的t字母不一样，则是连个不同映射关系，返回false。
                if (map.get(schar) != tchar)
                    return false;
            }

            if (!map.containsKey(schar)){  //题目要求，两个不同的字母，不能指向同一个字母。如例子4。如果a指向了a，则b不能再指向a。
                for (Character c : map.keySet()){ //此时，map里没有当前的s字母。则历遍s字母，找对应的t字母。如果map存在对应的t字母和当前的t字母相同，则false。
                    if (map.get(c) == tchar ){
                        return false;
                    }
                }
            }

            map.put(schar,tchar);  // 如果能够加到map里的映射关系，一定是已经满足题目条件的了。
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
*/

    //网上思路：比我多了一个hashset
//http://blog.csdn.net/xudli/article/details/45386777
public class LC_205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        //init check
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();

        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)) {
                if(map.get(c1) != c2)
                    return false;

            }
            else {
                if(set.contains(c2))
                    return false;  //用一个set保持 被映射的char, 保证同一个char 不会被映射两次
                else {
                    map.put(c1, c2);
                    set.add(c2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
