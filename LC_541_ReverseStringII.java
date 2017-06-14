/**
 * Created by monkeyzxr on 2017/6/12.
 *
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */

//给定一个字符串和一个整数k，每2k个字符翻转前k个字符。
// 如果剩余字符不足k个，则全部翻转。
// 如果剩余字符在k到2k之间，则翻转前k个字符，剩余字符保持原样。

    //http://blog.csdn.net/zhouziyu2011/article/details/61616307
public class LC_541_ReverseStringII {
    public static String reverse(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++){
            result = s.charAt(i) + result;
        }
        return result;
    }


    public static String reverseStr(String s, int k) {
        int len = s.length();
        String result = "";

        for (int i = 0; i < len; i = i+2*k){  //每2k的string 劈开  // i为每一段的第一位

            if (i+k > len){//如果i+k，超出了len长度，即：如果剩余字符不足k个 ,则，从i到末尾的sub-string全reverse
                String tmp = reverse(s.substring(i,len));  //注意：substring（begin，end）的end不包括进去
                result += tmp;
            }

            else if (i + k <= len && i + 2*k > len){// 如果i+k 没超出len的长度，但是i+2k超出了len的长度
                //只翻转前k个，剩余的不变
                String tmp  = reverse(s.substring(i, i+k));
                result +=  tmp + s.substring(i+k, len);
            }

            else {
                String tmp = reverse(s.substring(i, i+k));
                result +=  tmp + s.substring(i+k, i + 2*k);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));

    }
}
