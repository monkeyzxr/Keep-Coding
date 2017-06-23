import java.util.*;

/**
 * Created by monkeyzxr on 2017/6/22.
 *
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */

//我自己写，错误，因为不能用Set，要用Hash，错误原因见test3。会出现重复的结果。
/*
public class LC_187_RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10)
            return result;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length()-9; i++){
            String sub = s.substring(i, i+10); //The substring begins at beginIndex and extends to index endIndex - 1.
            if (set.contains(sub))
                result.add(sub);
            else
                set.add(sub);
        }
        return result;

    }

    public static void main(String[] args) {
        String test1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(test1));

        String test2 = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(test2));

        String test3 = "AAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(test3));

    }
}
*/

// 我自己写，正确！
public class LC_187_RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10)
            return result;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0 ; i <= s.length()-10; i++){  // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ,length = 16, i <= 6
            String sub = s.substring(i, i+10);
            if (map.containsKey(sub))
                map.put(sub, map.get(sub)+1);
            else
                map.put(sub, 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String test1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(test1));

        String test2 = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(test2));

        String test3 = "AAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(test3));

    }
}