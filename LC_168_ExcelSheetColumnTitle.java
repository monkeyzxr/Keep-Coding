/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 *
 */


//思路：

/**
 A   1     AA    26+ 1     BA  2×26+ 1     ...     ZA  26×26+ 1     AAA  1×26²+1×26+ 1
 B   2     AB    26+ 2     BB  2×26+ 2     ...     ZB  26×26+ 2     AAB  1×26²+1×26+ 2
 .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
 .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
 .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
 Z  26     AZ    26+26     BZ  2×26+26     ...     ZZ  26×26+26     AAZ  1×26²+1×26+26
 */

/**
 * Now we can see that ABCD＝A×26³＋B×26²＋C×26¹＋D＝1×26³＋2×26²＋3×26¹＋4
 *
 */

//https://discuss.leetcode.com/topic/6245/python-solution-with-explanation
//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/

    //把这个想像成26进制。和10进制类比一下。

public class LC_168_ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (n <= 0)
            return null;

        StringBuilder sb = new StringBuilder();// String是不能改变的，所以要用StringBuilder

        while(n > 0){
            n = n-1;  //因为A是从1开始，不是从0开始。例如C = 3。  3%20 =3， 3+A = D。所以（3-1）+ A 才等于C。
            char c = (char)(n%26 + 'A');
            n = n/26;    //例如AB。第一次循环得到了B，n= 28 ／26 = 1。继续循环，n= 1-1 = 0, char = 0%26 +A = A。得到了A。

            sb.append(c);
        }

        sb.reverse(); //得到的String要反转才是结果。例如ABCD，第一次循环得到char是D，sb中先插入了D。
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }


}
