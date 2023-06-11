package sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] array = {9,4,11,7,3,8,5};
        insert(array);
    }

    public static void insert(int[] a){
        //            i表示待插入元素的索引
        for (int i =1; i<a.length; i++){
            //临时变量存储待插入的值
            int t = a[i];
            //已排序区边界
            int j = i-1;
            while(j >= 0){
                if(a[j] > t){
                    a[j+1] = a[j];
                }
                else{
                    break;
                }
                j--;
            }
            a[j+1] = t;
            System.out.println(Arrays.toString(a));
        }
    }
}
