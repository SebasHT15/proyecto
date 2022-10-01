package listClasses;

import java.io.*;

/**
 * Lee archivos csv que modifican las bibliotecas.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class PlaylistReader {
    private static String linea;
    private static String[] partes = null;

    private static BufferedReader bufferedReader;

    /**
     * Borra una biblioteca.
     * @param filepath Url del csv de las bibliotecas.
     * @param editTerm Nombre de la biblioteca a eliminar.
     */
    public static void deletePlaylist(String filepath, String editTerm){
        String tempFile = "temp.csv" ;
        File oldFile = new File(filepath) ;
        File newFile = new File(tempFile) ;

        String name = "";
        String date = "";
        String number_songs = "";
        String url = "";

        try {
            FileWriter fw = new FileWriter(tempFile,true) ;
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            bufferedReader = new BufferedReader(new FileReader(filepath));


            while ((linea = bufferedReader.readLine()) != null){
                partes = linea.split(",");

                name = partes[0];
                date = partes[1];
                number_songs = partes[2];
                url = partes[3];

                if (name.equals(editTerm)) {
                    //pw.println(newName + "," + newDate + "," + newNumber_songs);

                } else {
                    pw.println(name + "," + date + "," + number_songs + "," + url);
                }

            }
            pw.close();
            bufferedReader.close();

            oldFile.delete();

            File last = new File (filepath) ;
            newFile.renameTo (last) ;

        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Añade una biblioteca.
     * @param filepath Url del csv de las bibliotecas.
     * @param newName Nombre de la nueva biblioteca.
     * @param newDate Fecha de creación.
     * @param newNumber_songs Número de canciones que tiene la biblioteca.
     * @param newUrl
     */
    public static void addPlaylist(String filepath, String newName, String newDate, String newNumber_songs, String newUrl){
        String tempFile = "biblio.csv" ;
        File oldFile = new File(filepath) ;
        File newFile = new File(tempFile) ;

        String name = "";
        String date = "";
        String number_songs = "";
        String url = "";


        try {
            FileWriter fw = new FileWriter(tempFile,true) ;
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            bufferedReader = new BufferedReader(new FileReader(filepath));


            while ((linea = bufferedReader.readLine()) != null){
                partes = linea.split(",");

                name = partes[0];
                date = partes[1];
                number_songs = partes[2];
                url = partes[3];

                pw.println(name + "," + date + "," + number_songs + "," + url);
            }
            pw.println(newName + "," + newDate + "," + newNumber_songs + "," + newUrl);

            pw.close();
            bufferedReader.close();
            bw.close();
            fw.close();

            oldFile.delete();



            oldFile.delete();

            File last = new File (filepath) ;
            newFile.renameTo (last) ;

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
