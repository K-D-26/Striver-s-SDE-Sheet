import java.util.*;
import java.io.*;

class mergeSort {
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low == high) return cnt;

        int mid = (high - low) / 2 + low;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int left = low;         // starting index of left half
        int right = mid+1;      // starting index of right half
        List<Integer> temp = new ArrayList<>();
        
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {       // left is smaller
                temp.add(arr[left]);
                left++;
            }
            else {                              // right is smaller
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }
}

public class Solution {
    public static long getInversions(int arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }
}