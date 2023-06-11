package practice;

import java.util.ArrayList;

public class ReverseList {
    public static void main(String[] args) {

    }

//    我的解法：
//    执行用时：
//            1 ms
//, 在所有 Java 提交中击败了
//4.85%
//    的用户
//    内存消耗：
//            40.2 MB
//, 在所有 Java 提交中击败了
//95.40%
//    的用户
//    public static ListNode reverseList(ListNode head) {
//        if(head == null || head.next==null){
//            return head;
//        }
//        ArrayList<ListNode> al = new ArrayList<>();
//        while(true){
//            al.add(head);
//            head = head.next;
//            if(head.next==null){
//                al.add(head);
//                break;
//            }
//        }
//        for(ListNode listnode : al){
//            listnode.next = null;
//        }
//        for(int i = al.size()-1; i>0; i--){
//            al.get(i).next = al.get(i-1);
//        }
//        return al.get(al.size()-1);
//    }

//    官方题解
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

////    递归题解
//public ListNode reverseList(ListNode head) {
//    if (head == null || head.next == null) {
//        return head;
//    }
//    ListNode newHead = reverseList(head.next);
//    head.next.next = head;
//    head.next = null;
//    return newHead;
//}
}

