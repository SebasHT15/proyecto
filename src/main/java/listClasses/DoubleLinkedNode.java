package listClasses;

public class DoubleLinkedNode {
    Song data;
    DoubleLinkedNode next;
    DoubleLinkedNode previous;
    /*public DoubleLinkedNode(int data){
        this.data=data;
        this.next=null;
        this.previous=null;
    }
    public DoubleLinkedNode(int data, DoubleLinkedNode next, DoubleLinkedNode previous){
        this.data=data;
        this.next=next;
        this.previous=previous;
    }*/
    public Song getData() {
        return data;
    }
}
