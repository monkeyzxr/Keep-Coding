/**
 * Created by monkeyzxr on 2017/6/11.
 *
 *
 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:
 Input: "USA"
 Output: True

 Example 2:
 Input: "FlaG"
 Output: False

 Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

//题目大意：判断一个字母是否大小写正确：要么全是大写，要么全是小写，或者首字母大写其他小写，否则不满足题意


//思路1：统计出单词中所有大写字母的个数cnt，再来判断是否属于这三种情况，
// 如果cnt为0，说明都是小写，正确；
// 如果cnt和单词长度相等，说明都是大写，正确；
// 如果cnt为1，且首字母为大写，正确，其他情况均返回false
    //http://www.cnblogs.com/grandyang/p/6512921.html


    //ASCII
    // A:65 --- Z: 90
    // a:97 ---- z : 122

public class LC_520_DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) <= 'Z')
                count++;  //计算出大写字母的个数
        }
        if(count == 0)  //如果word里没有大写字母
            return true;

        if (count == word.length()) //如果word里全部是大写字母
            return true;

        if(count == 1 && word.charAt(0) <= 'Z')  //如果只有首字母是大写
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("flAg"));
    }
}


//思路2：http://blog.csdn.net/mrbcy/article/details/62883964
//首先把word转成全大写，还有小写，然后跟它自己比较。如果相同返回TRUE
    /*
public class LC_520_DetectCapital {
    public static boolean detectCapitalUse(String word) {
        String lower = word.toLowerCase();
        if (lower.equals(word))    //如果全是小写
            return true;

        String upper = word.toUpperCase();
        if (upper.equals(word))   // 如果全是大写
            return true;

        String subStr = word.substring(1);
        return subStr.equals(subStr.toLowerCase());  //如果除了首字母，剩下的全是小写
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("flAg"));
    }
}
    */