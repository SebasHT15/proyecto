package listClasses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lee un csv que se le manda para crear usuarios o bibliotecas
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class Reader{
    private Integer number_playlist = 0;
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    public List<Usuario> lista_usuarios = new ArrayList();
    public List<Playlist> lista_playlist = new ArrayList<>();

    /**
     * Lee el csv que se le manda y crea una lista de usuarios con este.
     * @param nombreArchivo Url del csv de los usuarios.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void crear_usuario(String nombreArchivo) throws IOException {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");

                Usuario usuario = new Usuario(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);

                lista_usuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        lector.close();
    }

    /**
     * Lee el csv que se le manda y crea una lista de bibliotecas.
     * @param nombreArchivo Url del csv de las bibliotecas.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void crear_bibliotecas(String nombreArchivo) throws IOException {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                // Probando el contador de canciones--------------
                ReadXML.crearCancionesXml(partes[3]); //Crea las canciones con el static de Read xml y se le pasa la url leida en el csv
                int size = ReadXML.returnLista().getSize(); //Con las canciones creadas llama a las lista que las contiene y guarda la extencion.
                //-----------------

                Playlist playlist = new Playlist(partes[0], partes[1], size, partes[3]);//Crea un onjeto playlist con la info del csv
                lista_playlist.add(playlist);

                number_playlist++;
                ReadXML.returnLista().clear();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        lector.close();
    }
    public int getNumber_playlist(){
        return this.number_playlist;
    }
}

