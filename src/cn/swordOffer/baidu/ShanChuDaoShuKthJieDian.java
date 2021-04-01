package cn.swordOffer.baidu;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/29 0:45
 */
public class ShanChuDaoShuKthJieDian {
    //使用双指针方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) return null;
        ListNode preNode = head;
        ListNode curNode = head;
        for (int i = 0; i < n; i++) {//让第一个指针往后走n步
            curNode = curNode.next;
        }
        if (curNode == null) {//如果第一个指针到了最后，说明要删除头结点
            return preNode.next;
        }
        while (curNode.next != null) {//如果后面还有节点，两个节点同步往后前进
            preNode = preNode.next;
            curNode = curNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }
}
