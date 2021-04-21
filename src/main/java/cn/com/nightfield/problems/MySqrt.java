package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/20
 **/
public class MySqrt {
    public int solution(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right = x, middle;
        while (left < right - 1) {
            middle = left + ((right - left) >> 1);
            if (middle > x / middle) {
                right = middle;
            }
            else {
                left = middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.solution(1));
        System.out.println(mySqrt.solution(2));
        System.out.println(mySqrt.solution(3));
        System.out.println(mySqrt.solution(7));
        System.out.println(mySqrt.solution(40));
    }
}
