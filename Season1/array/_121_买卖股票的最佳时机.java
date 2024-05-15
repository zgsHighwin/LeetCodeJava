package array;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{1, 5, 0, 6}));
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{3, 6, 1, 4}));
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{2, 4, 1})); // Expected output: 2
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{3, 2, 6, 5, 0, 3})); // Expected output: 4
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{7, 6, 4, 3, 1})); // Expected output: 0
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{1, 2})); // Expected output: 1
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7})); // Expected output: 8

        // 1 5 0 6

        // 3 6 1 4
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int stackIndex = 0;
        int[] stack = new int[prices.length];
        stack[stackIndex] = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > stack[stackIndex]) {
                //如果都大于则直接放
                stack[++stackIndex] = prices[i];
            } else {
                if (stackIndex == 0) {
                    stack[0] = prices[i];
                    continue;
                }
                if (stack[0] > prices[i]) {
                    int diff = (stack[stackIndex] - stack[0]);
                    max = max > diff ? max : diff;
                    stack[0] = prices[i];
                    stackIndex = 0;
                }


            }
        }
        max = max>stack[stackIndex]-stack[0]?max:stack[stackIndex]-stack[0];
        return max;
    }


    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int firstValue = prices[0];
        int currentMax = firstValue;
        int max = 0;

        for(int i =1;i<prices.length;i++){
            if(prices[i]>currentMax){
                currentMax = prices[i];
            }else{
                if(prices[i]<firstValue){
                    max = max>(currentMax-firstValue)?max:(currentMax-firstValue);
                    firstValue = prices[i];
                    currentMax = firstValue;
                }
            }
        }
        max = (max>currentMax-firstValue)?max:(currentMax-firstValue);
        return max;
    }
}
