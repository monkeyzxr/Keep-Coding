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
    /*
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

*/


    //我重新写：
    //成功：
    /*
public class LC_125_ValidPalindrome {
    public static boolean equal(char x, char y) {
        if (x == y) return true;
        if (((x <= '9') && (x >= '0')) || ((y <= '9') && (y >= '0'))) return false;
        if (Math.abs(x - y) == Math.abs('A' - 'a')) return true;
        return false;
    }

    public static boolean valid(char x) {
        if (((x <= 'z') && (x >= 'a')) || ((x <= 'Z') && (x >= 'A')) || ((x <= '9') && (x >= '0'))) return true;
        return false;
    }

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) return true;

        int lo = 0;
        int hi = s.length() - 1;
        while ((lo < s.length()) && (hi >= 0)){
            while ((lo < s.length()) && !valid(s.charAt(lo))) lo++;
            while ((hi >= 0)         && !valid(s.charAt(hi))) hi--;
            if ((lo == s.length()) || (hi == -1)) break;
            if (!equal(s.charAt(lo++), s.charAt(hi--))) return false;
        }
        return true;



    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));

    }
}
*/

    //网上做法：用正则表达式
public class LC_125_ValidPalindrome {

    public static boolean isPalindrome(String s) {
        //[...]	Matches any single character in brackets.
        //[^...]	Matches any single character not in brackets.
        String regex = "([^A-Za-z0-9])";
        String replacement = "";
        s = s.replaceAll(regex, replacement);  //把s中的所有非A-Za-z0-9的，都替换成""
        for(int i =0;i<s.length()/2;i++){
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(s.length()-1-i)))
                continue;
            else
                return false;
        }
        return true;


    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));

    }
}


