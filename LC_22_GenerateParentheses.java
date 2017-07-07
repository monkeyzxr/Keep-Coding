import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/6.
 *
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
 ]

 *
 */

//http://www.cnblogs.com/grandyang/p/4444160.html
    //http://www.jiuzhang.com/solutions/generate-parentheses/

    /*
我们定义两个变量left和right分别表示剩余左右括号的个数，
如果在某次递归时，左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，
所以这种情况直接返回，不继续处理。

如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。

如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，
若right大于0，则调用递归函数，同样要更新参数.
     */
public class LC_22_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;

    }

    //left right 是还剩下多少个左或右括号 没有加入
   public static void helper(int left, int right, String currOut, List<String> res){
        if (left < 0 || right < 0 || left > right)
            return;

        if (left == 0 && right == 0){
            res.add(currOut);
            return;
        }

        helper(left-1, right, currOut+"(", res);
        helper(left, right-1, currOut+")", res);

   }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(6));


    }
}
