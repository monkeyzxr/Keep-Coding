import java.util.*;

/**
 * Created by monkeyzxr on 2017/7/12.
 *
 Given a string and a string dictionary,
 find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 If there are more than one possible results, return the longest word with the smallest lexicographical order.
 If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]
 Output:
 "apple"

 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]
 Output:
 "a"

 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.
 *
 */

//给定字符串s和字典d，判断s删去一部分字符是否可以组成的d中的字符串。若可以，求长度最长且字典序最小的字符串。否则返回空串。

    /*
    我们可以给字典排序，通过重写comparator来实现按长度由大到小来排，如果长度相等的就按字母顺序来排。
    然后我们开始遍历每一个单词，用一个变量i来记录单词中的某个字母的位置，我们遍历给定字符串，如果遍历到单词中的某个字母来，i自增1，如果没有，就继续往下遍历。
    这样如果最后i和单词长度相等，说明单词中的所有字母都按顺序出现在了字符串s中，
    由于字典中的单词已经按要求排过序了，所以第一个通过验证的单词一定是正确答案，我们直接返回当前单词即可
     */
    //http://www.cnblogs.com/grandyang/p/6523344.html
    //http://www.itdadao.com/articles/c15a1381351p0.html
public class LC_524_LongestWordDictionarythroughDeleting {
    public static String findLongestWord(String s, List<String> d) {

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o2.length()-o1.length(); //降序排列，就是按照String的长度由多到少排列
                else
                    return o1.compareTo(o2);  //若长度相等，按照字母顺序排列
            }
        };

        Collections.sort(d, comp);

        for (String str : d){ //str 是字典里的每一个String。。。！！！！！！！》》》s要删除字母，得到str《《《《
            int i = 0;  //用i做指针，指向str。

            for (char c : s.toCharArray()){ //循环目标s 中的每一个字母，直到s跑完，看看
                if (i < str.length() && str.charAt(i) == c)
                    i++;
            }

            if (i == str.length()) //如果指向的i 是和str一样长，（就是说指针指向的str的末尾）说明形成一个完整的str
                return str;
        }

        return "";

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord("abpcplea", list));

    }
}
