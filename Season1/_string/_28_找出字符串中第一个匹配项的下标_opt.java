package _string;


/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class _28_找出字符串中第一个匹配项的下标_opt {
    public static void main(String[] args) {
        System.out.println(new _28_找出字符串中第一个匹配项的下标_opt().strStr("leetcode", "leeto"));
        System.out.println(new _28_找出字符串中第一个匹配项的下标_opt().strStr("sadbutsad", "sad"));
        System.out.println(new _28_找出字符串中第一个匹配项的下标_opt().strStr("sadsadsa", "dsad"));
        System.out.println(new _28_找出字符串中第一个匹配项的下标_opt().strStr("sadsdsadsda", "dsad"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] startIndexArray = new int[haystack.length()];
        int curIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() <= haystack.length()) {
                    startIndexArray[curIndex++] = i;
                } else {
                    break;
                }
            }
        }

        if (startIndexArray.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int hay = startIndexArray[startIndex];
        int count = 0;
        while (hay < haystack.length()) {
            if (haystack.charAt(hay) == needle.charAt(count)) {
                count++;
            } else {
                //如果不相同则count初始化，使用下一下count
                count = 0;
                if (startIndex + 1 < startIndexArray.length) {
                    hay = startIndexArray[++startIndex];
                    continue;
                } else {
                    return -1;
                }
            }
            if (count == needle.length()) {
                return startIndexArray[startIndex];
            }
            hay++;
        }
        return -1;
    }
}
