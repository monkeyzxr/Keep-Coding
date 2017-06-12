/**
 * Created by monkeyzxr on 2017/6/10.
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 *
 */

//我自己写，提交报错, 1和2的根号结果不正确
    /*
public class LC_69_Sqrtx {
    public static int mySqrt(int x) {
        if (x < 0) return -1;

        int res = 0;
        for (int i = 0; i <= x/2; i++){   // x的根号，一定会小于x／2
            if (i*i == x){
                res = i;
            }
            if (i*i > x){
                break;
            }
        }

        return res;




    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(25));
        System.out.println(mySqrt(2));
    }

}
*/


    //网上做法：二分查找法  binarysearch
    //取定左界和右界，然后每次砍掉不满足条件的一半

    /*
    * 典型的二分法
算法：当数据量很大适宜采用该方法。
采用二分法查找时，数据需是排好序的。

基本思想：假设数据是按升序排序的，对于给定值key，从序列的中间位置k开始比较，
如果当前位置arr[k]值等于key，则查找成功；
若key小于当前位置值arr[k]，则在数列的前半段中查找,arr[low,mid-1]；
若key大于当前位置值arr[k]，则在数列的后半段中继续查找arr[mid+1,high]，
直到找到为止,时间复杂度:O(log(n))。
    * */

    //http://bangbingsyb.blogspot.com/2014/11/leetcode-sqrtx.html
    //http://www.jiuzhang.com/solutions/sqrtx/
    //http://blog.csdn.net/chenchaofuck1/article/details/50991975

public class LC_69_Sqrtx {
    public static int mySqrt(int x) {
        if(x<=1) return x;

        int start=0, end=x;
        //例如 求25的根号：mid= 0 + 25/2 = 12.
        // 12*12 = 144 > x, 则 end = mid-1 = 11，start不变还是0，mid= 0+11／2 = 5
        // 5 *5 = 25，返回mid=5

        while(start<=end) {
            int mid = start + (end-start)/2;//如果是偶数个，则是中间两个数的左边小的数是mid


            if(x/mid==mid)
                return mid;

            else if(x/mid<mid)
                end = mid-1;

            else
                start = mid+1;
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(25));
        System.out.println(mySqrt(2));
    }

}


/**
 * http://www.cnblogs.com/grandyang/p/4346413.html
 * 这道题要求我们求平方根，我们能想到的方法就是算一个候选值的平方，然后和x比较大小，
 * 为了缩短查找时间，我们采用二分搜索法来找平方根，
 * 由于求平方的结果会很大，可能会超过int的取值范围，所以我们都用long long来定义变量，这样就不会越界，代码如下：

 解法一

 复制代码
 // Binary Search
 class Solution {
 public:
 int sqrt(int x) {
 long long left = 0, right = (x / 2) + 1;
 while (left <= right) {
 long long mid = (left + right) / 2;
 long long sq = mid * mid;
 if (sq == x) return mid;
 else if (sq < x) left = mid + 1;
 else right = mid - 1;
 }
 return right;
 }
 };

 *
 *
 */