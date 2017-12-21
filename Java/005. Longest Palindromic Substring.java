/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
  Input: "babad"
  Output: "bab"
Note: "aba" is also a valid answer.
Example:
  Input: "cbbd"
  Output: "bb"
*/

//思路：遍历每一个字符，对每个字符向左向右同时拓展判断两边的字符是否相同。
//具体有两种拓展方式：1、回文串长度为奇数。2、回文串长度为偶数。
class Solution {  
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }
}



