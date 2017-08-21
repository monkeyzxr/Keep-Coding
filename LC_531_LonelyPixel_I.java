import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/8/20.
 *
 Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

 Example:

 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.
 Note:

 The range of width and height of the input 2D array is [1,500].
 *
 */

//http://blog.csdn.net/qq_27262609/article/details/60571980
public class LC_531_LonelyPixel_I {
    public static int findLonelyPixel(char[][] picture) {
        int count = 0;
        Map<Integer, Integer> row = new HashMap<>(); //记录行号，和当前行里面出现 B的个数
        Map<Integer, Integer> column = new HashMap<>();

        for (int i  = 0; i < picture.length; i++){
            for (int j = 0; j < picture[0].length; j++){
                if (picture[i][j] == 'B'){
                    if (row.containsKey(i)){  //update每一个行出现的B的个数
                        row.put(i, row.get(i)+1);
                    }
                    else {
                        row.put(i, 1);
                    }

                    if (column.containsKey(j)){
                        column.put(j, column.get(j)+1);
                    }
                    else {
                        column.put(j, 1);
                    }
                }
            }
        }

        for (int i = 0; i < picture.length; i++){
            for (int j = 0; j < picture[0].length; j++){
                if (picture[i][j] == 'B' && row.containsKey(i) && row.get(i) == 1 && column.containsKey(j) && column.get(j) == 1){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] p = {
                {'W', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'}
        };

        System.out.println(findLonelyPixel(p));

    }
}
