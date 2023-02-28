public class Homework {
    public static void main(String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
            System.out.println(n);
        } catch(Exception e){
            System.out.println("Error");
        }
        int[][] LatinSquare = new int[n][n];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int number = i + 1;
            for (int j = 0; j < n; j++) {
                if (number == n + 1) {
                    number = 1;
                }
                LatinSquare[i][j] = number;
                number++;
            }
        }
        long t2 = System.currentTimeMillis();

        if (n > 30_000) {
            System.out.println(t2 - t1);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("(" + i + "," + j + "," + LatinSquare[i][j] + ")");
                }
            }
        }
    }
}
