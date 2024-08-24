import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        long[] dp = new long[n+1];

        dp[s] = 1;

        for(int i = 1; i<=n; i++){
            if(i!=s){
                dp[i] = 0;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 1; j<=n; j++){
                if(j!=s){
                    dp[j] = 0;
                }
                for(int k:graph.get(j)){
                    dp[j]+=dp[k];
                }
            }
        }
        System.out.println(dp[t]);
    }
}
