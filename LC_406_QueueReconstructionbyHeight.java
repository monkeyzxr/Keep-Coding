import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/8/22.
 *
 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */

//题目大意：假设有一队人随机站成一个圈。每个人通过一对整数(h, k)描述，其中h是其身高，k是站在他前面并且身高不低于他的人数。编写算法重构队列。

/*思路：http://www.cnblogs.com/grandyang/p/5928417.html
首先我们给队列先排个序，按照身高 高的 排前面，如果身高相同，则第二个数小的排前面。
然后我们新建一个空的数组，遍历之前排好序的数组，然后根据每个元素的第二个数字，将其插入到res数组中对应的位置
 */

//http://bookshadow.com/weblog/2016/09/25/leetcode-queue-reconstruction-by-height/
//http://www.jiuzhang.com/solutions/queue-reconstruction-by-height
public class LC_406_QueueReconstructionbyHeight {
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){ //如果第零个元素（index=0）相等，即如果身高相等
                    return o1[1] - o2[1]; // 按照 第一个元素的 升序排列,即人数按照升序排列
                }
                else {
                    return o2[0] - o1[0];  //按照 身高 降序排列
                }
            }
        });

        List<int[]> resultList = new LinkedList<>();
        for (int[] cur : people){
            //resultList.add(index, element);
            resultList.add(cur[1], cur);
        }

        return resultList.toArray(new int[people.length][]);




    }

    public static void main(String[] args) {

    }
}
