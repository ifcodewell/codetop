package sort;

//二分查找，前提是数组有序
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,8,9,10};
        int index = binarySearch(array, 3);
        System.out.println(array[index]);
    }

    public static int binarySearch(int[] a, int num){
        int left = 0;
        int right = a.length-1;
        int middle = (left+right)/2;
        while(left<=right){
            if(a[middle]==num){
                return middle;
            }
            if(num>a[middle]){
                left = middle+1;
            }
            if(num<a[middle]){
                right = middle-1;
            }
            middle = (left+right)/2;
        }
        return -1;
    }
}
