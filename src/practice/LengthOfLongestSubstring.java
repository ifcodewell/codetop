package practice;

import java.util.*;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s =  "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

//第一次写的算法可以正确求解。但超出了时间限制
//    public static int lengthOfLongestSubstring(String s) {
//        int length = 0;
//        String ss ;
//        ArrayList<String> subs = new ArrayList<>();
//        for(int i=0; i < s.length(); i++) {
//            for (int j=i+1; j<s.length()+1; j++){
//                ss = s.substring(i, j);
//                if(checkDifferent(ss)){
//                    subs.add(ss);
//                }
//            }
//        }
//        for (String sub : subs) {
//            if (sub.length() > length) {
//                length = sub.length();
//            }
//        }
//        return length;
//    }

//    //判断字符串中是否有重复字符
//    private static boolean checkDifferent(String str) {
//        for(int i=0; i<str.length(); i++){
//            for(int j=i+1; j<str.length(); j++){
//                if(str.charAt(i)==str.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    官方题解
    public static int lengthOfLongestSubstring(String s) {
        int m = s.length();
        if(m==0) {
            return 0;
        }
        int num =1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max =1;
        for(int i=1;i<m;i++){
            int index = s.indexOf(s.charAt(i),i-num);
            if(index<i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i-index;
            } else {
                num = num+1;
            }
            max = Math.max(max,num);
        }
        return max;
    }

//    精选题解(时空效率不如官方题解)
//public static int lengthOfLongestSubstring(String s) {
//    if (s.length()==0) {
//        return 0;
//    }
//    HashMap<Character, Integer> map = new HashMap<>();
//    int maxLen = 0;//用于记录最大不重复子串的长度
//    int left = 0;//滑动窗口左指针
//    for (int i = 0; i < s.length() ; i++)
//    {
//        /*
//         1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
//         此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
//
//         2、如果当前字符 ch 包含在 map中，此时有2类情况：
//         1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
//         那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
//         2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
//         而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
//         随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
//         应该不变，left始终为2，子段变成 ba才对。
//
//         为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
//         另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
//         因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
//         */
//        if(map.containsKey(s.charAt(i)))
//        {
//            left = Math.max(left , map.get(s.charAt(i))+1);
//        }
//        //不管是否更新left，都要更新 s.charAt(i) 的位置！
//        map.put(s.charAt(i) , i);
//        maxLen = Math.max(maxLen , i-left+1);
//    }
//    return maxLen;
//}
}


