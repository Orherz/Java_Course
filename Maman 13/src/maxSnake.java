/**
 * This class define 'maxSnake' function that calculates the maximum snake value in a given mat
 * @author Or Herzog
 * @version 5/2/2024
 */
public class maxSnake {
    /**
     * Calculates the maximum snake value for the given matrix
     * The difference between two cells that the snake is visting should be acual to 1
     * The snake cannot visit the same cell twice
     * @param mat The input mat for the snake
     * @return The maximum snake value
     */
    public static int maxSnake(int[][] mat) {
        // starting to check from the top-left corner (0, 0) with an initial prevValue of Integer.MIN_VALUE
        return maxSnake(mat, 0, 0, Integer.MIN_VALUE);
    }

    private static int maxSnake(int[][] mat, int x, int y, int prevValue) {
        // check if the current cell is out of bounds, marked as 0, or the difference between the currenet cell and the previous is not equal to 1
        if (x < 0 || x >= mat[0].length || y < 0 || y >= mat.length || mat[y][x] == 0 || Math.abs(mat[y][x] - prevValue) != 1) {
            return 0;
        }

        // store the original value of the current cell and mark it as 0 to prevent revisiting it
        int originalValue = mat[y][x];
        mat[y][x] = 0;

        // calculate the maximum snake value by checking the all four possible paths
        int up = 1 + maxSnake(mat, x, y - 1, originalValue);
        int down = 1 + maxSnake(mat, x, y + 1, originalValue);
        int left = 1 + maxSnake(mat, x - 1, y, originalValue);
        int right = 1 + maxSnake(mat, x + 1, y, originalValue);

        // restore the original value of the cell
        mat[y][x] = originalValue;

        // return the maximum of the four possible paths
        return Math.max(Math.max(up, down), Math.max(left, right));
    }
}
