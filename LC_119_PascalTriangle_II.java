import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/24.
 *
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 *
 */

//http://www.cnblogs.com/yrbbest/p/4438451.html
    //http://www.jiuzhang.com/solutions/pascals-triangle-ii/




    /*list 的api：
    void add(int index, E element)  本题一个重要的API知识

Inserts the specified element at the specified position in this list (optional operation).
Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     */

public class LC_119_PascalTriangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++){
            res.add(0,1);  //每次在index为0的位置上放1，已经存在的在原位置的数，就被挤着向后

           // System.out.println(res);

            for (int j = 1; j < res.size() - 1; j++)
                res.set(j, res.get(j) + res.get(j+1));  // 重新把原位置的数换成新数
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(getRow(2));

    }
}
