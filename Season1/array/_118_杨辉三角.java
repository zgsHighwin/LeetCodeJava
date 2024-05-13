package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 */
public class _118_杨辉三角 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println(new _118_杨辉三角().generate(i));
        }
    }

    public List<List<Integer>> generate(int numRows) {

        //特殊情况
        List<List<Integer>> target = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentLine = new ArrayList<>();
            if (i == 0) {
                currentLine.add(1);
                target.add(currentLine);
            } else if (i == 1) {
                currentLine.add(1);
                currentLine.add(1);
                target.add(currentLine);
            } else {
                List<Integer> lastLine = target.get(target.size() - 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        currentLine.add(1);
                    } else {
                        currentLine.add(lastLine.get(j - 1) + lastLine.get(j));
                    }
                }
                target.add(currentLine);
            }
        }
        return target;
    }
}
