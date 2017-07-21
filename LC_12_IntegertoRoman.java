/**
 * Created by monkeyzxr on 2017/7/20.
 *
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.


 *
 */

/*

Symbol	I	V	X	L	C	D	M
Value	1	5	10	50	100	500	1,000

 */

/*
//http://blog.csdn.net/havenoidea/article/details/11848921
科普了一下表达方式，理解了就不复杂了。
I = 1;
V = 5;
X = 10;
L = 50;
C = 100;
D = 500;
M = 1000;
其中每两个阶段的之间有一个减法的表示，比如900=CM， C写在M前面表示 M - C。

范围给到3999，感觉情况不多直接打表其实更快，用代码判断表示估计比较繁琐。

然后就是贪心的做法，每次选择能表示的最大值，把对应的字符串连起来。
 */

//https://www.tianmaying.com/tutorial/LC12
//该题的主要难点是对罗马数字的理解。实际上等价于将阿拉伯数字上的每一位替换为对应的罗马数字即可。


//http://www.jiuzhang.com/solutions/integer-to-roman/
    //http://blog.csdn.net/havenoidea/article/details/11848921


public class LC_12_IntegertoRoman {
    public static String intToRoman(int num) {
        if (num <= 0)
            return "";

        //对应数字由大到小排列，每次选择能表示的最大值，把对应的字符串连起来。
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

       String result = "";

       for (int i = 0; num != 0; i++){
           while (num >= value[i]){
               num -= value[i];
               result += symbols[i];
           }
       }

       return result;

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(900));
        System.out.println(intToRoman(960));
        System.out.println(intToRoman(967));



    }
}


