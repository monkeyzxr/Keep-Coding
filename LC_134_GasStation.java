/**
 * Created by monkeyzxr on 2017/9/4.
 *
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 *
 */

//题意：在一个环形的路径上，有 n 个加油站。
// 每个加油站 i 有汽油 gas[i] ，从 i 行驶到下一个加油站需要耗油 cost[i]，汽车的油箱没有限制。
// 找出一个加油站，从该加油站能走完整个环形路径。其中，本题目只有唯一一个解。

/*https://www.programcreek.com/2014/03/leetcode-gas-station-java/
思路：
    To solve this problem, we need to understand and use the following 2 facts:
1) if the sum of gas >= the sum of cost, then the circle can be completed.
2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.


     */
public class LC_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start= 0;

        for (int i = 0; i < gas.length; i++){
            int remaining = gas[i] - cost[i];

            if (sumRemaining >= 0){ //if sum remaining of (i-1) >= 0, continue
                sumRemaining += remaining;
            }
            else { //otherwise, reset start index to be current
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }
        else {
            return -1;
        }

    }

    public static void main(String[] args) {

    }
}
