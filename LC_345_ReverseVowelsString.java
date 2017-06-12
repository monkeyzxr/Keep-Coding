import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 *
 */


//http://www.programcreek.com/2015/04/leetcode-reverse-vowels-of-a-string-java/

    //我自己写：
public class LC_345_ReverseVowelsString {
    public static String reverseVowels(String s) {
      //  if (s == null || s.length() == 0)
      //      return null;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int begin = 0;
        int end = s.length()-1;

        char[] arrS = s.toCharArray();

        while (begin <= end){
            if (!set.contains(arrS[begin])){
                begin++;
                continue; // 这里必须写continue，不然S3例子报错。
            }
            if (!set.contains(arrS[end])){
                end--;
                continue; // 这里必须写continue，不然S3例子报错。
            }
            char tmp = arrS[begin];
            arrS[begin] = arrS[end];
            arrS[end] = tmp;

            begin++;
            end--;
        }

        return String.valueOf(arrS);
        //或者：
       // return new String(arrS);

    }

    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(reverseVowels(s1));

        String s2 = "leetcode";
        System.out.println(reverseVowels(s2));

        String s3 = " ";
        System.out.println(reverseVowels(s3));
    }
}
