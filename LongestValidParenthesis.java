import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValidParentheses(String s) {
        int longValPar = 0;

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (!stk.empty()) {
                    longValPar = Math.max(longValPar, i - stk.peek());
                } else {
                    stk.push(i);
                }
            }
        }
        return longValPar;
    }

    public static void main(String[] args) {
        String s = "(()))(";
        System.out.println(longestValidParentheses(s));
    }
}




