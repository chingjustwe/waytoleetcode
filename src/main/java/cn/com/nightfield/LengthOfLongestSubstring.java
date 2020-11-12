package cn.com.nightfield;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/6
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 思路：
 * 新建一个HashMap，存放字符串的字符和其下标，用来判断是否有重复字符。遍历字符串，直到发现有重复字符为止，记录下HashMap的长度。
 * 继续从重复字符的其实位置遍历字符串，直到结束，找到过程中HashMap的最大可能长度，即为结果。
 **/
public class LengthOfLongestSubstring {
    public int solution(String s) {
        int maxLength = 0;
        Map<Character, Integer> container = new HashMap<>();
        int start = 0;
        int[] duplicateArray;
        while ((duplicateArray = findDuplicate(s, start, container)) != null) {
            int duplicateIndex = duplicateArray[0];
            int substringLength = duplicateArray[1];
            if (substringLength > maxLength) {
                maxLength = substringLength;
            }

            // indicate it already reached to the end
            if (duplicateIndex == -1) {
                break;
            }

            start = duplicateIndex + 1;
            container.clear();
        }

        return maxLength;
    }

    int[] findDuplicate(String s, int start, Map<Character, Integer> container) {
        if (start >= s.length()) {
            return null;
        }
        for (int i = start; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer index = container.get(c);
            if (index != null) {
                // duplicate index + substring length
                return new int[]{index, container.size()};
            }
            container.put(c, i);
        }
        return new int[]{-1, container.size()};
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<16;i++){
            int number=random.nextInt(8) + 97;
            sb.append((char) number);
        }

        String s = sb.toString();
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring.solution(s));
    }
}
