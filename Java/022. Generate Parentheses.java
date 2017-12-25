/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
  [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
  ]
*/

/*
思路：相当于一颗二叉树，根节点为"("，两个子节点为"("和")"，树的深度为2*n，然后对该二叉树做深度优先搜索--回溯。
有两个限制条件：a."("的数目小于n   b.")"的数目小于"("的数目
从而导出两个剪枝条件：a.子节点"("的数目大于n时不用继续搜索   b.子节点")"的数目大于"("的数目时不用搜索
优化：不用字符串拼接，改为StringBuilder提升效率
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}





