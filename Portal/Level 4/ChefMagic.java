import java.util.*;

public class ChefMagic {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int n = s.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextLong();

            int magic = 0;

            for (int i = 0; i < n; i++) {
                int cur = i;
                HashSet<Integer> path = new HashSet<>();
                path.add(i);

                for (int j = 0; j < n; j++) {             
                    long step = (arr[cur] % n) + 1;        // eat + skip A[cur]
                    int next = (int)((cur + step) % n);    // wrap on circle
                    if (next == i) {                       // returned to start
                        magic++;
                        break;
                    }
                    if (path.contains(next)) {             // loop elsewhere
                        break;
                    }
                    path.add(next);
                    cur = next;
                }
            }
            System.out.println(magic);
        }
    }
}
