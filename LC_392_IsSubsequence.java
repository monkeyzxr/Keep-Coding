/**
 * Created by monkeyzxr on 2017/7/11.
 *
 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t.
 t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 and you want to check one by one to see if T has its subsequence.
 In this scenario, how would you change your code?
 */

/*
给定了S和T，让你判断S是否是T的子序列，其中T会非常大，S不大

这道题做法很简单，两个指针就可以，无论如何指向T的每轮都要前进，而S的那个只有当当前指针下S和T一致的情况下才前进

记得提前转换成数组，不然超时！


 */

//http://blog.csdn.net/mebiuw/article/details/52444480
 //http://www.cnblogs.com/grandyang/p/5842033.html
public class LC_392_IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0;  //指向 s
        int j = 0;  //指向 t
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        while (i < arrS.length && j < arrT.length){
            if (arrS[i] == arrT[j]){
                i++;
                j++;
            }
            else
                j++;
        }

        //当循环结束，最终查看 i是不是走到了头
        return i == s.length();



    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));

    }
}
