import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/5/27.
 *
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 易位构词游戏的英文词汇是 anagram.
 是将组成一个词或短句的字母重新排列顺序，原文中所有字母的每次出现都被使用一次，这样构造出另外一些新的词或短句。
 */

//我写：
    /*
public class LC_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] s_count = new int[256];  //因为ascii码有256个字符
        int[] t_count = new int[256];

        //用Array存放char的次数。Index是char，value是次数
        for (int i = 0; i < s.length(); i++){   //历遍整个String

            s_count[s.charAt(i)]++;   //用char做index，这个char会转成ascii码，其实也是int
            t_count[t.charAt(i)]++;
        }
        System.out.println(Arrays.toString(s_count));
        System.out.println(Arrays.toString(t_count));
        for(int i = 0; i < 256; i++){   //历遍整个Array
            if (s_count[i] != t_count[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1,t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2,t2));
    }
}
*/


//方法2： 如果只是简单的发生了移位，显然排序后应该是一样的！否则不是！
// http://www.cnblogs.com/yrbbest/p/5006201.html
/*
public class LC_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        //use equals () method of Arrays to check if two arrays are equal or not
        return Arrays.equals(sArr,tArr);

    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1,t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2,t2));
    }
}
*/

//方法3： 用HashMap
// http://www.cnblogs.com/yrbbest/p/5006201.html
    /*
public class LC_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
      if(s == null || t == null || s.length() != t.length())
          return false;

        HashMap<Character, Integer> map = new HashMap<>();//用String中的char作为key，char的个数作为value。
        for (int i = 0; i < s.length(); i++){   //构建map，把String s的char的个数保存到map里
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else
                map.put(c,1);
        }

        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (!map.containsKey(c)) //如果t的char不存在于s的map中
                return false;
            else{
                if (map.get(c) == 0)      //这里比较难懂。
                    return false;
                map.put(c, map.get(c)-1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1,t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2,t2));

        String s3 = "aaaaa";
        String t3 = "aaa";
        System.out.println(isAnagram(s3,t3));
    }
}
    */


//用2个Hashmap，自己写：
public class LC_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();//用String中的char作为key，char的个数作为value。
        for (int i = 0; i < s.length(); i++){   //构建map，把String s的char的个数保存到map里
            char c = s.charAt(i);
            if (map1.containsKey(c)){
                map1.put(c,map1.get(c)+1);
            }
            else
                map1.put(c,1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();//用String中的char作为key，char的个数作为value。
        for (int i = 0; i < t.length(); i++){   //构建map，把String t的char的个数保存到map里
            char c = t.charAt(i);
            if (map2.containsKey(c)){
                map2.put(c,map2.get(c)+1);
            }
            else
                map2.put(c,1);
        }

        //boolean equals(Object o)
        // Compares the specified object with this map for equality.
        // Returns true if the given object is also a map and the two maps represent the same mappings.
        // More formally, two maps m1 and m2 represent the same mappings if m1.entrySet().equals(m2.entrySet()).
        return map1.equals(map2);

    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1,t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2,t2));

        String s3 = "aaaaa";
        String t3 = "a";
        System.out.println(isAnagram(s3,t3));
    }
}