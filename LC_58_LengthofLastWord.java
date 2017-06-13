/**
 * Created by monkeyzxr on 2017/6/12.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 *
 */

//http://www.programcreek.com/2014/05/leetcode-length-of-last-word-java/
//We just need a flag to mark the start of letters from the end.
// If a letter starts, and the next character is not a letter, return the length.

    //从后往前数，如果当前位置是字母，其左手边不是字母，则是 最后的单词

public class LC_58_LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int result = 0;
        boolean flag = false;

        for (int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                flag = true;  //flag 代表当前位置上是个字母
                result++;
            }
            else { //如果当前位置不是字母，但是它的 右边是一个字母，则返回result
                if (flag)
                    return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World  "));
        System.out.println(lengthOfLastWord("Hello World  big      1"));


    }
}


    //方法2：
    //http://www.cnblogs.com/springfor/p/3872326.html
    /*
public class LC_58_LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int count = 0;

        for (int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);

            if (c != ' ')
                count++;

            if (c == ' ' && count != 0)
                return count;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World  "));


    }
}
    */