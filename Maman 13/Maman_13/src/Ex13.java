/**
 * This class define 4 functions:
 *  - 'maxMult3' function that finds the maximum multiplation of three cells in a sorted input array
 *  - 'findMedian' function that calculates the median of two sorted arrays by finding the medians of each array separately and then averaging them to calculate the overall median
 *  - 'maxSnake' function that calculates the maximum snake value in a given mat
 *  - 'minimalSt' function that finds the minimal string combination of two strings
 * @author Or Herzog
 * @version 5/2/2024
 */

import java.util.Arrays; // imported just for the sorting - in the test I will use the quickSort that specified on the book

public class Ex13 {


    /**
     * Finds the maximum multiplation of three cells in array
     * Time Complexity: O(O^2) because he nested loops used to find the maximum result of three cells in the sorted array
     * Space Complexity: O(1) because it doesn't use any additional space that scales with input size
     * Returns Integer.MIN_VALUE if the input array has fewer than three cells
     * @param arr The input array
     * @return The maximum result of multiplation on three cells from the input array
     */
    public static int maxMult3(int[] arr) {
        // returns Integer.MIN_VALUE if the input array has fewer than three cells
        if (arr.length < 3) {
            return Integer.MIN_VALUE;
        }

        // sort the input array - I will use the quickSort that specified on the book
        Arrays.sort(arr);
        // initialize the maximum result to a minimum value
        int max = Integer.MIN_VALUE;
    
        // go over the sorted array to find the maximum multiplication of three cells
        for (int mid = 0; mid < arr.length - 2; mid++) {
            int left = mid + 1;
            int right = arr.length - 1;
    
            while (left < right) {
                // calculate the multiplication of three cells
                int temp = arr[mid] * arr[left] * arr[right];
                // update the maximum result
                max = Math.max(max, temp);
    
                // adjust the left and right based on the comparison with the middle cell
                if (arr[left] * arr[right] < arr[mid]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    
        return max;
    }


    /**
     *  Calculates the median of two sorted arrays, by calling 'findMiddleIndexValue' private function on each array and then averaging the results
     *  Time complexity: O(log n) because the function uses a binary search method to find the medians of both arrays
     *  Space complexity: O(1) because it doesn't use any additional space that scales with input size
     * @param arr1 The first array
     * @param arr2 The second array
     * @return Overall median of the combined arrays
     */
    public static int findMedian(int[] arr1, int[] arr2){
        // find the median of the first sorted array
        int middleArr1 = findMiddleIndexValue(arr1);
        // find the median of the second sorted array
        int middleArr2 = findMiddleIndexValue(arr2);

        // average the medians to calculate the overall median
        return (middleArr1 + middleArr2) /2;
    }   

    // function that find the median of sorted array
    private static int findMiddleIndexValue(int[] arr){

        if(arr.length % 2 == 0){
            // if the array has an even length, calculate the median by the average of the two middle cells
            int middleIndex1 = arr.length/2 - 1;
            int middleIndex2 = arr.length/2;

            return (arr[middleIndex1] + arr[middleIndex2]) / 2;

        } else {
            // if the array has an odd length, return the middle cell as the median
            int middleIndex = arr.length/2;

            return arr[middleIndex];
        }

    }


    /**
     * Finds the minimal string combination of two strings
     * The minimal string should have characters from both input strings but with the least number of duplicates
     * @param st1 The first string
     * @param st2 The second string
     * @return The minimal string combination of the two strings
     */
    public static String minimalSt(String st1, String st2) {
        // call a private method to find the minimal string using indexes
        return minimalSt(st1, st2, 0, 0);
    }

    private static String minimalSt(String st1, String st2, int x, int y) {
        // if reached to the end of the st1, return the remaining characters from st2
        if (x >= st1.length()) {
            return st2.substring(y);
        }
        // if reached to the end of the st2, return the remaining characters from st1
        if (y >= st2.length()) {
            return st1.substring(x);
        }
        // if the characters at the same positions in both strings are the same, add the character to the combined string and call minimalSt for the next positions
        if (st1.charAt(x) == st2.charAt(y)) {
            return st1.charAt(x) + minimalSt(st1, st2, x + 1, y + 1);
        } else {
            // if the characters are different, there are two possibilities - with the character from the st1 string or with the character from the st2

            // add the character from st1 to the string result and continue with the next position in st1
            String withX = st1.charAt(x) + minimalSt(st1, st2, x + 1, y);

            // add the character from st2 to the string result and continue with the next position in st2
            String withY = st2.charAt(y) + minimalSt(st1, st2, x, y + 1);

            // return the shorter of the two possibilities
            if (withX.length() < withY.length()) {
                return withX;
            } else {
                return withY;
            }
        }
    }


    /**
     * Calculates the maximum snake value for the given matrix
     * The difference between two cells that the snake is visting should be acual to 1
     * The snake cannot visit the same cell twice
     * @param mat The input mat for the snake
     * @return The maximum snake value
     */
    public static int maxSnake(int[][] mat) {
        // starting to check from the top-left corner (0, 0) with an initial prevValue of Integer.MIN_VALUE
        return maxSnake(mat, 0, 0, mat[0][0]);
    }
    
    private static int maxSnake(int[][] mat, int x, int y, int prevValue) {
        // check if the current cell is out of bounds, marked as 0, or the difference between the currenet cell and the previous is not equal to 1
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 0 || Math.abs(mat[x][y] - prevValue) > 1) {
            return 0;
        }

        // store the original value of the current cell and mark it as 0 to prevent revisiting it
        int originalValue = mat[x][y];
        mat[x][y] = 0;
    
        // calculate the maximum snake value by checking the all four possible paths
        int up = 1 + maxSnake(mat, x - 1, y, originalValue);
        int down = 1 + maxSnake(mat, x + 1, y, originalValue);
        int left = 1 + maxSnake(mat, x, y - 1, originalValue);
        int right = 1 + maxSnake(mat, x, y + 1, originalValue);
    
        // restore the original value of the cell
        mat[x][y] = originalValue;

        // return the maximum of the four possible paths
        return Math.max(Math.max(Math.max(up, down), left), right);
    }

}


