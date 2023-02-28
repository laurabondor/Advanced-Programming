import java.util.*;
public class Bonus1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == i + 1 || j == n - 1) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
                else if(i == n - 1) {
                    if(j == 0 || j == i - 1){
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
                else if(j == i + 1 || j == i - 1) {
                    matrix[i][j] = 1;
                }
                else matrix[i][j] = 0;
            }
        }
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        int[][] result;
        //System.arraycopy(matrix, 0, result, 0, n); sau
        result = matrix.clone();
        for(int count=2; count <= n; count++) {
            result = multiply(result, matrix);
        }
        System.out.println("Matrix result");
        for (int[] row : result)
            System.out.println(Arrays.toString(row));
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
