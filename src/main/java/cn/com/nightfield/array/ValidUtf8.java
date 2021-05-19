package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/22
 *
 * https://leetcode-cn.com/problems/utf-8-validation/
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 *     对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 *     对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 *
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意：
 * 输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 **/
public class ValidUtf8 {
    public boolean solution(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        int oneXor = 0b10000000, twoXor = 0b11000000, threeXor = 0b11100000, fourXor = 0b11110000;
        int zeroMask = 0b01111111, oneMask = 0b00111111, twoMask = 0b00011111, threeMask = 0b00001111, fourMask = 0b00000111;

        for (int i = 0; i < data.length;) {
            int element = data[i];
            if ((element ^ fourXor) == (element & fourMask)) {
                if (!isFourByte(data, i + 1, oneXor, oneMask)) {
                    return false;
                }
                i += 4;
            }
            else if ((element ^ threeXor) == (element & threeMask)) {
                if (!isThreeByte(data, i + 1, oneXor, oneMask)) {
                    return false;
                }
                i += 3;
            }
            else if ((element ^ twoXor) == (element & twoMask)) {
                if (!isTwoByte(data, i + 1, oneXor, oneMask)) {
                    return false;
                }
                i += 2;
            }
            else if (element == (element & zeroMask)) {
                i++;
            }
            else {
                return false;
            }
        }
        
        return true;
    }

    private boolean isFourByte(int[] data, int i, int oneXor, int oneMask) {
        if (i >= data.length - 2) {
            return false;
        }

        for (int j = 0; j <= 2; j++) {
            int element = data[i + j];
            if ((element ^ oneXor) != (element & oneMask)) {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeByte(int[] data, int i, int oneXor, int oneMask) {
        if (i >= data.length - 1) {
            return false;
        }

        for (int j = 0; j <= 1; j++) {
            int element = data[i + j];
            if ((element ^ oneXor) != (element & oneMask)) {
                return false;
            }
        }

        return true;
    }

    private boolean isTwoByte(int[] data, int i, int oneXor, int oneMask) {
        if (i >= data.length) {
            return false;
        }

        int element = data[i];
        if ((element ^ oneXor) != (element & oneMask)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidUtf8 validUtf8 = new ValidUtf8();
        validUtf8.solution(new int[]{235, 140, 4});
    }
}
