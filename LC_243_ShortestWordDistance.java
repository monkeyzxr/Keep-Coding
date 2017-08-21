/**
 * Created by monkeyzxr on 2017/8/20.
 *
 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 */

//题意： 找两个单词在数组中的最短距离
    //http://blog.csdn.net/xudli/article/details/48766955
    //https://segmentfault.com/a/1190000003906667

    //一个指针指向word1上次出现的位置，一个指针指向word2上次出现的位置。
// 因为两个单词如果比较接近的话，肯定是相邻的word1和word2的位置之差，所以我们只要每次得到一个新位置和另一个单词的位置比较一下就行了。
public class LC_243_ShortestWordDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int dis = Integer.MAX_VALUE;  //最短距离

        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
                // 第一次写入idx就先不比较
                if (index2 != -1){
                    dis = Math.min(dis, index1-index2);
                }
            }

            if (words[i].equals(word2)){
                index2 = i;
                if (index1 != -1){
                    dis = Math.min(dis, index2-index1);
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(words, "coding", "practice"));
        System.out.println(shortestDistance(words, "makes", "coding"));

    }

}
