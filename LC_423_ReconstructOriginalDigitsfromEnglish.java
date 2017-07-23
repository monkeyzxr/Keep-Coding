/**
 * Created by monkeyzxr on 2017/7/22.
 *
 Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

 Note:
 Input contains only lowercase English letters.
 Input is guaranteed to be valid and can be transformed to its original digits.
 That means invalid inputs such as "abc" or "zerone" are not permitted.
 Input length is less than 50,000.
 Example 1:
 Input: "owoztneoer"

 Output: "012"
 Example 2:
 Input: "fviefuro"

 Output: "45" *
 */

//题目大意：
//给定一个非空字符串，包含一组乱序的英文字母表示的数字0-9，按递增序输出这些数字。

//http://blog.csdn.net/mebiuw/article/details/52830114
    //http://www.cnblogs.com/grandyang/p/5996239.html

/**
 * 字符串表示了一些英文的数字，但是已经乱序了，现在要求将其转化为具体的数值
 *
 *
 * 再次特别注明：我发代码的时候是题目当天出来的时候，已经AC了，但是Leetcode可能会更改测试用例，导致代码无法AC
 * 如果出现上述情况，请给我留言，我会修正更新代码
 *
 * zero:0
 * one:1
 * two:2
 * three:3
 * four:4
 * five:5
 * six:6
 * seven:7
 * eight:8
 * nine:9
 *
 * 我们可以观察得到：
 * 只有Zero：包含z，剩下的都没有
 * 只有Two：包含w，其他都没有
 * 除了0，2，只有six包含x
 * 除了0，2，6，只有.... 等等以此类推
 *
 * 找到每一个规律后，就可以开始了，这里我就不详细写了
 *
 * */
public class LC_423_ReconstructOriginalDigitsfromEnglish {
    public static String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[10];  //存放0～9这10个digits的个数

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //数字中，独占的字母：
            if (c == 'z') count[0]++;  //只有0有z
            else if (c == 'w') count[2]++;   // 2 -> w
            else if (c == 'x') count[6]++;   // 6 -> x
            else if (c == 'g') count[8]++;   // 8 -> g
            else if (c == 'u') count[4]++;   // 4 -> u

            //几个数字中，共有的字母：
            else if (c == 's') count[7]++;  // 6/7 ->s
            else if (c == 'f') count[5]++; // 4/5 -> f
            else if (c == 'h') count[3]++; // 3/8 - > h
            else if (c == 'i') count[9]++; // 5/6/8/9 ->i
            else if (c == 'o') count[1]++; // 0/1/2/4 ->o
        }

        //计算出数字的个数：
        count[7] = count[7] - count[6];
        count[5] = count[5] - count[4];
        count[3] = count[3] - count[8];
        count[9] = count[9] - count[8] - count[6] - count[5];
        count[1] = count[1] - count[0] - count[2] - count[4];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){  //数字要从小到达排列
            for (int j = 0; j < count[i]; j++){  //每一个数字，存在count【i】个，要都写出来
                sb.append(i);

            }
        }

        return sb.toString();



    }

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));

    }
}
