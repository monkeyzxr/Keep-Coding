import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/8.
 *
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
     ["aa","b"],
     ["a","a","b"]
 ]
 *
 */


//好题！！
//回溯法：

//http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51659122
// http://www.jiuzhang.com/solutions/palindrome-partitioning/
public class LC_131_PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s ==null|| s.length() == 0)
            return result;

        List<String> list = new ArrayList<>();

        helper(s, 0, list, result);

        return result;

    }

    public static boolean isPalindrome(String s){
        for (int i = 0, j = s.length()-1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void helper(String s, int startIndex, List<String> list, List<List<String>> res){
        if (startIndex == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i < s.length(); i++){
            String subString = s.substring(startIndex, i+1); //从startIndex 到 i
            if (!isPalindrome(subString)){ //如果subString字符不构成回文，那么不进行下一次递归，直接进入下一次循环判断
                continue;
            }

            //如果subString中字符构成回文，那么进行下一次递归，判断i+1之后字符是否构成回文
            list.add(subString);
            helper(s, i+1, list, res);

            list.remove(list.size()-1);  //回溯到上一层
        }
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));

    }
}
