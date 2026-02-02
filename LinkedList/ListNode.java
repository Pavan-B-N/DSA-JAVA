package LinkedList;
public class ListNode {
    public int data;
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode random;
    public ListNode child;

    public ListNode(){
        this.data = 0;
        this.val = 0;
        this.next = null;
    }

    public ListNode(int data){
        this.data = data;
        this.val = data;
        this.next = null;
    }

    public ListNode(int data,ListNode next){
        this.data = data;
        this.val = data;
        this.next = next;
    }
}
