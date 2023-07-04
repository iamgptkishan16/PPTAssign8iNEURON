/*QUESTION[2] Given a string s containing only three types of characters: '(', ')' and '*', return true *if* s *is **valid***.

The following rules define a **valid** string:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

**Example 1:**

**Input:** s = "()"

**Output:**

true*/

import java.util.Stack;
public class ValidStrings {
	public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.peek() > starStack.peek()) {
                return false;
            }
            leftStack.pop();
            starStack.pop();
        }
        
        return leftStack.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        ValidStrings solution = new ValidStrings();
	        String s = "()";
	        boolean isValid = solution.checkValidString(s);
	        System.out.println(isValid); // Output: true
	    

	}

}
