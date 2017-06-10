import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 */

/*
* 罗马数字共有7个，即Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）。
* 罗马数字中没有“0”，与进位制无关。一般认为罗马数字只用来记数，而不作演算。
* 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
* 右加左减: 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
*左减数字必须为一位，比如8写成VIII，而非IIX
* 右加数字不可连续超过三位，比如14写成XIV，而非XIIII
*同一数码最多只能连续出现三次，如40不可表示为XXXX，而要表示为XL。
*
*
* */

//http://www.jiuzhang.com/solutions/roman-to-integer/
    //http://www.cnblogs.com/grandyang/p/4120857.html
public class LC_13_RomantoInteger {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int length = s.length();
        int result = map.get(s.charAt(length-1)); //从String的最右位开始

        for (int i = length-2; i>=0; i--){
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))  //当前数字比其右侧的大，则加
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));   // 当前数比其右侧的小，则减
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XVIII")); //18
        System.out.println(romanToInt("XXX")); //30


    }

}
