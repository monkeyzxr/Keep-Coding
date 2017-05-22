/**
 * Created by monkeyzxr on 2017/5/21.
 *
 Given a positive integer, output its complement number.
 The complement(补足) strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 Example 1:
 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:
 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */



/**
 * 方法1： 错误！
 *
public class LC_476_NumberComplement {
    public static int findComplement(int num) {
        String str = Integer.toBinaryString(num);

//  String are immutable in Java. You can't change them.!!!!!
//  String 不会被改变，所以不能直接在String 上面改动。 不能这么写！！！！！！！！！！！

        for(int i = 0; i < str.length(); i++){
            char curChar = str.charAt(i);
            if(curChar == '0')
                curChar= '1';

            else
                if (curChar == '1')
                    curChar = '0';
        }
        return Integer.parseInt(str);   // 得到的还是原来的string，这个for loop没起作用。
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

}
**/

// 方法2 : 我自己写的。但是提交后显示 效率低，runtime太高。
    /*
public class LC_476_NumberComplement {
    public static int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        str = str.replace('1','a');  // 这里必须用str = str.replace（）。。。因为两个obj被创造了，用原来的str取指向新的obj。
        str = str.replace('0','b');
        str = str.replace('a','0');
        str = str.replace('b','1');

        System.out.println(str);
        return Integer.parseInt(str,2);  //convert String to int： using Integer.parseInt() method.
                       // parseInt(String s, int radix) ： 用radix基数（2）进行转换了，最终return一个十进制的数。
                      // Parses the string argument as a signed integer in the radix specified by the second argument.

    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

}
    */


//方法3 ：同方法1
// 效率仍然不好
    /*
public class LC_476_NumberComplement {
    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        char[] result = new char[binary.length()];

        for (int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0')
                result[i] = '1';
            else
                if (binary.charAt(i) == '1')
                    result[i] = '0';
        }
        return Integer.parseInt(new String(result), 2); // String(char[] value)
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
*/


// 方法4 ： 网上做法：
    // 先找到最高位（最左端）为1-bit的位置。例如5： 00000...000000101。根据它制造一个等长度的，全是1-bit的mask，如111。
    // 将input的数的二进制，反转～。例如 00000...000000101 => 1111....111111010
    // 反转后的input与mask进行bit AND，即为结果。例如： 111....111111010 & 111 = 010 = 5

    /*
public class LC_476_NumberComplement {
    public static int findComplement(int num) {
       //write a method to find the leftmost 1 of num
        int leftmost_position = 0;
        int tmp = num;
        while(tmp != 0){
            tmp = tmp >> 1;   // or tmp = tmp / 2
            leftmost_position++;
        }
        System.out.println("The first 1 position is : " + leftmost_position);
        int mask = (1 << leftmost_position) - 1;
        return (~num) & mask;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
*/


// 方法5 : 同方法4， 但是，用API  Integer.highestOneBit(num)
// Returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the specified int value.
// 例如: Number = 170; Binary = 10101010
// Highest one bit = 10000000 = 128
// 就是找到二进制的最左端的1，其他都为0，取其十进制的数。

public class LC_476_NumberComplement {
    public static int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        // 1000  ---- input of binary form
        // 10000 ---- left shift 1 bit
        //  -1
        // 1111  ----mask of binary form, all 1 bits, same size of 1000

       // System.out.println("The mask in binary form is :" + Integer.toBinaryString(mask));
       // System.out.println("The input value in binary form is: " + Integer.toBinaryString(num));
        num = ~num;
      //  System.out.println("The bitwise complement(~) of input value in binary form is: " + Integer.toBinaryString(num));
        return num & mask;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
    //  use 5 as input:
    //  The mask in binary form is :111
    //  The input value in binary form is: 101
    //  The bitwise complement(~) of input value in binary form is: 11111111111111111111111111111010