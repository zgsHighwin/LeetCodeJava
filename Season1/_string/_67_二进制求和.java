package _string;


/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */

public class _67_二进制求和 {
    public static void main(String[] args) {
//        System.out.println('0' + '1');
//        System.out.println('1'+'1');
//        System.out.println('0');

//        System.out.println((int)'2');
//        System.out.println((int)'0');
//        System.out.println((int)'1');
//        System.out.println('1' + '1'); //98
//        System.out.println('0' + '1'); //97
//        System.out.println('0' + '0'); //96

        System.out.println(new _67_二进制求和().addBinary("11", "1"));
        System.out.println(new _67_二进制求和().addBinary("1010", "1011"));

        System.out.println(new _67_二进制求和().addBinary("0", "0")); // Expected output: "0"
        System.out.println(new _67_二进制求和().addBinary("0", "1")); // Expected output: "1"
        System.out.println(new _67_二进制求和().addBinary("1", "0")); // Expected output: "1"
        System.out.println(new _67_二进制求和().addBinary("1", "1")); // Expected output: "10"
        System.out.println(new _67_二进制求和().addBinary("10", "10")); // Expected output: "100"
        System.out.println(new _67_二进制求和().addBinary("101", "110")); // Expected output: "1011"
        System.out.println(new _67_二进制求和().addBinary("1111", "1111")); // Expected output: "11110"
        System.out.println(new _67_二进制求和().addBinary("10101", "10101")); // Expected output: "101010"
        System.out.println(new _67_二进制求和().addBinary("101010", "101010")); // Expected output: "1010100"
        System.out.println(new _67_二进制求和().addBinary("1010101", "1010101")); // Expected output: "10101010"
        System.out.println(new _67_二进制求和().addBinary("10101010", "10101010")); // Expected output: "101010100"
        System.out.println(new _67_二进制求和().addBinary("101010101", "101010101")); // Expected output: "1010101010"
        System.out.println(new _67_二进制求和().addBinary("1010101010", "1010101010")); // Expected output: "10101010100"
        System.out.println(new _67_二进制求和().addBinary("10101010101", "10101010101")); // Expected output: "101010101010"
        System.out.println(new _67_二进制求和().addBinary("101010101010", "101010101010")); // Expected output: "1010101010100"
        System.out.println(new _67_二进制求和().addBinary("1010101010101", "1010101010101")); // Expected output: "10101010101010"
        System.out.println(new _67_二进制求和().addBinary("10101010101010", "10101010101010")); // Expected output: "101010101010100"
        System.out.println(new _67_二进制求和().addBinary("101010101010101", "101010101010101")); // Expected output: "1010101010101010"
        System.out.println(new _67_二进制求和().addBinary("1010101010101010", "1010101010101010")); // Expected output: "10101010101010100"
        System.out.println(new _67_二进制求和().addBinary("10101010101010101", "10101010101010101")); // Expected output: "101010101010101010"


    }

    public String addBinary(String a, String b) {
        char[] targetChar = new char[(a.length() > b.length() ? a.length() : b.length()) + 1];


        boolean isAdd = false;
        for (int i = targetChar.length - 1, j = 0; i >= 0; i--, j++) {
            if (a.length() - 1 - j >= 0 && b.length() - 1 - j >= 0) {
                char aC = a.charAt(a.length() - 1 - j);
                char bC = b.charAt(b.length() - 1 - j);
                if (aC + bC == 96) {
                    targetChar[i] = isAdd ? '1' : '0';
                    isAdd = false;
                } else if (aC + bC == 97) {
                    targetChar[i] = isAdd ? '0' : '1';
                } else if (aC + bC == 98) {
                    targetChar[i] = isAdd ? '1' : '0';
                    isAdd = true;
                }
            } else {
                if (a.length() == b.length() && isAdd) {
                    targetChar[0] = '1';
                    return new String(targetChar);
                }

                if (a.length() - 1 - j >= 0) {
                    char kA = a.charAt(a.length() - 1 - j);
                    if (kA == '0') {
                        targetChar[i] = isAdd ? '1' : '0';
                        isAdd = false;
                    } else {
                        targetChar[i] = isAdd ? '0' : '1';
                        if (!isAdd) {
                            isAdd = false;
                        }
                    }
                } else if (b.length() - 1 - j >= 0) {
                    char kb = b.charAt(b.length() - 1 - j);
                    if (kb == '0') {
                        targetChar[i] = isAdd ? '1' : '0';
                        isAdd = false;
                    } else {
                        targetChar[i] = isAdd ? '0' : '1';
                        if (!isAdd) {
                            isAdd = false;
                        }
                    }
                } else {
                    if (isAdd) {
                        targetChar[0] = '1';
                    }
                }
            }
        }
        return new String(targetChar, isAdd ? 0 : 1, targetChar.length - (isAdd ? 0 : 1));
    }

}
