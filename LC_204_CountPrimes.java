import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/28.
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 */


//https://unnamed42.github.io/2015-12-03-Leetcode-204-Count-Primes.html
//方法1：最简单粗暴的解法就是从1到n−1对每一个数都判断一次是否是质数：
// isPrime(n)是O(n)级别的时间复杂度，那么countPrimes(n)就是O(n2)级别

    /*
public class LC_204_CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++){
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public static boolean isPrime(int n){
        if (n <= 1)  //1 不是质数，最小的质数是2
            return false;

        for (int i = 2; i < n; i++){  //验证的这个数，从2开始到n-1,依次除以，如果能被区间里的任何一个数整除，那它就不是质数！
            if (n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107
        System.out.println(countPrimes(10));
    }
}

*/


//方法2：循环条件只需i≤ sqrt（n）
// 提交Leetcode报错：Time Limit Exceeded
// 所以不能用这个方法
    /*
public class LC_204_CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++){
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public static boolean isPrime(int n){
        if (n <= 1)  //1 不是质数，最小的质数是2
            return false;

        for (int i = 2; i <= Math.sqrt((double)n); i++){  //验证的这个数，从2开始到n-1,依次除以，如果能被区间里的任何一个数整除，那它就不是质数！
            if (n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107
        System.out.println(countPrimes(20));
    }
}
*/

//方法3：埃拉托斯特尼筛法
// https://unnamed42.github.io/2015-12-03-Leetcode-204-Count-Primes.html
//其算法是，给出要筛数值的范围n, 找出 根号n 以内的素数p1,p2,…,pk. 先用2去筛，即把2留下，把2的倍数剔除掉；
// 再用下一个素数，也就是3筛，把3留下，把3的倍数剔除掉；
// 接下去用下一个素数5筛，把5留下，把5的倍数剔除掉；不断重复下去。

//https://segmentfault.com/a/1190000003709122
//时间 O(NloglogN) 空间 O(N)
public class LC_204_CountPrimes {
    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];

        // assigns the specified value to each element of the specified array
        Arrays.fill(prime,true);

        for (int i = 2; i < n; i++){ //从2开始check
            if (prime[i]){
                //// 将i的2倍、3倍、4倍...都标记为非素数
                for (int j = i*2; j < n; j = j+i){ //j为i的倍数，初始是2倍，然后是3倍，4倍, 5倍......
                    prime[j] = false; //把i的倍数都标记倍false
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++){
            if (prime[i])
                count++;
        }

        return count;
    }


    public static void main(String[] args) {
        //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107
        System.out.println(countPrimes(20));
    }
}


