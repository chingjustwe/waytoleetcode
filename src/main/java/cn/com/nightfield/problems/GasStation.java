package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/gas-station
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 **/
public class GasStation {
    public int solution(int[] gas, int[] cost) {
        int size = gas.length;
        outer: for (int i = 0; i < size; i++) {
            int remainingGas = 0;
            for (int j = 0; j < size; j++) {
                int index = (i + j) % size;
                remainingGas += gas[index];
                if (remainingGas < cost[index]) {
                    continue outer;
                }
                remainingGas -= cost[index];
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        gasStation.solution(gas, cost);
    }
}
