class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}

class Solution {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());
        int currWeight = 0;
        double maxValue = 0.0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i].weight + currWeight < W) {
                currWeight += arr[i].weight;
                maxValue += arr[i].value;
            }
            else {
                int remain = W - currWeight;
                maxValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
        
        return maxValue;
    }
}