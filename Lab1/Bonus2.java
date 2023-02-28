import java.util.*;
public class Bonus2 {
    static int degree(int[][] matrix, int x) {
        int count = 0;
        for (int[] ints : matrix) if (ints[x] == 1) count++;
        return count;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int grad = Integer.parseInt(args[1]);

        if (n >= grad + 1 && (n * grad) % 2 == 0) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
                if (i == 0) {
                    for (int j = 1; j <= grad; j++) {
                        matrix[i][j] = 1;
                        matrix[j][i] = 1;
                    }
                } else {
                    for (int j = n - 1; j > i && degree(matrix, i) < grad; j--)
                        if (degree(matrix, j) == 0) {
                            matrix[i][j] = 1;
                            matrix[j][i] = 1;
                        }
                    for (int j = n - 1; j > i && degree(matrix, i) < grad; j--)
                        if (degree(matrix, j) < grad){
                            matrix[i][j] = 1;
                            matrix[j][i] = 1;
                        }
                }
            for (int[] row : matrix)
                System.out.println(Arrays.toString(row));

        } else{
            System.out.println("Graful nu este regulat");
        }
    }
}
