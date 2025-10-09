import java.util.*;

public class trap_water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
            System.out.println(trapWater(arr, N));
        }
    }

    static int trapWater(int[] arr, int n) {
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    water += leftMax - arr[left];
                left++;
            } else {
                if (arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    water += rightMax - arr[right];
                right--;
            }
        }
        return water;
    }
}
