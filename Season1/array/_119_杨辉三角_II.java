package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= rowIndex <= 33
 */
public class _119_杨辉三角_II {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            System.out.println(new _119_杨辉三角_II().getRow(i));
        }
    }
    public List<Integer> getRow(int rowIndex) {
        //特殊情况
        List<List<Integer>> target = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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
        return target.get(rowIndex);
    }
}
