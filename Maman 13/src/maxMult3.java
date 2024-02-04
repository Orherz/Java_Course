import java.util.Arrays;

public class maxMult3 {
    public static int maxMult3(int[] arr) {
        if (arr.length < 3) {
            return Integer.MIN_VALUE;
        }
    
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
    
        for (int mid = 0; mid < arr.length - 2; mid++) {
            int left = mid + 1;
            int right = arr.length - 1;
    
            while (left < right) {
                int temp = arr[mid] * arr[left] * arr[right];
                max = Math.max(max, temp);
    
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

