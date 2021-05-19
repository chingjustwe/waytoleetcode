package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/4/25
 *
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 **/
public class MaxAreaOfIsland {
    public int solution(int[][] grid) {
        // boundary check
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = mergeIsland(grid, i, j);
                    // record max value in each run
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    private int mergeIsland(int[][] grid, int i, int j) {
        // boundary check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // indicate visited
        grid[i][j] = 0;

        int result = 1;
        // search recursively for each connected element
        result += mergeIsland(grid, i - 1, j);
        result += mergeIsland(grid, i + 1, j);
        result += mergeIsland(grid, i, j - 1);
        result += mergeIsland(grid, i, j + 1);
        return result;
    }
}
