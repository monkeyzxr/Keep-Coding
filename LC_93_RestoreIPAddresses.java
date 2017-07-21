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
对于其中的 2位数 或 3位数 ，不能以0开头。（只有1位数，可以是零，例如，就是本身 0）。所以对于以s[i]开头的数字有3种可能：

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

//https://www.tianmaying.com/tutorial/LC93
//http://www.jiuzhang.com/solutions/restore-ip-addresses/
public class LC_93_RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12)
            return result;

        helper(result, list, s, 0);

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
                              ArrayList<String> list,  //current 存放的list
                              String s,
                              int startIndex){

        if (list.size() == 4) {   //base 条件。 就是递归的。
            if (startIndex != s.length())
                return;

            StringBuilder sb = new StringBuilder();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);  //把循环的最末尾加的 点.  给删除掉
            result.add(sb.toString());
        }

        // i 循环S String中的3个 char
        for (int i = startIndex; i < s.length() && i < startIndex+3; i++){
            String tmp = s.substring(startIndex, i+1); //tmp为startIndex开始的subString，长度分别是s[i]，s[i : i+1]，s[i : i+2]

            if (isValid(tmp)){  //check tmp，不能是开头为0的多位数，大小也要在0～255
                list.add(tmp);
                helper(result, list, s, i+1);   //递归下一层。就是startIndex = i+1，就是从下一段新的subString开始，继续递归下去

               //list.remove(list.size()-1);他的作用就是每次清除一个空位 让后续元素加入
                //寻找成功，最后一个元素要退位，寻找不到，方法不可行，那么我们回退，也要移除最后一个元素。
                list.remove(list.size()-1);   //回溯原来位置！！！！
            }

        }

    }




    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("000000"));


    }
}
