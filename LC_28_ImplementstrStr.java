/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


 */


//http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
//http://bangbingsyb.blogspot.com/2014/11/leetcode-implement-strstr-kmp.html
//http://www.cnblogs.com/grandyang/p/4606696.html

public class LC_28_ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return 0;
        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++){
            if (i + needle.length() > haystack.length()) //先验证，如果i跑到的位置，超过了对应的长度，就不需要再比较了
                return -1;

            int curr = i; // 用curr来指向当前的i位置。内循环里，只跑curr

            //对于每个i，进行另一循环的j来验证
            for (int j = 0; j < needle.length(); j++){
                if (needle.charAt(j) == haystack.charAt(curr)){
                    if (j == needle.length()-1) //说明此时j的needle内循环也跑完了
                        return i;  //返回外循环开始的位置

                    curr++;  //外循环跑起来
                }
                else
                    break;  //打断内循环，外循环继续
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "12345hello678";
        String needle1 = "hello";

        System.out.println(strStr(haystack1,needle1));

        String haystack2 = "12345hello678";
        String needle2 = "helllo";

        System.out.println(strStr(haystack2,needle2));

    }
}
