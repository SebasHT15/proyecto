package listClasses;

import java.io.*;

public class PlaylistReader {
    private static String linea;
    private static String[] partes = null;

    private static BufferedReader bufferedReader;

    public static void editRecord(String filepath, String editTerm, String newName, String newDate, String newNumber_songs){
        String tempFile = "temp.csv" ;
        File oldFile = new File(filepath) ;
        File newFile = new File(tempFile) ;

        String name = "";
        String date = "";
        String number_songs = "";

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

                if (name.equals(editTerm)) {
                    pw.println(newName + "," + newDate + "," + newNumber_songs);

                } else {
                    pw.println(name + "," + date + "," + number_songs);
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
}
