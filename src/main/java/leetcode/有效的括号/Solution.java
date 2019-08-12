package leetcode.有效的括号;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串
     * 题目上限定了 只包括 '('，')'，'{'，'}'，'['，']'
     * 因此可以取巧直接用replace
     * <p>
     * 但是常规方法应该用栈，右括号入栈，遇到左括号的时候出栈
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        int len = 0;
        while (len != s.length()) {
            len = s.length();
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        if (s.trim().equals("")) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        //        System.out.println(isValid("()"));
        //        System.out.println(isValid("()[]{}"));
        //        System.out.println(isValid("(]"));
        //        System.out.println(isValid("([)]"));
        //        System.out.println(isValid("{[]}"));


        //        System.out.println(isValid2("()"));
        //        System.out.println(isValid2("()[]{}"));
        //        System.out.println(isValid2("(]"));
        //        System.out.println(isValid2("([)]"));
        //        System.out.println(isValid2("{[]}"));
        System.out.println(isValid2("()"));

    }


    /**
     * 使用栈的方法  右括号入栈 遇到左括号的时候判断下栈顶元素是不是对应的当前括号的右括号 是就出栈 最后看栈是否为空
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }


            if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                //如果三种情况不匹配的话 直接返回false
                if (peek.equals('(') && c == ')') {
                    stack.pop();
                }else if (peek.equals('[') && c == ']') {
                    stack.pop();
                }else if (peek.equals('{') && c == '}') {
                    stack.pop();
                }else {
                    return false;
                }

            }


        }

        return stack.empty();
    }

}
