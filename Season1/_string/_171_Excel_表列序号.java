package _string;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
public class _171_Excel_表列序号 {
    public static void main(String[] args) {
        for (int i = 1; i <= 500; i++) {
            System.out.println(new _171_Excel_表列序号().titleToNumber(new _168_Excel表列名称().convertToTitle(i)));
        }
        System.out.println(new _171_Excel_表列序号().titleToNumber("A"));
        System.out.println(new _171_Excel_表列序号().titleToNumber("Z"));
        System.out.println(new _171_Excel_表列序号().titleToNumber("AA"));
        System.out.println(new _171_Excel_表列序号().titleToNumber("AB"));
        System.out.println(new _171_Excel_表列序号().titleToNumber("AC"));
    }
    public int titleToNumber(String columnTitle) {
//        char[] charArray = columnTitle.toCharArray();

        int result = 0;
        for (int i = 0, k = columnTitle.length() - 1; i < columnTitle.length(); i++, k--) {

            result += (columnTitle.charAt(k) + 1 - 'A') * Math.pow(26, i);
        }
        return result;
    }
}
