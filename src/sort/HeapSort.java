package sort;


import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4,6,1,2,9,8,3,5};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length/2-1; i>=0; i--){
            heapAdjust(arr, i, arr.length);
        }

        for(int j = arr.length-1; j>=0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
             /*为什么从0开始？
                因为在第一次构建大顶堆后让堆顶元素和末尾元素进行交换
                而对于其他的非叶子结点所对应的子树都是大顶堆就无需调整，
                只需要堆顶元素(下标为0的非叶子结点)的子树调整成大顶堆
            */
            heapAdjust(arr, 0, j);
        }
    }

    public static void heapAdjust(int[] arr, int i, int len){
        int temp = arr[i];
        /*j=i*2+1表示的是i结点的左子结点*/
        for(int j = 2*i+1; j<len; j = j*2 +1){
            if(j+1<len && arr[j]<arr[j+1]){//左子结点小于右子结点
                j++;//j指向右子结点
            }
            if(arr[j]>temp){ //子节点大于父节点
                arr[i] = arr[j];//把较大的值赋值给父节点
//                arr[j] = temp;
                i = j;//让i指向与其换位的子结点
            }else{
                /*子树已经是大顶堆了*/
                break;
            }
        }
        arr[i] = temp;
    }
}
