/**
 * This class define 'findMedian' function that calculates the median of two sorted arrays by finding the medians of each array separately and then averaging them to obtain the overall median.
 * @author Or Herzog
 * @version 5/2/2024
 */
public class findMedian {
    /**
     *  Calculates the median of two sorted arrays arr1 and arr2, by calling findMiddleIndexValue on each array and then averaging the results.
     *  Time complexity: O(log n) because the function uses a binary search approach to find the medians of both arrays.
     *  Space complexity: O(1) because it doesn't use any additional memory that scales with input size.
     * @param arr1 The first input array.
     * @param arr2 The second input array.
     * @return Overall median of the combined data from both arrays.
     */
    public static int findMedian(int[] arr1, int[] arr2){
        // Find the median of the first sorted array
        int middleArr1 = findMiddleIndexValue(arr1);
        // Find the median of the second sorted array 'arr2'
        int middleArr2 = findMiddleIndexValue(arr2);

        // Average the medians to obtain the overall median
        return (middleArr1 + middleArr2) /2;
    }   

    // Helper function to find the median of a sorted array
    private static int findMiddleIndexValue(int[] arr){

        if(arr.length % 2 == 0){
            // If the array has an even length, calculate the average of the two middle elements
            int middleIndex1 = arr.length/2 - 1;
            int middleIndex2 = arr.length/2;

            return (arr[middleIndex1] + arr[middleIndex2]) / 2;

        } else {
            // If the array has an odd length, return the middle element as the median
            int middleIndex = arr.length/2;

            return arr[middleIndex];
        }

    }
}
            