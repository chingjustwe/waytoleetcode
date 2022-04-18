package cn.com.nightfield.problems;

import java.util.Scanner;

/**
 * @author: zhochi
 * @create: 2021/12/29
 **/
public class SnakeMetric {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            StringBuilder builder = new StringBuilder();
            int base = 1;
            for (int i = 0; i < input; i++) {
                base += i;
                builder.setLength(0);
                builder.append(base);
                int prev = base;
                for (int step = i + 2; step <= input; step++) {
                    int current = prev + step;
                    prev = current;
                    builder.append(" " + current);
                }
                System.out.println(builder);
            }
        }
    }
}
