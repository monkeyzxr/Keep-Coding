/**
 * Created by monkeyzxr on 2017/7/18.
 *
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

//这有一个很好的解释图：
//https://discuss.leetcode.com/topic/22925/if-you-are-confused-with-zigzag-pattern-come-and-see

/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/

    //每两个大的竖列，相隔的差值是2n-2

    //http://www.jiuzhang.com/solutions/zigzag-conversion/

    //没看懂 我觉得这个题不重要
public class LC_6_ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1)
            return s;

        char[] res = new char[s.length()];

        int step = 2 * (numRows-1);
        int count = 0;

        for (int i = 0; i < numRows; i++){
            int interval = step - 2*i;
            for (int j = i; j < s.length(); j += step){
                res[count] = s.charAt(j);
                count++;

                if (interval < step && interval >0 && j + interval < s.length() && count < s.length()){
                    res[count] = s.charAt(j + interval);
                    count++;

                }
            }
        }
        return new String(res);


    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));

    }
}
