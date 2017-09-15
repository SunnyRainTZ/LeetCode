/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
思路：用栈匹配

    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put(')','x');
        map.put('}','x');
        map.put(']','x');
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                if(s.charAt(i)==map.get(stack.peek())){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
    
1、stack的API不熟悉
      stack.add();
      stack.peek();
      stack.pop();
      stack.isEmpty();
      stack.size();
2、一开始没考虑 )}] 的map.get为空不能和char进行相等判断的问题。所以后在map内添加了}])
3、s.charAt()返回一个char，不能用equals进行判等
    
    
简短的代码：
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}



    
    
