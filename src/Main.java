import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String[] ss = input.split(",");

        String s = ss[0];
        int rows = Integer.valueOf(ss[1]);

        if(s.length()<=rows || rows == 1){
            System.out.println(s);
        }

        char[] c = s.toCharArray();

        int step = 2*rows - 2;
        int row = 0;
        int current = 0;
        int currentNeibor = 0;

        StringBuffer sb = new StringBuffer(c.length);

        for(int i = 0; i<s.length(); i+=step){
            sb.append(c[i]);
        }

        row++;

        for(;row<rows-1; row++){
            current = row;
            while(current<s.length()){
                sb.append(c[current]);
                currentNeibor = current + step -2 *row;
                if(currentNeibor<s.length()){
                    sb.append(c[currentNeibor]);
                }
                current = current + step;
            }
        }

        for(; row<s.length(); row+=step){
            sb.append(c[row]);
        }

        System.out.println(sb.toString());
    }
}
