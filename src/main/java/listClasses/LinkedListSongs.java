package listClasses;
public class LinkedListSongs {
    private NodeSongs head;
    private int size;

    //private Node current = this.head;
    public LinkedListSongs() {
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    public int size() {
        return this.size;
    }
    public void insertFirst(Song data) {
        NodeSongs newNodeSongs = new NodeSongs(data);
        newNodeSongs.setNext(this.head);
        this.head = newNodeSongs;
        this.size++;
    }
    public NodeSongs deleteFirst() {
        if (this.head != null) {
            NodeSongs temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    public void displayList() {
        NodeSongs current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    public NodeSongs getCurrent(){
        NodeSongs current = this.head;
        return current;
        //current = current.getNext()
    }

}