package exercise.stackAndQueue_0422;

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
示例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true
 */
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0; i<len ;i++){
            Character character = new Character(s.charAt(i));
            if(stack.empty()){
                stack.push(character);
            }else{
                if((character == ')'&& stack.peek() == '(') ||
                        (character == '}'&& stack.peek() == '{')||
                        (character == ']'&& stack.peek() == '[')){
                    stack.pop();
                }else{
                    stack.push(character);
                }
            }
        }
        return stack.empty();
    }
}