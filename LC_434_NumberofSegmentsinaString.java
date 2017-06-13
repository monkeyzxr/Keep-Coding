/**
 * Created by monkeyzxr on 2017/6/12.
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5

 */


//可能两个单词之间有多个空格
public class LC_434_NumberofSegmentsinaString {
    public static int countSegments(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i++){

            //看当前位置不是空格时：
            if (arr[i] != ' '){
                if (i == 0)  //如果第一个不是空格
                    count++;
                else if (i !=0 && arr[i-1] == ' ')
                    count++;
            }

        }
        return count;


    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("a        b"));
        System.out.println(countSegments("ab"));
        System.out.println(countSegments("                "));
        System.out.println(countSegments("                a"));
        System.out.println(countSegments("a                "));

    }

}
