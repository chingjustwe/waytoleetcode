package cn.com.nightfield.brainteaser;

/**
 * @author: zhochi
 * @create: 2021/2/1
 *
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 **/
public class Qiu12nLcof {
    public int solution(int n) {
        boolean flag = n > 0 && (n += solution(n - 1)) > 0;
        return n;
    }
}
