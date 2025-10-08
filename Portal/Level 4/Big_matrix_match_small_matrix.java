public class Big_matrix_match_small_matrix {
    public static void main(String[] args) {
        
        int[][] big = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 1, 2, 3},
            {4, 5, 6, 7}
        };
        int N = big.length;

        int[][] small1 = {
            {1, 2},
            {5, 6}
        };

        int[][] small2 = {
            {2, 3},
            {6, 7}
        };

        int[][] small3 = {
            {3, 4},
            {7, 9}
        };

        System.out.println("Example 1 → " + check(big, small1)); // True
        System.out.println("Example 2 → " + check(big, small2)); // True
        System.out.println("Example 3 → " + check(big, small3)); // False
    }

    static String check(int[][] big, int[][] small) {
        int N = big.length;
        int M = small.length;
        boolean found = false;

        for (int i = 0; i <= N - M && !found; i++) {
            for (int j = 0; j <= N - M && !found; j++) {
                if (isSubMatrix(big, small, i, j, M)) {
                    found = true;
                }
            }
        }

        return found ? "True" : "False";
    }
    static boolean isSubMatrix(int[][] big, int[][] small, int row, int col, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (big[row + i][col + j] != small[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
