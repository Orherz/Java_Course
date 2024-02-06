/**
 * This class define 'maxMult3' function that finds the maximum multiplation of three cells in a sorted input array
 * @author Or Herzog
 * @version 5/2/2024
 */

import java.util.Arrays; // imported just for the sorting - in the test I will use the quickSort that specified on the book

public class maxMult3 {
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
}

