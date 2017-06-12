import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.

 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True

 Example 2:
 Input: "PPALLL"
 Output: False
 *
 */


//我自己写：
public class LC_551_StudentAttendanceRecordI {
    public static boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int countA = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 'A')
                countA++;    //计算A的个数

            if (arr[i] == 'L' && i+2 < arr.length){   //碰见第一个L，要验证后面2个是不是也是L
                if (arr[i+1] == 'L' && arr[i+2] == 'L')
                    return false;
            }
        }

        if (countA > 1)
            return false;

        return true;

    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
        System.out.println(checkRecord("AA"));
        System.out.println(checkRecord("LL"));
        System.out.println(checkRecord("PLALPL"));





    }
}
