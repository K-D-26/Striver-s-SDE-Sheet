// Method 1:

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        
        for (int i = s, j = mid+1; i <= mid; i++) {
            while (j <= e && nums[i]/2.0 > nums[j]) {
                j++; 
            }
            cnt += j - (mid + 1); 
        }
        
        Arrays.sort(nums, s, e+1); 
        return cnt;
    }
}


// Method 2:

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }
        
        return cnt;
    }
    
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        
        if(low == high) return cnt;

        int mid = (high - low) / 2 + low;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        
        return cnt;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            }
            else {
                temp.add(arr[right++]);
            }
        }

        while(left <= mid) {
            temp.add(arr[left++]);
        }

        while(right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}