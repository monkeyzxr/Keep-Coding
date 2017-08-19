/**
 * Created by monkeyzxr on 2017/8/18.
 *
 Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 where the two words do not share common letters.

 You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 *
 */

//题目大意：
//给定一个字符串数组words，寻找length(words[i]) * length(words[j])的最大值，其中两个单词不包含相同字母。你可以假设每一个单词只包含小写字母。如果不存在这样的两个单词，返回0。

//http://www.cnblogs.com/grandyang/p/5090058.html
//http://www.programcreek.com/2014/04/leetcode-maximum-product-of-word-lengths-java/
    //用到了 bit操作
public class LC_318_MaximumProductWordLengths {
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int [] arr = new int[words.length];
        for (int i = 0; i < words.length; i++){  //把每一个word的字母，是否出现，放到arr里
            for (int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                arr[i] = arr[i] | (1 << (c - 'a')); //我们自定义，如果某字符出现，该bit置1，否则置0. 用or，因为只要字母出现一次，就设置为1
            }
        }

        int result = 0;

        for (int i = 0; i < words.length; i++){  //两两word之间 比较
            for (int j = i+1; j < words.length; j++){
                if ((arr[i] & arr[j]) == 0){  //如果两个word 之间 没有重叠的字母：即 & 为零
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));

    }
}
