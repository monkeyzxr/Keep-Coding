import java.util.Arrays;
import java.util.Collections;

/**
 * Created by monkeyzxr on 2017/8/4.
 *
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia:
 "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */

/*
h-index定义如下：
一个学者发表的n篇论文中，他有h篇被引用至少h次，而其他的n-h篇被引用次数都不超过h。
 */


/*方法：
从高到底排序，然后对排完序的数组扫描。
对于i，h-index为min(i,citations[i])
 */


//https://www.hrwhisper.me/leetcode-h-index-h-index-ii/
public class LC_274_HIndex {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations);  //升序排列

        int n = citations.length;
        for (int i = 0; i < n; i++){   // 0 1 3 5 6
            if (citations[i] >= n-i){   //n – i 是大于引用数citations[i]的个数。对于i，h-index 为min(n – i,citations[i])
                return n-i;

            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int [] test = {3,0,6,1,5};
        System.out.println(hIndex(test));

    }
}


/*

http://www.programcreek.com/2014/05/leetcode-h-index-java/

public int hIndex(int[] citations) {
    Arrays.sort(citations);

    int result = 0;
    for(int i=0; i<citations.length; i++){
        int smaller = Math.min(citations[i], citations.length-i);
        result = Math.max(result, smaller);
    }

    return result;
}
 */


/*https://www.hrwhisper.me/leetcode-h-index-h-index-ii/
如果是降序排列：

public:
	int hIndex(vector<int>& citations) {
		sort(citations.begin(), citations.end(),greater<int>());
		for (int i = 0; i < citations.size(); i++)
			if (i >= citations[i])
				return i;
		return citations.size();
	}
};
 */