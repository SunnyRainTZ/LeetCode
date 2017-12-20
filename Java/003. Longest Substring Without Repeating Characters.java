/*
Given a string, find the length of the longest substring without repeating characters.
Examples:
  Given "abcabcbb", the answer is "abc", which the length is 3.
  Given "bbbbb", the answer is "b", with the length of 1.
  Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
  "pwke" is a subsequence and not a substring.
*/

//思路：维护一个不包含重复字符的队列。
//遍历字符串的每一个字符，如果字符不在队列内，则将字符入队，若队列长度大于当前最大长度则更新最大长度。
//如果字符在队列内，则队列内的该字符到队头之间的字符全部出队，并将该字符入队。

//易错点：字符在队列内时出队操作完成后该字符也要入队

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int maxLength = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(!queue.contains(s.charAt(i))){
            	queue.add(s.charAt(i));
                if(queue.size() > maxLength){
                    maxLength = queue.size();
                }
            }else{
                while(queue.poll() != s.charAt(i)){}
                queue.add(s.charAt(i));
            }
        }
        return maxLength;
    }
}

//别人的思路：j指向重复字符的下一个位置，HashMap存储字符-位置键值对，利用get方法快速获得重复字符的位置并更新j。
public int lengthOfLongestSubstring(String s) {
    if (s.length()==0) return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    for (int i=0, j=0; i<s.length(); ++i){
        if (map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
        }
        map.put(s.charAt(i),i);
        max = Math.max(max,i-j+1);
    }
    return max;
}



