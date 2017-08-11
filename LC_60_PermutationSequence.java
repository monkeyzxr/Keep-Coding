/**
 * Created by monkeyzxr on 2017/8/10.
 *
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

     1. "123"
     2. "132"
     3. "213"
     4. "231"
     5. "312"
     6. "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */


//本题用backtracking 会超时间
    //找规律

    //http://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
    //http://www.jiuzhang.com/solutions/permutation-sequence/
    //http://www.cnblogs.com/yrbbest/p/4436392.html

    //没仔细想：好好想想！！
public class LC_60_PermutationSequence {
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k-1;
        int factor = 1;

        for (int i = 1; i < n; i++){
            factor *= i;
        }

        for (int i = 0; i < n; i++){
            int index = k / factor;
            k = k % factor;

            for (int j= 0; j < n; j++){
                if (used[j] == false){
                    if (index == 0){
                        used[j] = true;
                        sb.append((char)('0'+j+1));
                        break;
                    }
                    else {
                        index--;
                    }
                }
            }
            if (i < n-1){
                factor = factor/(n-1-i);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,5));

    }
}
