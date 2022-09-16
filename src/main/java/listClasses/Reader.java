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

    //Idea para el lector extraída de https://www.youtube.com/watch?v=uwn-Zkttux4
    public void crear_canciones(String nombreArchivo) {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");

                Song cancion = new Song(partes[1]);

                lista_canciones.insertFirst(cancion);


            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String ver_nombre_usuario(String nombreArchivo) {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
            }
        } catch (Exception e) {System.out.println(e);
        }return partes[0];
    }
    public String ver_contra_usuario(String nombreArchivo) {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
            }
        } catch (Exception e) {System.out.println(e);
        }return partes[1];
    }
}

