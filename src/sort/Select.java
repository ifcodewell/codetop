package sort;
import java.util.Arrays;

//选择排序：每次选择最小的元素与数组开始元素交换，并不断缩减排序区间
public class Select {
    public static void main(String[] args) {
        int[] array = {9,4,11,7,3,8,5};
        select(array);
    }

    public static void select(int[] a){
        for(int j = 0; j < a.length-1; j++){
            int min = j;
            for(int i = j+1; i < a.length; i++){
                if(a[i] < a[min]){
                    min = i;
                }
            }
            if(min!=j){
                swap(a, min, j);
            }
            System.out.println(Arrays.toString(a));
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
