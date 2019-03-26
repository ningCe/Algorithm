public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null)
            return null;

        ListNode preNode = new ListNode(Integer.MIN_VALUE);
        ListNode result = preNode;
        preNode.next = pHead;
        ListNode p = pHead;
        while ((p != null) && (p.next != null)) {
            if (p.val == p.next.val) {
                ListNode temp = p.next;
                while ((temp != null) && (temp.next != null) && (temp.next.val == p.val))
                    temp = temp.next;

                if (temp.next == null) {
                    preNode.next = null;
                    return result.next;
                } else {
                    preNode.next = temp.next;
                    p = temp.next;
                }
            } else {
                preNode = p;
                p = p.next;
            }
        }
        return result.next;

    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(3);
        ListNode p6 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        ListNode p = p1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        DeleteDuplication test = new DeleteDuplication();
        test.deleteDuplication(p1);
        ListNode q = p1;
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }

    }
}