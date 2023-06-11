package practice;
import java.util.Arrays;
import java.util.Random;

//        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class FindKthLargest {
    public static void main(String[] args) {
//        int[] array = {3,2,1,5,6,4};
        int[] array = {99,99};
        System.out.println(findKthLargest(array, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        Random random = new Random();
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
