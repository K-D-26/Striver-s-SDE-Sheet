// coding ninja

public class Solution {
    public static void immediateSmaller(int []a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i+1] < a[i]) {
                a[i] = a[i+1];
            }
            else {
                a[i] = -1;
            }
        }

        a[a.length-1] = -1;
    }
}