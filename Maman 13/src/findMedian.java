/**
 * This class define 'findMedian' function that calculates the median of two sorted arrays by finding the medians of each array separately and then averaging them to calculate the overall median
 * @author Or Herzog
 * @version 5/2/2024
 */
public class findMedian {
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
}
            