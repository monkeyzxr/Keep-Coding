import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/7/19.
 *
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */

//backtracking

    //http://www.jiuzhang.com/solutions/letter-combinations-of-a-phone-number/
public class LC_17_LetterCombinationsPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        if (digits == null || digits.equals(""))
            return result;

        Map<Character, char[]> map = new HashMap<>();

        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();

        helper(map, digits, sb, result);

        return result;
    }

    public static void helper(Map<Character, char[]> map,
                              String digits,
                              StringBuilder sb,
                              ArrayList<String> result
                              ){

        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        for (char c: map.get(digits.charAt(sb.length()))){  //sb的length最开始是0，慢慢增长
            sb.append(c);                       //先往sb里加入一个digit对应的其中一个字母，然后递归下一层，添加第二个数字对应的所有字母。
            helper(map, digits, sb, result);
            sb.deleteCharAt(sb.length()-1);   //回溯  。回复到上一层，即回到digit对应的第一个字母中的其中的另一个。
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));


    }
}
