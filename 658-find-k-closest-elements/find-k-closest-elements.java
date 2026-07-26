import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>();

        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        if (k == arr.length) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x)
                high = mid;
            else
                low = mid + 1;
        }

        int l = low - 1;
        int r = low;

        while (res.size() < k) {
            if (l == -1) {
                res.add(arr[r++]);
            } else if (r == arr.length) {
                res.add(arr[l--]);
            } else if (x - arr[l] <= arr[r] - x) {
                res.add(arr[l--]);
            } else {
                res.add(arr[r++]);
            }
        }

        Collections.sort(res);
        return res;
    }
}