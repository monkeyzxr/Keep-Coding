/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?
 *
 */

//题意：給一個32 bits的int整數，反轉整數的bits。
//範例： 整數43261596 轉換成bits = 00000010100101000001111010011100，將bit反轉00111001011110000010100101000000再轉成整數964176192回傳
public class LC_190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            res = (res << 1) | (n & 1);
            n = (n >> 1);
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new LC_190_ReverseBits().reverseBits(43261596));

    }
}
