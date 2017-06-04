import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/3.
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */

//我的思路：用一个每一次循环，都找p个char的字符串，放在Set里，在用p去验证，是不是每一个p的字母都在set里。
    // 但是 得到的结果不正确。我找不出原因。
public class LC_438_FindAllAnagramsinString {
    public static List<Integer> findAnagrams(String s, String p) {
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        boolean isAnagrams = true;
        int pSize = p.length();
        for (int i = 0; i < s.length(); i++){
            while(pSize > 0){
                set.add(s.charAt(i));   //这里有问题：String index out of range. 要改一改这里
                i++;
                pSize--;
            }
            System.out.println(Arrays.toString(set.toArray()));

            for (int m = 0; m < p.length(); m++){
                if (!set.contains(p.charAt(m))){
                    isAnagrams = false;
                    break;
                }
                else{
                    isAnagrams = true;
                    continue;
                }
            }

            set.clear();

            if (isAnagrams == true){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";

        List<Integer> test1 = findAnagrams(s1,p1);

        System.out.println(Arrays.toString(test1.toArray()));

        String s2 = "abab";
        String p2 = "ab";

        List<Integer> test2 = findAnagrams(s2,p2);

        System.out.println(Arrays.toString(test2.toArray()));

    }
}
