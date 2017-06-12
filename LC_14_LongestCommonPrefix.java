/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Write a function to find the longest common prefix（前缀） string amongst an array of strings.
 */


//To solve this problem, we need to find the two loop conditions.
// One is the length of the shortest string.
// The other is iteration over every element of the string array.
    //http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/
public class LC_14_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        int minLen = Integer.MAX_VALUE;

        for (String s : strs){
            if (minLen > s.length())
                minLen = s.length();   //求出strs array中最短的那条Sting的长度
        }

        for (int i = 0; i < minLen; i++){  // 外循环：i来历遍每一条string的字母
            for (int j = 0; j < strs.length-1; j++){  // 内循环：j来历遍strs array中的每一条 string。注意length-1，因为s2是j+1。
                String s1 = strs[j];
                String s2 = strs[j+1];

                if (s1.charAt(i) != s2.charAt(i))
                    return s1.substring(0,i);
            }
        }

        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        String[] strs = {"abcdef", "abcdefgh", "abcdef123", "abcdefzzz"};
        System.out.println(longestCommonPrefix(strs));

    }
}
