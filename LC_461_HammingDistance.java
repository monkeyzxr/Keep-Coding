/**
 * Created by monkeyzxr on 2017/5/20.
 *
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 *
 *
 */
public class LC_461_HammingDistance {
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;       // ^ in Java is the exclusive-or ("xor") operator.
        return Integer.bitCount(xor);

        // Integer.bitCount(int i).
        // This method simply converts the int parameter into binary string and then returns the number of one’s bits
        // 就是数二进制中的1的个数
    }

    public static void main(String[] args) {
        int result = hammingDistance(1,4);
        System.out.println(hammingDistance(1,4));
    }

}
