package listClasses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader{
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    public LinkedList lista_canciones=new LinkedList();
    private int contador;

    //Idea para el lector extraída de https://www.youtube.com/watch?v=uwn-Zkttux4
    public void leerArchivo(String nombreArchivo) {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo)); // crea un bufferreader que recibe el csv
            while ((linea = lector.readLine()) != null) { //para hasta que no haya nada que leer
                partes = linea.split(","); //lo leído lo parte cada ¨,¨ y lo guarda en partes

                Song cancion = new Song(partes[1]);//crea un nuevo estdudiante con el metedo create_student

                lista_canciones.insertFirst(cancion); //añade el estudiante a la lista

            }

        } catch (Exception e) {
            System.out.println(e);// si da error que muestre en la consola el error
        }
    }

}

