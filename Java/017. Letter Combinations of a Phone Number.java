/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

/*
思路：用递归实现：结果等于digits.substring(1,digits.length())的结果前面依次加上第一个数字对应的字母。
利用<数字，字符串>的map来获得数字对应的字符串。
*/
class Solution {
    static Map<Character,String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();  
        if(digits.length() == 1){
            String s = map.get(digits.charAt(0));
            for(int i = 0; i < s.length() ; i++){
                result.add(s.charAt(i) + "");
            }
            return result;
        }    
        List<String> list = letterCombinations(digits.substring(1,digits.length()));
        String s = map.get(digits.charAt(0));
        for(int i = 0; i < s.length() ; i++){
            for(int j = 0; j < list.size() ; j++){
                result.add(s.charAt(i) + list.get(j));
            }
        }
        return result;
    }
}

/*
另一种思路：用先进先出队列，对第一个数字，将其对应的字符依次放入队列内，然后对第二个数字，将队列内的字符出队，组成新的长度加一的字符串，然后再入队。
直到队列内长度为1的字符串全部出队完毕。
例如：对于"23":
2：
  对应字符入队:c b a
3:
  a出队构造后再入队：af ae ad c b
  b出队构造后再入队: bf be bd af ae ad c
  c出队构造后再入队：cf ce cd bf be bd af ae ad
  此时发现队头字符串长度为2，则停止
*/
 public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}




