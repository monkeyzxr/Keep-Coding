/**
 * Created by monkeyzxr on 2017/6/13.
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


//我自己写，正确
public class LC_278_FirstBadVersion {
    /*
    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = low + (high - low)/2;
           if (isBadVersion(mid) == true && isBadVersion(mid-1) == false)
               return mid;

           else if (isBadVersion(mid) == true && isBadVersion(mid-1) == true)
               high = mid - 1;

           else if (isBadVersion(mid) == false)
               low = mid + 1;

        }
        return low;
    }
    */

    public static void main(String[] args) {

    }
}


/*
网上的思路：
http://blog.csdn.net/xudli/article/details/48286081

[思路]
其实就是二分查找 有重复, 找下界的问题.

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=1, high=n;

        while(low<high) {
            int mid=low + (high-low)/2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}



 */
