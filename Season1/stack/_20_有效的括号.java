package stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(new _20_有效的括号().isValid("()"));
        System.out.println(new _20_有效的括号().isValid("()[]{}"));
        System.out.println(new _20_有效的括号().isValid("(]"));
        System.out.println(new _20_有效的括号().isValid("{(]}"));
        System.out.println(new _20_有效的括号().isValid("}[(]]"));
        System.out.println(new _20_有效的括号().isValid("[[[(]]]"));
        System.out.println(new _20_有效的括号().isValid("[[[()]]]"));

    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }

        int curIndex = 0;

        char[] stack = new char[s.length()];

        char[] charArray = s.toCharArray();

        int charIndex = 0;
        while (charIndex <= charArray.length - 1) {

            char eachChar = charArray[charIndex];

            //第一个是反向直接返回不是
            if (curIndex == 0 && (s.charAt(charIndex) == ')' || s.charAt(charIndex) == ']' || s.charAt(charIndex) == '}')) {
                return false;
            }

            if (eachChar == '(' || eachChar == '[' || eachChar == '{') {
                stack[curIndex++] = eachChar;
            } else {
                if (eachChar == ')') {
                    if (stack[curIndex - 1] == '(') {
                        stack[--curIndex] = '\0';
                    } else {
                        stack[curIndex++] = eachChar;
                    }
                }
                if (eachChar == ']') {
                    if (stack[curIndex - 1] == '[') {
                        stack[--curIndex] = '\0';
                    } else {
                        stack[curIndex++] = eachChar;
                    }
                }
                if (eachChar == '}') {
                    if (stack[curIndex - 1] == '{') {
                        stack[--curIndex] = '\0';
                    } else {
                        stack[curIndex++] = eachChar;
                    }
                }
            }
            charIndex++;
        }
        return curIndex == 0;
    }
}
