import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by monkeyzxr on 2017/7/20.
 *
 Given a list of strings, you need to find the longest uncommon subsequence among them.
 The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

 A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements.
 Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

 The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
 If the longest uncommon subsequence doesn't exist, return -1.

 Example 1:
 Input: "aba", "cdc", "eae"
 Output: 3
 Note:

 All the given strings' lengths will not exceed 10.
 The length of the given list will be in the range of [2, 50].
 *
 */

//http://blog.csdn.net/zshouyi/article/details/71247703
    //http://www.cnblogs.com/grandyang/p/6680548.html
    /*
    遍历所有的字符串，对于每个遍历到的字符串，再和所有的其他的字符串比较，看是不是某一个字符串的子序列，
    如果都不是的话，那么当前字符串就是一个非共同子序列，用其长度来更新结果res
     */
public class LC_522_LongestUncommonSubsequence_II {
    public static int findLUSlength(String[] strs) {
        /*
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();  //按照String的长度，descending排序，由长到短排序
            }
        });
*/
        int res = -1;
        int j = 0; //必须放外面

        for (int i = 0; i < strs.length; i++){
            for (j = 0; j < strs.length; j++){
                if (i == j)
                    continue;

                if (checkSubString(strs[i], strs[j])) //如果 str i 是str j的sub-sequence，则不是uncommon subsequence，退出循环
                    break;
            }
            //如果j一直循环下去，循环到strs结束，即里便利strs数组里的素有String，没有被break，则说明strs【i】是一个 非公共的subsequence
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }

        return res;

    }

    //subs:  abc
    //str:  a1111b222c33
    public static boolean checkSubString(String subs, String str){
        int i = 0;
        for (char c : str.toCharArray()){
            if (c == subs.charAt(i))
                i++;

            if (i == subs.length())
                break;
        }
        return i == subs.length();

    }

    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(findLUSlength(strs));

    }
}
