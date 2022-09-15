package interactive_windows;

import listClasses.Player;
import listClasses.Reader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;


public class MainSecundario {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        // Song zelda = new Song("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav");
        // Song mario = new Song("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\mario.wav");

        Reader lector_csv = new Reader();
        lector_csv.leerArchivo("C:\\Users\\Adrian\\Desktop\\canciones.csv");

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(lector_csv.lista_canciones.getCurrent().getData().getUrl()));
        //AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\Zelda.mp3");
        //System.out.println(lector_csv.lista_canciones.getCurrent().getData().getUrl());


        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        player.start_fc(clip);

        String response = "";


        while (!response.equals("Q")) {
            System.out.println("P = play, S = Stop, R = Reset, V = Skip, U = UpVolume, D = DownVolume, M = Mute, Q = Quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            //while (player.duration(clip)>=player.framePosition(clip)+10000)
            switch (response) {
                case ("B"):
                    System.out.println(player.duration(clip));
                    break;
                case ("V"):
                    clip.close();
                    //Para pasar poner next
                    audioStream = AudioSystem.getAudioInputStream(new File(lector_csv.lista_canciones.getCurrent().getNext().getData().getUrl()));
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    player.reset_song(clip);
                    player.start_fc(clip);
                    break;
                case ("R"):
                    player.reset_song(clip);
                case ("P"):
                    player.play_song(clip);
                    break;
                case ("S"):
                    player.stop_song(clip);
                    break;
                case ("U"):
                    player.volumeUp(clip);
                    break;
                case ("D"):
                    player.volumeDown(clip);
                    break;
                case ("M"):
                    player.volumeMute(clip);
                    break;

                default:
                        /*if (player.duration(clip)==player.framePosition(clip)){
                            clip.close();
                            //Para pasar poner next
                            audioStream = AudioSystem.getAudioInputStream(new File(lector_csv.lista_canciones.getCurrent().next.getData().getUrl()));
                            clip = AudioSystem.getClip();
                            clip.open(audioStream);
                            player.reset_song(clip);
                            player.start_fc(clip);
                        }*/
                    System.out.println("Not a valid response");
            }

            /*clip.close();
            //Para pasar poner next
            audioStream = AudioSystem.getAudioInputStream(new File(lector_csv.lista_canciones.getCurrent().getNext().getData().getUrl()));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            player.reset_song(clip);
            player.start_fc(clip);
            player.play_song(clip);*/
        }
        System.out.println("Byeeee!");
    }
}