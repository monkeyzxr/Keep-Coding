import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/5/22.
 *
 Given an array of integers and an integer k,
 you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2

 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */


//暴力搜索法，两个循环，但是由于负数的存在, 不能在碰到一个之后就break!
    /*
public class LC_560_SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = nums[i];

            if (nums[i] == k)
                count++;

            for(int j = i+1; j < nums.length; j++){
                sum = sum +nums[j];
                if (sum == k)
                    count++;
            }

        }
        return count;
    }

    public static void main(String [] args){
        int[] test1 = {1,1,1};
        System.out.println("The result is : "+ subarraySum(test1,2));

        int[] test2 = {0,0,0,0,0,0,0,0,0,0};
        System.out.println("The result is: " + subarraySum(test2,0));
    }
}
*/

// 方法2：用map ，还有 cumulative sum  big O是n。高效率！
// We store the data in the form: (sum_i, no. of occurences of sum_i)
public class LC_560_SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();  // map的key是sum，value是sum出现的次数。
        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];                 //make a cumulative sum

            //count必须是边生成sums，边count。必须放在这里。放别处都不对。
            if(map.containsKey(sum - k))
                count = count + map.get(sum - k);  // count 加上当前difference出现的次数。

            //时时update map: 更新sum出现的次数
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);//map的key就是sum，value就是sum出现的次数
            else
                map.put(sum, 1);

        }

       // System.out.println(map);
        //count不能放这里
        //这么些也不对！！！比如，test3，到这里sum=14。 14-7= 7，7一定在map里了。相当于循环9次来加7的次数。
      // for (int i = 0; i < nums.length; i++){
      //      if(map.containsKey(sum - k))
      //         count = count + map.get(sum-k);
       // }

        return count;

    }

    public static void main(String [] args){
        int[] test1 = {1,1,1};
        System.out.println("The result is : "+ subarraySum(test1,2));

        int[] test2 = {0,0,0,0,0,0,0,0,0,0};   // ten 0
        System.out.println("The result is: " + subarraySum(test2,0));

        int[] test3 = {3,4,7,2,-3,1,4,2,-6};
        System.out.println("The result is: " + subarraySum(test3,7));
    }
}