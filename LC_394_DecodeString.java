import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 */

//http://www.cnblogs.com/grandyang/p/5849037.html
//http://blog.csdn.net/mebiuw/article/details/52448807

    /*
    意思是在字符串当中，有一个特殊的格式 — k[S]，遇到这种状况，需要把S重复k次，注意是可以嵌套的

在这次解题当中，我是使用了栈的方式，去解决这个问题。分别使用了一个全局的已解码的字符串Builder，另外对于为解码的，使用栈来暂存。

符号’[‘控制进栈，分别进入计数数字和之前尚未解码的字符串
符号’]’控制出站，出栈当前计数，并且将未解码的字符串进行重复，再链接上一个未解码的字符串

注意栈空的时候证明当前嵌套解码完毕，需要添加到全局当中，反之基于暂存。
     */


    //好好想想：
public class LC_394_DecodeString {
    public static String decodeString(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> counts = new Stack<>();
        Stack<String> strings = new Stack<>();

        StringBuilder result = new StringBuilder();

        int count = 0;
        String currentString = "";

        for (int i  = 0; i < arr.length; i++){   //s = "3[a]2[bc]", return "aaabcbc".
            if (arr[i] >= '0' && arr[i] <= '9'){
                count = count * 10 + arr[i] - '0';
            }
            else if (arr[i] == '['){
                counts.push(count);
                count = 0;  //回复到个数为零 从新初始化
                strings.push(currentString);
                currentString = "";  //string 也要初始化
            }
            else if (arr[i] >= 'a' && arr[i] <= 'z'){
                //注意栈空与否很重要
                if (!counts.isEmpty())  //栈空的时候证明当前嵌套解码完毕，需要添加到全局当中，反之基于暂存
                    currentString += arr[i];
                else
                    result.append(arr[i]);
            }
            else if (arr[i] == ']'){
                int times = counts.pop();
                if (counts.isEmpty()){
                    for (int j = 0; j < times; j++){
                        result.append(currentString);
                    }
                    currentString = strings.pop();
                }
                else {
                    String tmp = "";
                    for (int j = 0; j < times; j++){
                        tmp += currentString;
                    }
                    currentString = strings.pop() + tmp;
                }
            }

        }

        return result.toString();


    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));


    }
}

/*
用两个stack，一个用来保存个数，一个用来保存字符串，
我们遍历输入字符串，如果遇到数字，我们更新计数变量cnt；
如果遇到左中括号，我们把当前cnt压入数字栈中，把当前t压入字符串栈中；
如果遇到右中括号时，我们取出数字栈中顶元素，存入变量k，然后给字符串栈的顶元素循环加上k个t字符串，然后取出顶元素存入字符串t中；
如果遇到字母，我们直接加入字符串t中即可
 */