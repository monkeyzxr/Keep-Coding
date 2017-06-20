/**
 * Created by monkeyzxr on 2017/6/19.
 *
 Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True

 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False

 Note:
 The input array won't violate no-adjacent-flowers rule.
 The input array size is in the range of [1, 20000].
 n is a non-negative integer which won't exceed the input array size.
 *
 */
//从左向右遍历flowerbed，将满足要求的0设为1。计数与n比较即可。
    //在左右两端的0， 只看其相邻的一个是不是零，即可
    //在中间的0，要看其左右是不是都是零

/*
public class LC_605_CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0)
            return false;
        if (n == 0)
            return true;

        int count = 0;
        int len = flowerbed.length;

        if(len == 1){
            return flowerbed[0] == 0;
        }

        for (int i = 0; i < len; i++){

            if (flowerbed[i] == 0){

                if (i == 0 && flowerbed[i+1] == 0){  //如果i是第一位，是零
                    flowerbed[i] = 1;
                    count++;
                }
                else if (i == len-1 && flowerbed[i-1] == 0){  // 如果i是最后一位，是零
                    flowerbed[i] = 1;
                    count++;
                }
                else if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }

        }

        if (count >= n)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
      //  int[]test1 = {1,0,0,0,1};
      //  System.out.println(canPlaceFlowers(test1, 1));
       // System.out.println(canPlaceFlowers(test1, 2));

        int[]test2 = {0, 1, 0};
        System.out.println(canPlaceFlowers(test2, 1));



    }
}

*/

public class LC_605_CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null || flowerbed.length ==0)
            return false;

        if(n==0)
            return true;

        int len = flowerbed.length;

        if(len==1)
            return flowerbed[0]==0;

        int count=0;

        for(int i = 0;i<len;i++) {
            if(flowerbed[i]==0) {

                //注意：else if：就是第一个if不满足，就继续往下找第二个if。如果满足，就不再找了。
                if(i==0){  //这个if和下一行的if必须分开写，不能合并一起！！
                           // 例如【0， 1， 0】如果合并，遇见第一个0，右侧是1，不符合 && 的if，就会继续往下走，走到第3个else if，就会出界。这样不对
                    if(flowerbed[i+1]==0) {
                        flowerbed[i]=1;
                        count++;
                    }
                }

                else if(i==len-1){
                    if(flowerbed[i-1]==0) {
                        flowerbed[i]=1;
                        count++;
                    }
                }

                else if(flowerbed[i-1]==0 && flowerbed[i+1]==0) {
                    flowerbed[i]=1;
                    count++;
                }
            }
        }

        if (count >= n)
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        //  int[]test1 = {1,0,0,0,1};
        //  System.out.println(canPlaceFlowers(test1, 1));
        // System.out.println(canPlaceFlowers(test1, 2));

        int[]test2 = {0, 1, 0};
        System.out.println(canPlaceFlowers(test2, 1));



    }

}

