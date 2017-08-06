/**
 * Created by monkeyzxr on 2017/8/5.
 *
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 *
 */

/*
当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。

假定初始的盛水面积为ans=0，lh为左边的高度，rh为右边的高度，如果lh < rh, 则向右运动，寻找第一个比当前lh大的左节点。
同理，如果lh > rh，则向左运动，寻找第一个比当前rh大的右节点。

截止条件为坐标L >= R。
 */

/*http://bangbingsyb.blogspot.com/2014/11/leetcode-container-with-most-water.html
思路整理：
left = 0, right = n-1
(1) a[left] < a[right], left++
(2) a[left] > a[right], right--
(3) a[left] = a[right], left++, right--
终止条件：left>-right
 */

//http://www.jiuzhang.com/solutions/container-with-most-water/
public class LC_11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 0)
            return 0;

        int max = 0;
        int left = 0;   //代表heights的左右两端的index
        int right = height.length - 1;

        while (left < right){
            //更新max的值
            max = Math.max(max, (right-left)*Math.min(height[left], height[right])); //乘水的面积是由（两端较小的高度）×（两个板之间的宽度）

            if (height[left] < height[right])
                left++;
            else if (height[left] > height[right])
                right--;
            else {     //这个else 不要 也可以
                left++;
                right--;
            }
        }

        return max;


    }

    public static void main(String[] args) {
        int[] heights = {1,2,4,5,2,3,4,6};
        System.out.println(maxArea(heights));

    }
}
