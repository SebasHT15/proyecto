package listClasses;

public class NodeSongs {
    private Song data;
    private NodeSongs next;



    public NodeSongs(Song data) {
        this.next = null;
        this.data = data;
    }
    public Song getData() {
        return this.data;
    }
    public void setData(Song data) {
        this.data = data;
    }
    public NodeSongs getNext() {
        return this.next;
    }
    public void setNext(NodeSongs node) {
        this.next = node;
    }
}