import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/25.
 *
 Given the coordinates of four points in 2D space, return whether the four points could construct a square.

 The coordinate (x,y) of a point is represented by an integer array with two integers.

 Example:
 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 Output: True
 Note:

 All the input integers are in the range [-10000, 10000].
 A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 Input points have no order.
 *
 */

//思路： 如果是正方形，4个点，能组成6条直线。查看是不是2条长线相等，4条短线相等
//http://www.geeksforgeeks.org/check-given-four-points-form-square/

    //我自己写，正确：
public class LC_593_ValidSquare {
    public static long getLength(int[] p1, int[] p2){
        //只算根号里面的和，不用开根号了，结果都一样，省略一步
        return (long)Math.pow(p1[0]-p2[0], 2) + (long)Math.pow(p1[1]-p2[1], 2);

    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Long, Integer> map = new HashMap<>(); //我想用一map存长度出现的次数

       long[] lengths = {  //用一array存6条线的长度
               getLength(p1, p2), getLength(p1, p3), getLength(p1, p4),
               getLength(p2, p3), getLength(p2, p4),
               getLength(p3, p4)
       };

      for (int i = 0; i < 6; i++){  // 将6条线的长度为key，出现的次数为value，放到map里
          if (map.containsKey(lengths[i]))
              map.put(lengths[i], map.get(lengths[i])+1);
          else
              map.put(lengths[i], 1);
      }

      long[] key = new long[2];
        int i = 0;

      if (map.keySet().size() == 2){  //如果map里只有两个key，则继续验证
          for (long l : map.keySet()){   //把2个key取出来
              key[i] = l;
              i++;
          }
          if (key[0] < key[1] && map.get(key[0]) == map.get(key[1]) * 2) //如果数小的key的个数是数大的key的个数的2倍，则正确
              return true;
          else
              if (key[1] < key[0] && map.get(key[1]) == map.get(key[0]) * 2)
                  return true;
      }
      return false;

    }

    public static void main(String[] args) {
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};

        System.out.println(validSquare(p1,p2,p3,p4));

    }
}
