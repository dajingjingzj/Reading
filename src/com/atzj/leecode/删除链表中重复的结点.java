package com.atzj.leecode;

/**
 * 类描述：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author zhoujing129
 */
public class 删除链表中重复的结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 非递归的代码：
     *
     * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode Head = new ListNode(0);
        Head.next = pHead;//设置头节点
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
}
