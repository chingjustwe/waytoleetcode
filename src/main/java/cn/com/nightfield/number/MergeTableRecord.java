package cn.com.nightfield.number;

import java.util.*;

/**
 * 描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 *
 * 先输入键值对的个数n（1 <= n <= 500）
 * 然后输入成对的index和value值，以空格隔开
 * 输出描述：
 *
 * 输出合并后的键值对（多行)
 *
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&&tqId=21231&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class MergeTableRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        // merge value by key, tree map can handle sorting
        Map<Integer, Integer> numMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            int key = sc.nextInt();
            int value = numMap.getOrDefault(key, 0);
            value += sc.nextInt();
            numMap.put(key, value);
        }

        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
