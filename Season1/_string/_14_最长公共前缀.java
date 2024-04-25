package _string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class _14_最长公共前缀 {


    public static void main(String[] args) {
        System.out.println(new _14_最长公共前缀().longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }));

        System.out.println(new _14_最长公共前缀().longestCommonPrefix(new String[]{
                "dog","racecar","car"
        }));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
            }
        }
        if (min == 0) {
            return "";
        }

        StringBuilder longPrefix = new StringBuilder();

        for (int i = 0; i < min; i++) {
            char curChar = '1';
            for (int j = 0; j < strs.length; j++) {
                char eachChar = strs[j].charAt(i);
                if (curChar == '1') {
                    curChar = eachChar;
                } else {
                    if (curChar != eachChar) {
                        curChar = '1';
                        break;
                    }
                }
            }
            if (curChar == '1') {
                return longPrefix.toString();
            } else {
                longPrefix.append(curChar);
            }
        }
        return longPrefix.toString();
    }
}
