/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */

// 我自己写的，先二进制转换成十进制，sum，再转换成二进制。
    // 太笨了
    //如果不自己写function，可以直接用API：

    // Integer.parseInt("1001", 2);
    //和
    //public static String toBinaryString(int i)

    /*
public class LC_67_AddBinary {

    public static int binaryToInt(String s){
        int res = 0;
        int j = 0;
        for(int i = s.length()-1; i >= 0; i--){

            //这又3种 char转换成 int的方法。 后两种在char之前加上""，使之变成String，很聪明！
            int currInt = Character.getNumericValue(s.charAt(i));  //Char转换成Int
            //int currInt = Integer.parseInt(""+s.charAt(i));  //Char转换成Int
            //int currInt = Integer.valueOf(""+s.charAt(i));  //Char转换成Int

            res += currInt * Math.pow(2,j);
            j++;
        }
        return res;
    }

    public static String intToBinary(int a){
        StringBuilder sb = new StringBuilder();

        if (a == 0)
            sb.append(0);

        while(a > 0){
            int remainder = a%2;
            sb.append(remainder);
            a = a/2;
        }
        return sb.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        int sum = binaryToInt(a) + binaryToInt(b);
        return intToBinary(sum);


    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));

    }
}
*/

    //http://www.programcreek.com/2014/05/leetcode-add-binary-java/
    //网上做法，直接相加
    // 把每个位置上的char变成0或者1
public class LC_67_AddBinary {

    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;

        //从两个binary string的最右位（最低位）开始相加
        int pa = a.length()-1;
        int pb = b.length()-1;

        int flag = 0;  //flag 用于进位。如果两个数相加大于2，就要进一位

        StringBuilder sb = new StringBuilder();

        while (pa >= 0 || pb >= 0){ //从右侧往左开始循环，一直相加到最左位
            int va = 0;
            int vb = 0;

            if (pa >= 0){
                if (a.charAt(pa) == '0')
                    va = 0;        //给pa所指的va赋值
                else
                    va = 1;
            }
            pa--;  //pa指针向左移一位

            if (pb >= 0){
                if (b.charAt(pb) == '0')
                    vb = 0;      //给pb所指向的vb赋值
                else
                    vb = 1;
            }
            pb--;  //pb指针向左移一位

            int sum = va + vb + flag;   // 当前位上的两个数相加

            if (sum >= 2){
                sb.append(String.valueOf(sum - 2));
                flag = 1;
            }
            else {
                sb.append(String.valueOf(sum));
                flag = 0;
            }
        }

        //循环完成后，如果flag =1，也就是相加和比原来的要多一位，则加上一位1
        if (flag == 1)
            sb.append('1');


        //sb里的String都是倒着加的，也即是最低位的和放在了sb的最左端。要反转过来。
        String res = sb.reverse().toString();

        return res;


    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));

    }
}

