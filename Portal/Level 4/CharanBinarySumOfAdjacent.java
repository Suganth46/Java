import java.util.*;

public class CharanBinarySumOfAdjacent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] B = new int[N];
            for (int i = 0; i < N; i++) B[i] = sc.nextInt();
            System.out.println(isPossible(B, N) ? "YES" : "NO");
        }
        sc.close();
    }

    static boolean isPossible(int[] B, int N) {
        // Try starting A1 = 0 and A1 = 1
        for (int start = 0; start <= 1; start++) {
            int[] A = new int[N];
            A[0] = start;
            for (int i = 1; i < N; i++) {
                A[i] = A[i - 1] ^ B[i - 1]; // XOR relation
            }
            // check circular condition (A[N-1] + A[0]) % 2 == B[N-1]
            if (((A[N - 1] ^ A[0]) == B[N - 1])) {
                return true; // valid sequence found
            }
        }
        return false; // both failed
    }
}
