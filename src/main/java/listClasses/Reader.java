package listClasses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader{
    private Integer number_playlist = 0;
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    public List<Usuario> lista_usuarios = new ArrayList(); //definir tamano
    public List<Playlist> lista_playlist = new ArrayList<>();

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
    public void crear_bibliotecas(String nombreArchivo) throws IOException {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");

                Playlist playlist = new Playlist(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3]);
                lista_playlist.add(playlist);

                number_playlist++;
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

