import java.util.*;

public class twoSumFindTwoDDistinctPosition {
    public static void main(String[] args) {
        // Assign input (you can later change to Scanner if needed)
        int n = 4;
        int x = 8;
        int[] arr = {2, 7, 5, 1};

        findTwoSum(arr, n, x);
    }

    static void findTwoSum(int[] arr, int n, int x) {
        // Map to store number -> its index (1-based)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int need = x - arr[i];

            // Check if the needed number is already seen
            if (map.containsKey(need)) {
                System.out.println((map.get(need)) + " " + (i + 1));
                return;
            }

            // Store current number and its position
            map.put(arr[i], i + 1);
        }

        System.out.println("IMPOSSIBLE");
    }
}
