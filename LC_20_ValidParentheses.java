import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/6/11.
 *
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
// ( { } )是可以的


//自己想用LinkedHashMap，但是想不出来
    //看了网上答案，用Stack
    //http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
    //http://www.cnblogs.com/springfor/p/3869420.html
public class LC_20_ValidParentheses {
    public static boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);

            if (map.keySet().contains(curr))
                stack.push(curr);  //如果碰见了String中出现了一个左括号，放到stack中

            else if (map.values().contains(curr)){  //如果遇见了String中的一个 右括号

                //此时，看stack最上层的值，再map里对应的右括号，是不是当前的这个右括号
                if (!stack.empty() && map.get(stack.peek()) == curr ){  //这里的&& 左右的顺序不能变，必须先check stack 是不是空。不然出错，见第5个例子。
                    stack.pop();  //如果是，即是一对的括号，则把stack中的左括号删掉
                }
                else
                    return false;
            }
        }

        return stack.empty();  // 最终查看stack中还有没有剩余的左括号。如果为空，说明遇到的括号都是一对，返回真。
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("( { } )"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("]"));


    }
}
