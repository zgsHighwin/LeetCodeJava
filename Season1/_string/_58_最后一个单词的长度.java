package _string;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */
public class _58_最后一个单词的长度 {
    public static void main(String[] args) {
        System.out.println(new _58_最后一个单词的长度().lengthOfLastWord("Hello World"));
        System.out.println(new _58_最后一个单词的长度().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new _58_最后一个单词的长度().lengthOfLastWord("luffy is still joyboy"));
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                ++count;
            } else {
                if (count != 0) {
                    return count;
                }
            }

        }
        return count;
    }
}
