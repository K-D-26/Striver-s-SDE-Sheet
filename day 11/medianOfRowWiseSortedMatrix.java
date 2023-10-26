public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        int low = 1, high = 1000000000;
        int rows = m, cols = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < rows; i++) {
                cnt += countElementsSmallerThanMid(matrix[i], cols, mid);
            }
            if (cnt <= (rows * cols) / 2) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int countElementsSmallerThanMid(int[] a, int cols, int mid) {
        int l = 0, h = cols - 1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (a[m] <= mid) {
                l = m + 1;
            }
            else {
                h = m - 1;
            }
        }

        return l;
    }
}