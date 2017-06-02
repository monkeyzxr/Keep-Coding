import java.util.HashSet;

/**
 * Created by monkeyzxr on 2017/6/1.
 *
 Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind.
 You need to distribute these candies equally in number to brother and sister.
 Return the maximum number of kinds of candies the sister could gain.

 Example 1:
 Input: candies = [1,1,2,2,3,3]
 Output: 3

 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.

 Example 2:
 Input: candies = [1,1,2,3]
 Output: 2

 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.


 */

//我的思路：


    //这里使用 set 保存所有的糖果种类total
    //记录糖果种类，若糖果种类大于数组的一半，妹妹最多得到candies.size()/2种糖果,否则每种糖果都可以得到
//http://massivealgorithms.blogspot.com/2017/05/leetcode-575-distribute-candies.html
//http://blog.csdn.net/whl_program/article/details/71367997
import java.util.*;
public class LC_575_DistributeCandies {
    public static int distributeCandies(int[] candies) { //array中，每一个数字，代表一个种类。想像成A，B，C，D也可以
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies){    //hashset 存放糖果，用于统计糖果总种类的个数
            kinds.add(candy);         //set里存放的元素不会重复
        }

        int result = 0;
        if (kinds.size() >= candies.length/2)
            result  = candies.length / 2;
        else
            result = kinds.size();

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1,1,2,2,3,3};
        System.out.println(distributeCandies(test1));

        int[] test2 = {1,1,2,3};
        System.out.println(distributeCandies(test2));
    }
}

