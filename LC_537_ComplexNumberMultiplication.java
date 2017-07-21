/**
 * Created by monkeyzxr on 2017/7/20.
 *
 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:
 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

 Example 2:
 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100].
 And the output should be also in this form.
 *
 */


/*
(a + bi) * (c + di)  = (ac - bd) + (ad + bc)i;
因此我们只需要从两个复数的字符串表示中分别分解出实部和虚部，然后按照公式生成最终结果即可。
分解实部和虚部时，根据‘+’位置进行判断，‘+’之前的是实部，‘+’之后‘i’之前的是虚部
 */

//http://www.voidcn.com/blog/huanghanqian/article/p-6572443.html
public class LC_537_ComplexNumberMultiplication {
    public static String complexNumberMultiply(String a, String b) {
        //+是正则中的特殊字符
        //对于单个匹配字段，如+，*，|、\等，可以使用类似于“\\+"或者[+]进行处理
        //为什么需要两个\呢：第一个\是java字符串的转义字符，这样\\实际就代表\，正则处理的就是\+

        String[] split1 = a.split("\\+");
        int a1 = Integer.valueOf(split1[0]);
        String b1i = split1[1].substring(0, split1[1].length()-1); //去掉末尾的i
        int b1 = Integer.valueOf(b1i);

        String[] split2 = b.split("\\+");
        int a2 = Integer.valueOf(split2[0]);
        String b2i = split2[1].substring(0, split2[1].length()-1); //去掉末尾的i
        int b2 = Integer.valueOf(b2i);

        int val1 = a1*a2 - b1*b2;
        int val2 = a1*b2 + b1*a2;

        return String.valueOf(val1) + "+" + String.valueOf(val2) + "i";

    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));

    }
}
