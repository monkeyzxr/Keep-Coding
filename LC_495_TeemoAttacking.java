/**
 * Created by monkeyzxr on 2017/5/23.
 In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
 you need to output the total time that Ashe is in poisoned condition.

 You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.

 Example 1:
 Input: [1,4], 2
 Output: 4
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 This poisoned status will last 2 seconds until the end of time point 2.
 And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 So you finally need to output 4.

 Example 2:
 Input: [1,2], 2
 Output: 3
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
 This poisoned status will last 2 seconds until the end of time point 2.
 However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
 Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
 So you finally need to output 3.

 Note:
 You may assume the length of given time series array won't exceed 10000.
 You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.
 */

//比较相邻两个时间点的时间差，如果小于duration，就加上这个差，如果大于或等于，就加上duration即可
// example2中，第二次中毒，已经算是第一次中毒的第一秒了
// 见笔记
public class LC_495_TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;  // 必须check ，看test3

        int result = 0;

        for(int i = 1; i < timeSeries.length; i++){   //time start from 1
            int diff = timeSeries[i] - timeSeries[i-1];
            if (diff >= duration)
                result += duration;
            else
                result += diff;
        }
        return result + duration; //第一次肯定是中毒了，所以把第一次的duration加上

    }

    public static void main(String[] args) {
        int[]test1 = {1,4};
        System.out.println(findPoisonedDuration(test1, 2));

        int[]test2 = {1,2};
        System.out.println(findPoisonedDuration(test2, 2));

        int[]test3 = {};
        System.out.println(findPoisonedDuration(test3, 100000));

        int[]test4 = {1,3};
        System.out.println(findPoisonedDuration(test4, 5));

    }
}
