//https://www.youtube.com/watch?v=J1T5VJ93SAk se hizo a partir de este video.


package listClasses;

public class CircularDoubleLinkedList {
    DoubleLinkedNode primero;
    DoubleLinkedNode ultimo;

    public CircularDoubleLinkedList(){
        primero = null;
        ultimo = null;
    }

    public void ingresarNodo(int dato){
        DoubleLinkedNode nuevo = new DoubleLinkedNode();
        nuevo.dato = dato;

        if(primero == null){
            primero = nuevo;
            ultimo = primero;
            primero.siguiente = ultimo;

        }else{
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
        }
    }

    public void buscarNodo(int dato) {
        DoubleLinkedNode actual = new DoubleLinkedNode();
        actual = primero;
        boolean encontrar = false;

        do{
            if(actual.dato == dato){
                encontrar = true;
            }

            actual = actual.siguiente;

        }while(actual != primero);
        if (encontrar == true){
            System.out.println("nodo encontrado");

        }else{
            System.out.println("no existe");
        }
    }

    public void eliminarNodo(int dato){
        DoubleLinkedNode actual = new DoubleLinkedNode();
        DoubleLinkedNode anterior = new DoubleLinkedNode();
        actual = primero;
        anterior = ultimo;

        do{
            if(actual.dato == dato){
                if(actual == primero){
                    primero = primero.siguiente;
                    ultimo.siguiente = primero;

                }else if(actual == ultimo){
                    anterior.siguiente = ultimo.siguiente;
                    ultimo = anterior;
                }else{
                    anterior.siguiente = actual.siguiente;
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }while(actual != primero);
    }


}
