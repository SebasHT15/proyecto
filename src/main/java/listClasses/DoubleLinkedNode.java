package listClasses;

public class DoubleLinkedNode {
    Song data; //Data del nodo
    DoubleLinkedNode next; //Siguiente nodo
    DoubleLinkedNode previous; //Nodo anterior

    /**
     * Retorna la data del DoubleLinkedNode.
     * @return Obejto Song.
     */
    public Song getData() {
        return data;
    }

    /**
     * Retorna el siguiente DoubleLinkedNode.
     * @return Objeto DoubleLinkedNode.
     */
    public DoubleLinkedNode getNext() {return next;}

    /**
     * Retorna el DoubleLinkedNode anterior.
     * @return Obeto DoubleLinkedNode.
     */
    public DoubleLinkedNode getPrevious() {return previous;}
}
