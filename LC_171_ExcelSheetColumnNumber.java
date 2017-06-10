/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
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

//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/


//我自己写：
public class LC_171_ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int res = 0;
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--){
            int currCharValue = s.charAt(i) - 'A' + 1;     // Z - A = 25: 26个字母，中间共有25个间隔！！
            res += currCharValue * Math.pow((double)26,(double)j);
            j++;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("BA"));


    }
}
