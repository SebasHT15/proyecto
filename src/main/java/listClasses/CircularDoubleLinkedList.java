//https://www.youtube.com/watch?v=gTOJPSVLuEk Este es funcional
package listClasses;


public class CircularDoubleLinkedList {
    private DoubleLinkedNode fist;
    private DoubleLinkedNode last;
    public CircularDoubleLinkedList(){
        fist=null;
        last=null;
    }
    public void insert(Integer data){
        DoubleLinkedNode newdoubleLinkedNode = new DoubleLinkedNode();
        newdoubleLinkedNode.data=data;
        if (fist==null){
            fist=newdoubleLinkedNode;
            last=newdoubleLinkedNode;
            fist.next=fist;
            last.previous=last;
        }else {
            last.next=newdoubleLinkedNode;
            newdoubleLinkedNode.next=fist;
            newdoubleLinkedNode.previous=last;
            last=newdoubleLinkedNode;
            fist.previous=last;
        }
    }
    public void delete(int x) {
        DoubleLinkedNode current = new DoubleLinkedNode();
        DoubleLinkedNode previous_temp = new DoubleLinkedNode();
        current = fist;
        previous_temp = last;
        do {
            if (current.data == x) {
                if (current == fist){
                    fist = fist.next;
                    last.next = fist;
                    fist.previous = last;
                } else if (current == last) {
                    last = previous_temp;
                    fist.previous = last;
                    last.next = fist;
                }
                else {
                    previous_temp.next = current.next;
                    current.next.previous = previous_temp;
                }
            }
            previous_temp = current;
            current = current.next;
        }while (current != fist);
    }
    public void search(int x){
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
        current = fist;
        if (fist != null){
            do {
                System.out.println(current.data);
                current = current.next;
            }while (current != fist);

        }else {
            System.out.println("vacia");
        }
    }
}
