import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/19.
 *
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/*
http://bangbingsyb.blogspot.com/2014/11/leetcode-restore-ip-addresses.html
思路：

一个有效的IP地址由4个数字组成，每个数字在0-255之间。
对于其中的2位数或3位数，不能以0开头。所以对于以s[i]开头的数字有3种可能：

1. s[i]
2. s[i : i+1]，s[i] !=0时
3. s[i : i+2]，s[i] != 0，且s[i : i+2] <= 255

根据以上规律，对s从头开始进行DFS寻找4个数字即可。
 */

/*
https://www.tianmaying.com/tutorial/LC93
这道题目由于数据量很小，所以可以很简单的采取回溯的方法，
依次枚举每一段IP的长度，在过程中对合法性进行判断，一旦完整的枚举完4段之后就说明找到了一组新的方案，将其加入到答案集中即可。
 */


//http://www.jiuzhang.com/solutions/restore-ip-addresses/
public class LC_93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12)
            return result;





    }

    public static boolean isValid(String s){
        if (s.charAt(0) == '0')
            return s.equals("0"); //to eliminate cases like "00", "10"
        // 就是： if(s[0]=='0' && s.size()!=1) return false;

        int digit = Integer.valueOf(s);
        return digit >=0 && digit <= 255;
    }

    public static void helper(ArrayList<String> result,
                              ArrayList<String> list,
                              String s,
                              int startIndex){

    }




    public static void main(String[] args) {

    }
}
