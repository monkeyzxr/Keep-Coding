/**
 * Created by monkeyzxr on 2017/6/23.
 *
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =

 [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 *
 */

//用回溯算法：枚举board中的一条路径，并且在枚举的过程中一边检查是否能够匹配上word，如果顺利的匹配完了所有word的字符，就说明找到了；
// 如果枚举结束之后仍然没有找到，就说明不存在。
    //https://www.tianmaying.com/tutorial/LC79
    //http://www.programcreek.com/2014/06/leetcode-word-search-java/

    //当index==word.length的时候就找到了对应的字符，返回true;
// 注意边界条件的check，x,y要保证在board内，
// 或者当board[x][y]!=word.charAt(index)的时候都返回false。

    //http://www.cnblogs.com/yrbbest/p/4437124.html
    //http://blog.csdn.net/ever223/article/details/44841719
public class LC_79_WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || word.length() == 0)
            return false;

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, word, i, j, 0) == true)
                    return true;
            }
        }

        return false;

    }

    public static boolean dfs(char[][]board, String word, int i, int j, int index){
        if (index == word.length())
            return true;    //就是在走路径的过程中，如果一直走下去，路径达到了word的长度，说明找到了

        if (i < 0 || j < 0  || i >= board.length || j >= board[0].length)
            return false;  //指针i，j走出届了

        if (board[i][j] == '#')  //设置出发点为#，如果回溯会去，一直回溯到出发点，说明没找到word
            return false;

        if (board[i][j] != word.charAt(index))
            return false;

        char tmp = board[i][j];
        board[i][j] ='#';

        boolean res = dfs(board, word, i-1, j, index+1) ||
                      dfs(board, word, i+1, j, index+1) ||
                      dfs(board, word, i, j-1, index+1) ||
                      dfs(board, word, i, j+1, index+1);

        board[i][j] = tmp;  //把这个位置的字母放回去

        return res;

    }

    public static void main(String[] args) {
        char[][] board = new char[][] { {'A','B','C', 'E'},
                                        {'S','F','C', 'S'},
                                        {'A','D','E', 'E'}};

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

    }
}
