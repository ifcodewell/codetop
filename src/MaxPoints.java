import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String[] ss = s.split(" ");

        ArrayList<Integer> arrayX = new ArrayList<>();
        ArrayList<Integer> arrayY = new ArrayList<>();

        for (String item : ss) {
            String[] sss =  item.split(",");
            arrayX.add(Integer.valueOf(sss[0]));
            arrayY.add(Integer.valueOf(sss[1]));
        }

        if (arrayX.size() < 2) {
            System.out.println(arrayX.size());
        }

        int maxpoints = 1;

        for (int i = 0; i < arrayX.size(); i++) {
            int duplicate = 0;
            int localMax = 1;
            Map<Double, Integer> slopeCount = new HashMap<>();

            for (int j = i+1; j < arrayX.size(); j++) {
                int dx = arrayX.get(j) - arrayX.get(i);
                int dy = arrayY.get(j) - arrayY.get(i);
                if (dx == 0 && dy == 0) {
                    duplicate += 1;
                } else if (dx == 0) {
                    slopeCount.put(Double.MAX_VALUE, slopeCount.getOrDefault(Double.MAX_VALUE,
                            0) + 1);
                    localMax = Math.max(localMax, slopeCount.get(Double.MAX_VALUE));
                } else {
                    double slope = (double) (dy / dx);
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                    localMax = Math.max(localMax, slopeCount.get(slope));
                }
            }
            maxpoints = Math.max(maxpoints, localMax + duplicate + 1);
        }
        System.out.println(maxpoints);
    }
}
