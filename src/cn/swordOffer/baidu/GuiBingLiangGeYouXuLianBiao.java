package cn.swordOffer.baidu;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 21:07
 */
public class GuiBingLiangGeYouXuLianBiao {
    public static void main(String[] args) {
        LNode n11 = new LNode(1);
        LNode n13 = new LNode(3);
        LNode n15 = new LNode(5);
        n11.next = n13;
        n13.next = n15;

        LNode n22 = new LNode(2);
        LNode n24 = new LNode(4);
        LNode n26 = new LNode(6);
        n22.next = n24;
        n24.next = n26;

        LNode final_node = mergeTwoListsByDiGui(n11, n22);
        while (final_node != null) {
            System.out.print(final_node.val + "  ");
            final_node = final_node.next;
        }


    }

    public static LNode mergeTwoListsByDiGui(LNode l1, LNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        else {
            if (l1.val <= l2.val) {
                l1.next = mergeTwoListsByDiGui(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoListsByDiGui(l1, l2.next);
                return l2;
            }
        }
    }

    public static LNode mergeTwoListsByDieDai(LNode l1, LNode l2) {
        LNode preNode = new LNode(-1);
        LNode pre = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preNode.next;
    }
}

class LNode {
    public int val;
    public LNode next;

    public LNode() {
    }

    public LNode(int val) {
        this.val = val;
    }

    public LNode(int val, LNode next) {
        this.val = val;
        this.next = next;
    }
}