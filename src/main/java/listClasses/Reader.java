package listClasses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader{
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    public LinkedListSongs lista_canciones=new LinkedListSongs();
    public List<Usuario> lista_usuarios = new ArrayList(); //definir tamano

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

    public void crear_usuario(String nombreArchivo){
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");

                Usuario usuario = new Usuario(partes[0], partes[1], partes[2], partes[3], partes[4]);

                lista_usuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

