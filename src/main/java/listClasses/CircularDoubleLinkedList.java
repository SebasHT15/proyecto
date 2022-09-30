//https://www.youtube.com/watch?v=gTOJPSVLuEk Este es funcional
package listClasses;

/**
 * Lista doblementecircular enlazada.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class CircularDoubleLinkedList {
    /**
     * Metodo constructor de CircularDoubleLinkedList.
     */
    private DoubleLinkedNode first;
    private DoubleLinkedNode last;
    private Integer size = 0;
    public CircularDoubleLinkedList(){ //Metodo constructor
        first =null;
        last=null;
    }

    /**
     * Limpia la lista.
     */
    public void clear(){ //Elimina la referencias por lo tecnicamente limpia la linked list
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserta una nueva canción a la lista.
     * @param data Objeto Song
     */
    public void insert(Song data){//Se le pasa una canción que inserta en la linked list
        DoubleLinkedNode newdoubleLinkedNode = new DoubleLinkedNode();//Nuevo nodo
        newdoubleLinkedNode.data=data; //Se le asigna la data al nuevo nodo
        if (first ==null){ //El caso de ser el primero en la lista
            first =newdoubleLinkedNode;
            last=newdoubleLinkedNode;
            first.next= first;
            last.previous=last;
        }else { // Se hace que la referencia de ultimo nodo pase a ser el nuevo nodo y reacomoda la referencias para que este nuevo nodo sea el ultimo
            last.next=newdoubleLinkedNode;
            newdoubleLinkedNode.next= first;
            newdoubleLinkedNode.previous=last;
            last=newdoubleLinkedNode;
            first.previous=last;
        }
        this.size=this.size+1;//Aumenta el tamaño de la lista en 1
    }

    /**
     * Busca una canción en el la lista.
     * @param x Obejeto Song
     */
    public void search(Song x){ //Busca un nodo y printea si lo encontró o no
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

    /**
     * Printea la lista en la consola.
     */
    public void displayList(){ // Printea la lista en la consola
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

    /**
     * Borra una canción de la lista.
     * @param x Nombre de la canción a borrar.
     */
    public void delete(String x) { //Se le pasa un string que va a ser el titulo de la canción y busca este para eliminarlo, cambiando las referencias
        DoubleLinkedNode current = new DoubleLinkedNode();
        DoubleLinkedNode previous_temp = new DoubleLinkedNode();
        current = first;
        previous_temp = last;
        do {
            if (current.getData().getTitule() == x) {
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

        this.size=this.size-1;
    }

    /**
     * Retorna el primer nodo.
     * @return Objeto nodo.
     */
    public DoubleLinkedNode getFirst() {
        return first;
    } //Retorna el primer nodo

    /**
     * Retorna el último nodo.
     * @return Objeto nodo.
     */
    public DoubleLinkedNode getLast() {
        return last;
    } //Retorna el ultimo nodo

    /**
     * Retorna el tamaño de la lista.
     * @return Integer size.
     */
    public Integer getSize(){return this.size;} //Retorna el tamaño
}
