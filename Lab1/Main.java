package Lab1;

public class Main {
    private static final int FF = 0;

    public static void main(String args[]) {
        System.out.println("Hello world!");
        String languages[] = { "C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += 10101;
        n += FF;
        n *= 6;

        while (n > 9) {
            int sumaN = 0;
            while (n != 0) {
                sumaN += n % 10;
                n /= 10;
            }
            n = sumaN;
        }
        int result = n;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
