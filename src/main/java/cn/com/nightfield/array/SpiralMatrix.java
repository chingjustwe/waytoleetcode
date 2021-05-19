package cn.com.nightfield.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/5/8
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 **/
public class SpiralMatrix {
    public List<Integer> solution(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> result = new LinkedList<>();
        while (top <= bottom && left <= right) {
            // going right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            // going down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            // going left
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            // going up
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.solution(matrix);
        list.forEach(System.out::println);
    }
}
