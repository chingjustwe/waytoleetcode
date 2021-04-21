package cn.com.nightfield.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 **/
public class RestoreIpAddresses {
    public List<String> solution(String s) {
        LinkedList<String> tmp = new LinkedList<>();
        List<String> result = new LinkedList<>();
        backtrace(s, 0, tmp, result);
        return result;
    }

    private void backtrace(String s, int startIndex, LinkedList<String> tmp, List<String> result) {
        if (tmp.size() == 4) {
            if (startIndex >= s.length()) {
                StringBuilder oneResult = new StringBuilder(tmp.get(0));
                for (int i = 1; i < tmp.size(); i++) {
                    oneResult.append("." + tmp.get(i));
                }
                result.add(oneResult.toString());
            }
            return;
        }
        int totalLength = s.length();

        for (int i = 1; i <= 3; i++) {
            if (startIndex + i > totalLength) {
                return;
            }

            String sub = s.substring(startIndex, startIndex + i);
            if (!isValid(sub)) {
                continue;
            }

            tmp.add(sub);
            backtrace(s, startIndex + i, tmp, result);
            tmp.removeLast();
        }
    }

    private boolean isValid(String sub) {
        if (sub.charAt(0) == '0' && sub.length() > 1) {
            return false;
        }
        int intValue = Integer.parseInt(sub);
        if (intValue < 0 || intValue > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> result = restoreIpAddresses.solution("19216811");
        System.out.println(result);
    }
}
