import java.util.HashSet;
import java.util.Set;

/**
 * Created by monkeyzxr on 2017/6/23.
 *
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */


//用一个hash table保存每个字符上一次出现过的位置。
// 从前往后扫描，假如发现字符上次出现过，就把当前子串的起始位置start移动到上次出现过的位置之后
// ——这是为了保证从start到i的当前子串中没有任何重复字符。
// 同时，由于start移动，当前子串的内容改变，start移动过程中经历的字符都要剔除。
public class LC_3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int start = 0;  //the start index,就是当前没有重复字母，开始的index
        int max = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i  < s.length(); i++){
            char c = s.charAt(i);

            if (!set.contains(c)){
                set.add(c);
                max = Math.max(max, i-start+1);
            }
            else { //如果此时遇见一个字母，已经出现过了
                for (int j = start; j < i; j++){
                    set.remove(s.charAt(j)); //清空之前的set

                    if (s.charAt(j) == c){
                        start = j+1;
                        break;
                    }
                 }
                 set.add(c);

            }

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));


    }

}
