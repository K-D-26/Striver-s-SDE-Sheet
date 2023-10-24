import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraysWithSumK(int []a, int k) {
        int xr = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

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