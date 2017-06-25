import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/24.
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
            [1],
           [1,1],
          [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
 ]
 *
 */

//思路：每一列第一個值都是1。
    //每一列第n個值則是上一列n-1位子+n位子的值。
    //http://www.cnblogs.com/yrbbest/p/4438449.html
public class LC_118_PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0)
            return res;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);  //把第零行的1 加入到结果
        res.add(list);

        for (int i = 1; i < numRows; i++){ //从第一行开始开始加入
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(1);  //把每一行的第一个1加入list

            for (int j = 1; j < res.get(i-1).size(); j++){
                int currSum = res.get(i-1).get(j-1) + res.get(i-1).get(j); //计算i的上一行，即i-1行的，相邻的两个数的和
                tmp.add(currSum);
            }

            tmp.add(1);  //把每一行最后一个1放到list里
            res.add(tmp);

        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(8));


    }
}


/*
Update:


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            list.add(0, 1);

            for(int j = 1; j < list.size() - 1; j++)
                list.set(j, list.get(j) + list.get(j + 1));

            res.add(new ArrayList<Integer>(list));
        }

        return res;
    }
}

 */
