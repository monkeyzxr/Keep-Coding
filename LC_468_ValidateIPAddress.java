/**
 * Created by monkeyzxr on 2017/7/10.
 *
 Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

 IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

 Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

 IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 The groups are separated by colons (":").
 For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

 However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
 For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

 Besides, extra leading zeros in the IPv6 is also invalid.
 For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

 Note: You may assume there is no extra space or special characters in the input string.

 Example 1:
 Input: "172.16.254.1"
 Output: "IPv4"
 Explanation: This is a valid IPv4 address, return "IPv4".

 Example 2:
 Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 Output: "IPv6"
 Explanation: This is a valid IPv6 address, return "IPv6".

 Example 3:
 Input: "256.256.256.256"
 Output: "Neither"
 Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 */
/*
题目大意：
编写函数，判断给定的IP地址是否为有效的IPv4地址或者Ipv6地址。

Ipv4地址为4个以点分隔的数字，范围0到255，例如172.16.254.1。

此外，Ipv4不允许出现前缀0。例如地址172.16.254.01是无效的。

Ipv6地址为8个以冒号分隔的16进制数字，例如2001:0db8:85a3:0000:0000:8a2e:0370:7334。
允许出现前缀0，并且小写字母和大写字母可以同时出现，所以2001:db8:85a3:0:0:8A2E:0370:7334也是有效的IPv6地址。

然而，不允许出现两个连续的冒号。例如2001:0db8:85a3::8A2E:0370:7334是无效的。

此外，IPv6地址中每一个数字的长度不应大于4位，例如02001:0db8:85a3:0000:0000:8a2e:0370:7334是无效的。

注意：你可以假设测试用例中没有额外的空白字符，但是可能会包含一些特殊字符。
 */
public class LC_468_ValidateIPAddress {
    public static String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty())
            return "Neither";

        if (IP.contains(":"))
            return (isIPV6(IP)? "IPv6" : "Neither");
        else
            return (isIPV4(IP)? "IPv4" : "Neither");

    }

    public static boolean isIPV6(String ip){
        int dotCount = 0;
        for (int i = 0; i < ip.length(); i++){
            if (ip.charAt(i) == ':')
                dotCount++;
        }

        if (dotCount != 7)  //ipv6要有7个：
            return false;

        String[] gr = ip.split(":");
        if (gr.length != 8)
            return false;

        for (String g : gr){
            if (g.isEmpty())
                return false;

            if (g.length() > 4)
                return false;

            for (int i = 0; i < g.length(); i++){
                char ch = g.charAt(i); //16进制：用数字0到9和字母A到F（或a~f）表示
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
                    return false;
            }
        }
        return true;
    }

    public static boolean isIPV4(String ip){
        int dotCount = 0;
        for (int i = 0; i < ip.length(); i++){
            if (ip.charAt(i) == '.')
                dotCount++;
        }

        if (dotCount != 3)
            return false;

        //You need to escape the dot if you want to split on a literal dot
        //这里split要加双反斜杠，因为“.” matches any character
        // 如果不加，就是 you are splitting on the regex ., which means "any character".
        String[] gr = ip.split("\\.");

        if (gr.length != 4)
            return  false;

        for (String g : gr){
            if (g.isEmpty())
                return false;

            /*
            for (int i = 0; i < g.length(); i++){
                char ch = g.charAt(i);
                if (!(ch >= '0' && ch <= '9'))
                    return false;
            }
            */

            //检查是否是 0开头
            //就是子String变成int，int后接""，变成新的String。如果新String与原来子String不同，就是 0开头
            //例如： 016 -> 16(int) -> 16+""(String) -> compare with 016(String)
            try {
                int val = Integer.valueOf(g);
                if ((val + "").equals(g) == false)
                    return false;

                if (val > 255 || val < 0)
                    return false;

               // if (g.charAt(0) == '0' && (val != 0 || g.length() != 1))
                //    return false;
            }catch (NumberFormatException ex){
                //Thrown to indicate that the application has attempted to convert a string to one of the numeric types,
                // but that the string does not have the appropriate format.
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));
    }
}
