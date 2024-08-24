package sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    public static void shellSort(int[] arr){
        int len = arr.length;
        /*初始化划分增量*/
        int increment = len;
        int temp;
        /*每次减小增量，直到increment = 1*/
        while (increment > 1){
            /*增量的取法之一：除三向下取整+1*/
            increment = increment/3 + 1;
            /*对每个按增量划分后的逻辑分组，进行直接插入排序*/
            for (int i = increment; i < len; ++i) {
                if (arr[i-increment] > arr[i]) {
                    temp = arr[i];
                    int j = i-increment;
                    /*移动元素并寻找位置*/
                    while (j >= 0 && arr[j] > temp) {
                        arr[j+increment] = arr[j];
                        j -= increment;
                    }
                    /*插入元素*/
                    arr[j+increment] = temp;
                }
            }
        }

    }

    public static void shellSort1(int[] arr){
        for(int gap = arr.length/2; gap>0; gap = gap/2){
            for(int i = gap; i<arr.length; i++){
                for(int j = i-gap; j>=0; j=j-gap){
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //打印每次排序后的结果
            System.out.println(Arrays.toString(arr));
        }
    }
}
