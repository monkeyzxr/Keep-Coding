/**
 * Created by monkeyzxr on 2017/7/20.
 *
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.

 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.

 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */

//细节实现题。
// 注意word的定义为前后有分隔的一段连续非空格字符。
// 分隔可以是空格，也可以是字符串的前后边界。
// 从后向前扫，根据空格逐个记录word，并反转append到结果中。
public class LC_151_ReverseWordsinaString {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length-1; i >= 0; i--){
            if (!arr[i].equals(""))
                sb.append(arr[i]).append(" ");
        }

        //remove last " "
        if (sb.length() == 0)
            return "";

        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("1   2  3 "));


    }
}
