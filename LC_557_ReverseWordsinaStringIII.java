/**
 * Created by monkeyzxr on 2017/6/13.
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 */

//熟练String API的使用：
    /*

public class LC_557_ReverseWordsinaStringIII {

    public static String reverseWords(String s) {
        String[] arrs = s.split(" ");

        StringBuilder result = new StringBuilder();

        for (String arr : arrs){
            StringBuilder sb = new StringBuilder(arr);
            result.append(sb.reverse() + " ");
        }

        //把最后一个空格删掉
        return result.toString().substring(0, result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
*/

    //方法2：不用split
public class LC_557_ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        s = s + " "; //s末尾放一个空格，为了循环能够停止
        char[] arrs = s.toCharArray();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : arrs){
            if (c != ' ')
                word.append(c);

            else {
                result.append(word.reverse() + " ");
                word = new StringBuilder();
            }
        }

        return result.toString().trim();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}