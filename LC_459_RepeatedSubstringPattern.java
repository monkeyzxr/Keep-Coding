/**
 * Created by monkeyzxr on 2017/6/24.
 *
 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"
 Output: True
 Explanation: It's the substring "ab" twice.

 Example 2:
 Input: "aba"
 Output: False

 Example 3:
 Input: "abcabcabcabc"
 Output: True
 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */

//思路是： 找出所有的子串，然后判断这个子串是否可以拼接处最终的字符串.
    //既然能拆分成多个子串，那么每个子串的长度肯定不能大于原字符串长度的一半
    /*
public class LC_459_RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1)
            return false;

        for (int i = 1; i <= s.length()/2; i++){
            if (s.length()%i != 0)  //如果是能重复的子字符串，一定是能被总长度整除的
                continue;

            String pattern = s.substring(0, i);
            System.out.println(pattern);

            StringBuilder sb = new StringBuilder(pattern);
            int j = 1;

            while (j < s.length()/i){
                sb.append(pattern);
                j++;
            }
           // System.out.println(sb);
            if (sb.equals(s))
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
      //  System.out.println(repeatedSubstringPattern("aba"));
       // System.out.println(repeatedSubstringPattern("abcabcabcabc"));


    }
}
*/

    //重新写，结果正确，但是超时！
    /*
public class LC_459_RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1)
            return false;

        for (int i = 1; i <= s.length()/2; i++){
            if (s.length()%i != 0)  //如果是能重复的子字符串，一定是能被总长度整除的
                continue;

            String pattern = s.substring(0, i);
            String t = "";
            for (int j = 0; j < s.length()/i; j++){
                t += pattern;
            }

            if (t.equals(s))
                return true;



        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
          System.out.println(repeatedSubstringPattern("aba"));
         System.out.println(repeatedSubstringPattern("abcabcabcabc"));


    }
}
*/

    //http://www.cnblogs.com/grandyang/p/6087347.html
    //再重新写，循环从大的往小的走. 正确
    /*
The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for length/2
If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true
     */
public class LC_459_RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1)
            return false;

        for (int i  = s.length()/2; i >= 1; i--){
            if (s.length() % i == 0){
                String sub = s.substring(0, i);
                int times = s.length()/i;
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < times; j++){
                    sb.append(sub);  //sb一直append 子序列
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;



    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));


    }
}