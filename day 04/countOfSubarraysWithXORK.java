import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraysWithSumK(int []a, int k) {
        int xr = 0;                       // xor of elements in the left uptill now
        int cnt = 0;                      // count of elements with particular xor
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);          // there will be one subarray with 0 elements that has xor 0.

        for (int i : a) {
            xr ^= i;
            int x = xr ^ k;
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }
}