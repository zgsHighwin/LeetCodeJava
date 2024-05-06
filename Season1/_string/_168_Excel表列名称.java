package _string;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
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
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * <p>
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= columnNumber <= 231 - 1
 */
public class _168_Excel表列名称 {
    public static void main(String[] args) {
//        System.out.println((int)'A');//65
//        System.out.println((char)65);
//
        for (int i = 1; i <= 720; i++) {
            System.out.println(i + ":" + new _168_Excel表列名称().convertToTitle(i));
        }
//        System.out.println();
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(26));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(27));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(52));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(53));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(53));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(2147483647));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(703));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(27));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(701)); //ZY
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(702));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(728));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(15576));
        System.out.println(new _168_Excel表列名称().convertToTitle(943566));
//        System.out.println(new _168_Excel表列名称_X().convertToTitle(676));


    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0,(char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
