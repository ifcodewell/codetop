package sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] array = {9,4,11,7,3,8,5};
//        int[] array = {9};
        quick(array, 0, array.length-1);
//        System.out.println(Arrays.toString(quick(array, 0, array.length-1)));
        System.out.println(Arrays.toString(array));
    }

    public static void quick(int[] a, int l, int r){
        //    递归的退出条件
        if(l >= r){
            return ;
        }
        int i = partition(a, l, r);
        quick(a, l, i-1);
        quick(a, i+1, r);
    }

////    单边循环快排
//    public static int partition(int[] a, int l, int r){
//        int basic = a[r];
//        int i = l;
//        for(int j = l; j < r; j++){
//            if(a[j] < basic){
//                swap(a, i, j);
//                i++;
//            }
//        }
//        if(r!=i){
//            swap(a,r,i);
//        }
//        System.out.println(Arrays.toString(a));
//        return i;
//    }


//    双边循环快排
    public static int partition(int[] a, int l, int r){
        int basic = a[l];
        int i = l; //从前往后找大的
        int j = r; //从后往前找小的
        while(i < j){
//            必须先j后i
            while(i < j && a[j] > basic){
                j--;
            }
            while(i < j && a[i] <= basic){
                i++;
            }
            swap(a, i, j);
        }
        swap(a, l, i);
        return i;
    }

    public static void swap(int[] a, int i, int j){
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
