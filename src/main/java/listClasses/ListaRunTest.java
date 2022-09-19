package listClasses;

public class ListaRunTest {
    public static void main(String[] args){
        CircularDoubleLinkedList list=new CircularDoubleLinkedList();
        list.insert(0);
        list.insert(2);
        list.insert(1);


        list.displayList();

        list.delete(2);

        list.displayList();

    }
}
