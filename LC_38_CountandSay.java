/**
 * Created by monkeyzxr on 2017/6/12.
 *
 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:
 Input: 1
 Output: "1"


 Example 2:
 Input: 4
 Output: "1211"
 */


/*
题目大意：
n=1 返回1
n=2由于n=1的结果为1，有1个1，所以返回11
n=3由于n=2结果为11，有2个1，返回21
n=4由于n=3结果为21，有1个2和1个1，所以返回1211
下一个，就是1个1，1个2，两个1 ==》 111221
下一个，是312211
给定n,以此类推
 */

//就是每一个结果，要根据上一个结果来读

//http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
    // 有点难懂，要好好想想

public class LC_38_CountandSay {
    public static String countAndSay(int n) {
        if(n <= 0)
            return null;

        String res = "1";  //初始化第一条string，就是1

        int i  = 1;   //i 是对应string的行数

        while (i < n){

            StringBuilder sb = new StringBuilder();
            int count = 1;  //count存放相邻的数是否相同的个数

            for(int j = 1; j < res.length(); j++){

                //这个if用于找出相邻相同的数字的个数
                if (res.charAt(j) == res.charAt(j-1))  //当前的数，与其相邻左边的数进行比较
                    count++;  //如果当前这个数，与其左边的数相等，count就加一

                //如果相邻的数开始不一样了，加左边的那个数到sb里
                else{  //如果循环到，当前这个数开始和左边的数不相等了，就把左边的那个数的个数，和数本身，加入到sb中
                    sb.append(count);
                    sb.append(res.charAt(j-1));
                    count = 1;    //进行下一个数字比较之前，count预设回1
                }
            }

            // 把最右位的数加到sb里
            sb.append(count);
            sb.append(res.charAt(res.length()-1));
            res = sb.toString();

            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));



    }
}
