/**
 * Created by monkeyzxr on 2017/6/7.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 *
 */


//http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
    //https://www.liuchuo.net/archives/1136
    //思路简单：但是我写的一直报错。没找出原因。
public class LC_125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int left = 0;
        int right = s.length()-1;
       // System.out.println(left + " " + right);
       // char[] array = s.toCharArray();

        //static boolean  isLetterOrDigit(char ch)
       // Determines if the specified character is a letter or digit.
        while(left < right){

            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right){
                left++;
            }
           // while (!Character.isLetterOrDigit(array[left]) && left < right){
            //    left++;
          //  }


            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left--;
            right++;
        }

        return true;

    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(isPalindrome(s1));
        //System.out.println(isPalindrome(s2));

    }
}


