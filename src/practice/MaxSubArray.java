package practice;


public class MaxSubArray {
    public static void main(String[] args) {
        int[] arrs = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arrs));
    }

    //    使用动态规划解题
    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 0; i < nums.length - 1; i++){
            if(dp[i] > 0){
                dp[i+1] = dp[i]+nums[i+1];
            }
            else{
                dp[i+1] = nums[i+1];
            }
        }
        int max = dp[0] ;
        for(int j= 0; j<dp.length; j++){
            if(dp[j]>max){
                max = dp[j];
            }
        }
        return max;
    }

}
