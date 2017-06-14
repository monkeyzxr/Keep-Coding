/**
 * Created by monkeyzxr on 2017/6/13.
 *
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

 Example:
 n = 10, I pick 6.

 Return 6.
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */




//http://www.programcreek.com/2014/07/leetcode-guess-number-higher-or-lower-java/
    //http://www.cnblogs.com/grandyang/p/5666502.html



//二分查找法：必须是排过序的
public class LC_374_GuessNumberHigherLower  {
    /*
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = low + (high - low)/2;
            int result = guess(mid);
            if (result == 0)
                return mid;
            else if (result == 1)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
*/
    public static void main(String[] args) {

    }
}
