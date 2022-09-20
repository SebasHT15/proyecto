//https://www.youtube.com/watch?v=gTOJPSVLuEk Este es funcional
package listClasses;


public class CircularDoubleLinkedList {
    private DoubleLinkedNode first;
    private DoubleLinkedNode last;
    public CircularDoubleLinkedList(){
        first =null;
        last=null;
    }
    public void insert(Song data){
        DoubleLinkedNode newdoubleLinkedNode = new DoubleLinkedNode();
        newdoubleLinkedNode.data=data;
        if (first ==null){
            first =newdoubleLinkedNode;
            last=newdoubleLinkedNode;
            first.next= first;
            last.previous=last;
        }else {
            last.next=newdoubleLinkedNode;
            newdoubleLinkedNode.next= first;
            newdoubleLinkedNode.previous=last;
            last=newdoubleLinkedNode;
            first.previous=last;
        }
    }
    public void delete(Song x) {
        DoubleLinkedNode current = new DoubleLinkedNode();
        DoubleLinkedNode previous_temp = new DoubleLinkedNode();
        current = first;
        previous_temp = last;
        do {
            if (current.data == x) {
                if (current == first){
                    first = first.next;
                    last.next = first;
                    first.previous = last;
                } else if (current == last) {
                    last = previous_temp;
                    first.previous = last;
                    last.next = first;
                }
                else {
                    previous_temp.next = current.next;
                    current.next.previous = previous_temp;
                }
            }
            previous_temp = current;
            current = current.next;
        }while (current != first);
    }
    public void search(Song x){
        DoubleLinkedNode current = new DoubleLinkedNode();
        current = last;
        Boolean found = false;
        do {
            if (current.data == x){
                found = true;
            }
            current=current.previous;
        }while (current != last && found != true);
        if (found == true){
            System.out.println("encontrado");
        }else {
            System.out.println("no encontrado");
        }
    }
    public void displayList(){
        DoubleLinkedNode current = new DoubleLinkedNode();
        current = first;
        if (first != null){
            do {
                System.out.println(current.data);
                current = current.next;
            }while (current != first);

        }else {
            System.out.println("vacia");
        }
    }

    public String search2(String x){
        DoubleLinkedNode current = new DoubleLinkedNode();
        current = last;
        Boolean found = false;
        do {
            if (current.data.getTitule() == x){
                found = true;
            }
            current=current.previous;
        }while (current != last && found != true);
        if (found == true){
            System.out.println("encontrado");
        }else {

        }
        return current.data.getTitule();
    }
    public DoubleLinkedNode getFirst() {
        return first;
    }
    public DoubleLinkedNode getLast() {
        return last;
    }
}
