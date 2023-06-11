package sort;
import java.util.Arrays;

//冒泡排序
public class Bubble {
    public static void main(String[] args) {
        int[] array = {9,4,5,7,3,8,11};
        bubble(array);
    }

    public static void bubble(int[] a){
        for(int i = 0; i< a.length; i++){
            boolean flag = false;
            for(int j = 0; j < a.length-1-i; j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                    flag = true;
                }
            }
            if(!flag){
                break;
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
