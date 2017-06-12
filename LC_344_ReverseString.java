/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */


//我写：

public class LC_344_ReverseString {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >=0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
        System.out.println(reverseString("hello"));
        System.out.println(reverseString(" "));

    }
}
