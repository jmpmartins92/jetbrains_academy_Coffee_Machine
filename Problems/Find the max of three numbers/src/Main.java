import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] parameters = {a, b, c};
        int max = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int parametersIndex = 0; parametersIndex < parameters.length; parametersIndex++) {
            if (parameters[parametersIndex] > max) {
                max = parameters[parametersIndex];
                indexMax = parametersIndex + 1;
            }
        }
        return indexMax;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}