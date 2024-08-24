import java.util.Scanner;

public class BinaryAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        Integer i1 = Integer.parseInt(String.valueOf(a), 2);
        Integer i2 = Integer.parseInt(String.valueOf(b), 2);

        Integer output = i1 + i2;
        System.out.println(Integer.toBinaryString(output));
    }
}
