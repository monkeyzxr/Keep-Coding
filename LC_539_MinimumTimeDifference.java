import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/6.
 *
 Given a list of 24-hour clock time points in "Hour:Minutes" format,
 find the minimum minutes difference between any two time points in the list.

 Example 1:
 Input: ["23:59","00:00"]
 Output: 1

 Note:
 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.
 *
 */

//http://blog.csdn.net/Cloudox_/article/details/63684741

    /*
要找到最小的两个时间的时间差，这个差值是以分钟数表示的，
为了计算方便，我们写一个函数来将所有给出的24小时制时间全部改成分钟表示，比如 1:30 用全分钟数来表示就90分钟，这样我们计算时间差就很方便，要排序也很方便。

全部转换成分钟数后，我们放在一个int型数组里，对数组排序，
这样我们就可以按照 排完序后的顺序去两两比较时间点之间的时间差，看哪个时间差最小，记录下来，
要注意的一点是最后一个时间要用24小时的分钟数减去他然后加上第一个时间点的时间差，得到最后一个时间点和第一个时间点的时间差
//（就是第一和最后，两个时间点，可以顺时针找时间差，也可以逆时针找时间差。 只能逆时针找时间差，因为顺时针的第一和最后时间差，肯定是最大了）
     */

public class LC_539_MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = toMinutes(timePoints.get(i));
        }

        Arrays.sort(arr);

        //把res 初始化成最后的时间点和第一个时间点的差值。把排序好的数组里的时间差 都和它比较大小
        int res = 24 * 60 - arr[arr.length-1] + arr[0];

        for (int i = 0; i < arr.length-1; i++){
            if (arr[i+1] - arr[i] < res)
                res = arr[i+1] - arr[i];
        }

        return res;
    }

    public static int toMinutes(String time){
        String[] arr = time.split(":");
        int a = Integer.valueOf(arr[0]) * 60;
        int b = Integer.valueOf(arr[1]);

        return  a + b;

    }

    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");

        System.out.println(findMinDifference(list));

    }
}
