import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/3.
 *
 * Given a List of words,
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]

 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.

 */

//http://blog.csdn.net/zhouziyu2011/article/details/54907270
    //我的思路： 用map存放（字母，行数）。用list存放结果的String
public class LC_500_KeyboardRow {
    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        //考虑到数组需要预先设置长度，而数组长度未知，所以判断整个单词完毕后将其县存入List
        List<String> list = new ArrayList<>();   //存放正确结果

        char[]row1 = new char[]{'q','w','e', 'r','t','y','u','i','o','p'};
        char[]row2 = new char[]{'a', 's','d','f','g','h','j','k','l'};
        char[]row3 = new char[]{'z','x','c','v','b','n','m'};

        for (char c : row1){
            map.put(c,1);
        }
        for (char c : row2){
            map.put(c,2);
        }
        for (char c : row3){
            map.put(c,3);
        }

        for (int i = 0; i < words.length; i++){
            boolean isOneRow = true;   //用来check
            String word = words[i].toLowerCase();   //每一个单词，都把字母变成小写来判断。

            int row = map.get(word.charAt(0));  //取得单词的第一个字母所在的row

            for (int j = 1; j < word.length(); j++){  //从每个单词的第二个字母开始判断
                if (map.get(word.charAt(j)) != row){
                    isOneRow = false;
                    break;
                }
            }

            if (isOneRow == true){  //如果所有的字母都在同一行
                list.add(words[i]);
            }
        }

        String[]result = list.toArray(new String[list.size()]);  // list 转成 array
        return result;
    }

    public static void main(String[] args) {
        String[]test = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(test)));
    }
}
