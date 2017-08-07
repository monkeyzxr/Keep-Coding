/**
 * Created by monkeyzxr on 2017/8/6.
 *
 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").

 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False

 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 *
 */

/*
http://www.cnblogs.com/hellowooorld/p/6789889.html
思路就是：观察字符串s1和s2，如果s1的全排列是s2的子串，则s1的所有字符均出现在s2中，而且这些字符连续。

于是用一个类似于滑动窗口的区间去统计此区间内的字符，区间的长度取为s1的长度。

如果在s2中存在一个区间，里面的字符与s1的字符全部都一样，则说明s1通过全排列后一定能够得到s2中的子串。也即满足题意。
 */
public class LC_567_PermutationinString {
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2)
            return false;

        int[] count = new int[26];

        for (int i = 0; i < len1; i++){  //一个len1长度的滑块，在count的数组里，加加s1的字母统计个数，减减s2的字母统计个数
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (checkAllZeros(count)) //如果count里面的每个字母个数都是零，则找到了一个结果
            return true;

        for (int i = len1; i < len2; i++){  //继续从len1之后的 S2上滑动
            count[s2.charAt(i) - 'a']--; //滑块最右的字母，加入到count里，因此对应的count从s1的统计字母的个数里 减掉
            count[s2.charAt(i-len1) - 'a']++; //滑块最左端的字母，从滑块里去掉了

            if (checkAllZeros(count))
                return true;
        }
        return false;
    }

    public static boolean checkAllZeros(int[] count){
        for (int i = 0; i < 26; i++){
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));

    }
}
