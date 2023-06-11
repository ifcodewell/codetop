package practice;

//        给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class ReverseKGroup {
    public static void main(String[] args) {

    }

////    官方题解
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode hair = new ListNode(0);
//        hair.next = head;
//        ListNode pre = hair;
//
//        while (head != null) {
//            ListNode tail = pre;
//            // 查看剩余部分长度是否大于等于 k
//            for (int i = 0; i < k; ++i) {
//                tail = tail.next;
//                if (tail == null) {
//                    return hair.next;
//                }
//            }
//            ListNode nex = tail.next;
//            ListNode[] reverse = myReverse(head, tail);
//            head = reverse[0];
//            tail = reverse[1];
//            // 把子链表重新接回原链表
//            pre.next = head;
//            tail.next = nex;
//            pre = tail;
//            head = tail.next;
//        }
//
//        return hair.next;
//    }
//    public ListNode[] myReverse(ListNode head, ListNode tail) {
//        ListNode prev = tail.next;
//        ListNode p = head;
//        while (prev != tail) {
//            ListNode nex = p.next;
//            p.next = prev;
//            prev = p;
//            p = nex;
//        }
//        return new ListNode[]{tail, head};
//    }

//   递归题解
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /*
    左闭又开区间
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }
}
