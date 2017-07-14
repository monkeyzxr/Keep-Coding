import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/13.
 *
 *
 Given an integer array of size n,
 find all elements that appear more than ⌊ n/3 ⌋ times.
 The algorithm should run in linear time and in O(1) space.
 */

/* http://www.cnblogs.com/grandyang/p/4233501.html
摩尔投票法 Moore Voting，需要O(n)的时间和O(1)的空间。
这种投票法先将第一个数字假设为众数，然后把计数器设为1，比较下一个数和此数是否相等，若相等则计数器加一，反之减一。
然后看此时计数器的值，若为零，则将当前值设为候选众数。
以此类推直到遍历完整个数组，当前候选众数即为该数组的众数

https://www.hrwhisper.me/leetcode-169-majority-element-leetcode-229-majority-element-ii/
为什么这样做是对的呢？
因为若在有解的情况下，一个元素y出现>n/2次，那么要抵消掉它，必然也要有相同的元素才行，
而总的元素才n个，也就是说元素y在这样的计数中不会被抵消。保证有解的情况最后的候选数就是主要元素。
 */

/*
思路：
这题是上面那题的升级版，要求时间复杂度O(n)，空间复杂度O(1)，也就是不能排序、不能hash，只能用我们的摩尔投票。
首先要明确的是最多有2个解，why?   因为出现次数大于n/3，则至少有n/3+1次，若有3个解，则总数应该为 3 * （n/3+1）次，也就是 n+3 >n与题目不符。
因为可能会有两个解，所以我们需要两个候选元素a和b，以及他们相应的计数cnt_a,cnt_b
初始时将a和b任意的设置为不同的数，将cnt_a和cnt_b分别设置为0，然后遍历数组。
同样的，设当前的元素为x，
若x==a 则cnt_a++
若x==b则cnt_b ++
若cnt_a ==0 则 a = x, cnt_a =1
若cnt_b ==0 则 b = x, cnt_b =1
否则 cnt_a– , cnt_b–
最后算出来的a,b在遍历一遍数组，判断其是否真的 > n/3次
为什么这样是对的呢？
对于有2个解的情况，设解为a和b, 显然a和b不会被少于n/3个元素给抵消掉，所以2个解的情况是OK的。
那么1个解的情况呢？除了元素a（a是解）外，剩下的元素不到2n/3个(这里设为m个，m < 2n/3 )，而这m个元素中，至多有m/2个元素会抵消元素a（因为我们有两个计数的哇），
换句话说，能抵消a的元素总数 <=  m/2 < n /3 ,也就是说元素a最后一定会得到保留。
对于无解的情况，最后验证了是否合法，也没问题。
 */

/*http://blog.csdn.net/xudli/article/details/46784149
观察可知，数组中至多可能会有2个出现次数超过 ⌊ n/3 ⌋ 的众数
记变量n1, n2为候选众数； c1, c2为它们对应的出现次数
遍历数组，记当前数字为num
若num与n1或n2相同，则将其对应的出现次数加1
否则，若c1或c2为0，则将其置为1，对应的候选众数置为num
否则，将c1与c2分别减1
最后，再统计一次候选众数在数组中出现的次数，若满足要求，则返回之。
 */
public class LC_229_MajorityElement_II {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int m = 0, n = 0;
        int count_m = 0, count_n = 0;

        for (int a : nums){
            if (a == m)
                count_m++;
            else if (a == n)
                count_n++;

            else if (count_m == 0){
                m = a;
                count_m = 1;
            }
            else if (count_n == 0){
                n = a;
                count_n = 1;
            }

            else {
                count_m--;
                count_n--;
            }
        }

        //得到了2个候选的数m,n。需要进一步要验证:
        count_m = count_n = 0;

        for (int a : nums){
            if (a == m)
               count_m++;
            else if (a == n)
                count_n++;
        }

        if (count_m > nums.length/3)
            res.add(m);
        if (count_n > nums.length/3)
            res.add(n);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,3,3,4,5};

        System.out.println(majorityElement(nums));

    }
}
