import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/8/3.
 *
 Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

 Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

 So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

 Note:
 Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 As long as a house is in the heaters' warm radius range, it can be warmed.
 All the heaters follow your radius standard and the warm radius will the same.

 Example 1:
 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

 Example 2:
 Input: [1,2,3,4],[1,4]
 Output: 1
 Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

 *
 */

/*
题目大意：
冬天要来了！今天比赛的第一个任务就是设计加热器温暖房屋。

给定一组排列在水平线上的房屋和加热器，计算最小的加热器半径，使得所有房屋都可以被覆盖。

输入房屋和加热器的坐标，输出期望的加热器半径的最小值。
 */


//http://blog.csdn.net/mebiuw/article/details/53610837
//思路：
//加热器的位置就是加热器地址列表里的了
//先排序，然后给两个指针，按照顺序找到每个屋子距离最近的加热器，记录其位置差。。。所有的位置差里面最长的那一个就是最小的加热器半径了
public class LC_475_Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int minDist = 0;
        int j = 0;  //指向heater

        for (int i = 0; i < houses.length; i++){
            while (j < heaters.length-1 && (Math.abs(heaters[j]-houses[i]) >= Math.abs(heaters[j+1]-houses[i])))
                j++;

            minDist = Math.max(minDist, Math.abs(heaters[j]-houses[i]));
        }

        return minDist;

    }

    public static void main(String[] args) {
        int[] houses1 = {1,2,3,4};
        int[] heaters1 = {1,4};
        System.out.println(findRadius(houses1, heaters1));

        int[] houses2 = {1,2,3,4,5,8,9};
        int[] heaters2 = {1,3,8,9};
        System.out.println(findRadius(houses2, heaters2));

    }
}
