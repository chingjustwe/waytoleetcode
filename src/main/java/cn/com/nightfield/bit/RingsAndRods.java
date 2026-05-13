package cn.com.nightfield.bit;

/**
 * 总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分布穿在 10 根编号为 0 到 9 的杆上。
 *
 * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
 *
 *     第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
 *     第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
 *
 * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
 *
 * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量。
 *
 * 链接：https://leetcode-cn.com/problems/rings-and-rods
 *
 * 思路：
 * 1. 新建长度为 **10** 的数组代表杆子（可用 `Map` 代替）。
 * 2. 将 `R` `G` `B` 都定义为**位操作**，同时定义 **4** 个 mask，分别对应 `R` `G` `B` 和 `全部`。
 * 3. 遍历 `rings` 字符串
 *     1. 根据当前颜色获取相应的 mask。
 *     2. 找到杆子（数组）位置。
 *     3. 上述两个值进行**或（`or`）** 操作，更新数组的值。
 * 4. 遍历杆子数组，和 `maskAll` 按位**与（`and`）**操作，统计 `R` `G` `B` 三位齐全的杆子数量。
 *
 * @author: zhochi
 * @create: 2022/4/25
 **/
public class RingsAndRods {
    private static byte maskR = 0b0001;
    private static byte maskG = 0b0010;
    private static byte maskB = 0b0100;
    private static byte maskAll = 0b0111;

    public int countPoints(String rings) {
        byte[] array = new byte[10];

        for (int i = 0; i < rings.length(); i += 2) {
            byte currentValue;
            if (rings.charAt(i) == 'R') {
                currentValue = maskR;
            }
            else if (rings.charAt(i) == 'G') {
                currentValue = maskG;
            }
            else {
                currentValue = maskB;
            }
            array[rings.charAt(i+1) - '0'] |= currentValue;
        }

        int result = 0;
        for (byte b : array) {
            if ((b & maskAll) == maskAll) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new RingsAndRods().countPoints("B0B6G0R6R0R6G9");
    }
}
