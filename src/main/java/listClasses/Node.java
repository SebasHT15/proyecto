package listClasses;

public class Node {
    private Song data;
    private Node next;



    public Node(Song data) {
        this.next = null;
        this.data = data;
    }
    public Song getData() {
        return this.data;
    }
    public void setData(Song data) {
        this.data = data;
    }
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node node) {
        this.next = node;
    }
}