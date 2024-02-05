/**
 * This class define maxMult3 function that finds the maximum multiplation of three elements in a sorted input array
 * @author Or Herzog
 * @version 5/2/2024
 */

import java.util.Arrays;

public class maxMult3 {
    /**
     * Finds the maximum multiplation of three elements in array.
     * Time Complexity: O(O^2) - The nested loops used to find the maximum product of three elements in the sorted array.
     * Space Complexity: O(1) - No additional data structures depend on the input size.
     * @param arr The input array.
     * @return The maximum multiplation of three elements from the input array. Returns Integer.MIN_VALUE if the input array has fewer than three elements.
     */
    public static int maxMult3(int[] arr) {
        if (arr.length < 3) {
            return Integer.MIN_VALUE;
        }

        // Sort the input array
        Arrays.sort(arr);
        // Initialize the maximum result to a minimum value
        int max = Integer.MIN_VALUE;
    
        // Iterate through the sorted array to find the maximum multiplication of three elements
        for (int mid = 0; mid < arr.length - 2; mid++) {
            int left = mid + 1;
            int right = arr.length - 1;
    
            while (left < right) {
                // Calculate the multiplication of three elements
                int temp = arr[mid] * arr[left] * arr[right];
                // Update the maximum result if necessary
                max = Math.max(max, temp);
    
                // Adjust the left and right pointers based on the comparison with the middle element
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

