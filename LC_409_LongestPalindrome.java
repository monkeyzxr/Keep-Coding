import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/5/27.
 *
 Given a string which consists of lowercase or uppercase letters,
 find the length of the longest palindromes that can be built with those letters.
 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.

 */

// 方法1：看有多少个对子（打过牌吗，就是看有多少对子），然后看有没有一个单（注意：只需要一个单，放中间就行了）。
    /*
public class LC_409_LongestPalindrome {
    public static int longestPalindrome(String s) {
        //用hashmap来统计String中char的个数：
        HashMap<Character,Integer> map = new HashMap<>();  // make a map: key 存放character， value存放 character的次数。
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //int num = map.get(c); // 不能这么写。 因为如果遇见新char，就没法get，报错。
            Integer num = (Integer)map.get(c);  //这里必须转换成Int的Object，来验证map中是否已经存在这个char了。不然，出error。
            if (num == null)
                num = 0;
            map.put(c, num+1);
        }
        //System.out.println(map);

        int count = 0;
        int flag = 0;  // 看有没有单

        // 历遍这个map
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
           // Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value%2 != 0){
                flag = 1;  //奇数个char，有单.这个单只能放回文序列的中间，只能用一次。
            }
            count += (value/2) * 2;  // 次数／2，再* 2。算出 最多的偶数个次数。
        }
        return count + flag;
    }

    public static void main(String[] args) {
        String test = "abccccdd";
        int a = longestPalindrome(test);
        System.out.println(a);
    }
}
*/



//方法2；用hashset
public class LC_409_LongestPalindrome {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();//hashset 存放String的char
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){ //如果set中已经有这个char了，就只删掉set中的这个char，String中的char不添加到set
                set.remove(s.charAt(i));
                count++;
            }
            else
                set.add(s.charAt(i));  //如果set中没有这个char，就把这个char加到set中。
        }

        if (!set.isEmpty())  //如果set不空，说明有的char是奇数个
            return count * 2 +1;

        return
                count * 2;
    }

    public static void main(String[] args) {
        String test = "abccccdd";
        int a = longestPalindrome(test);
        System.out.println(a);
    }
}
