package listClasses;
import javax.sound.sampled.*;

/**
 * Crea un objeto capaz de reproducir sonidos de archivos .wav.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class Player {
    public float previousVolume = 0;
    public float currentVolume = 0;
    FloatControl fc;
    boolean mute = false;

    /**
     * Inicializa el controlador del volumen.
     * @param clip Url de la canción a reproducir.
     */

    public void start_fc(Clip clip){
        fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
    }

    /**
     * Reproduce la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void play_song(Clip clip) {
        clip.start();
    }

    /**
     * Reinicia la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void reset_song(Clip clip){
        clip.setFramePosition(0);
    }

    /**
     * Retorna la duración de la canción.
     * @param clip Url de la canción a reproducir.
     * @return Duración de la canción.
     */
    public int duration(Clip clip){ return clip.getFrameLength();}

    /**
     * Retorna el momento en frames en que se encuentra la canción.
     * @param clip Url de la canción a reproducir.
     * @return Frame en que esta la canción.
     */
    public int framePosition(Clip clip){return clip.getFramePosition();}

    /**
     * Detiene la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void stop_song(Clip clip) {
        clip.stop();
    }

    /**
     * Sube el volumen de la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void volumeUp(Clip clip) {
        currentVolume += 1.0f;
        if (currentVolume > 6.0f) {
            currentVolume = 6.0f;
        }
        fc.setValue(currentVolume);
    }

    /**
     * Baja el volumne de la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void volumeDown(Clip clip) {
        currentVolume -= 1.0f;
        if (currentVolume < -80.0f) {
            currentVolume = -80.0f;
        }
        fc.setValue(currentVolume);
    }

    /**
     * Setea el volumen de la canción.
     * @param flotante Volumen de la canción.
     */
    public void setVolume(float flotante){
        fc.setValue(flotante);
    }

    /**
     * Mutea la canción.
     * @param clip Url de la canción a reproducir.
     */
    public void volumeMute(Clip clip) {
        if (mute == false) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            mute = true;
        } else
        if (mute == true) {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            mute = false;
        }
    }

    /**
     * Retorna el controlador del volumen.
     * @return fc controladaor del volumen.
     */
    public FloatControl getFc(){
        return fc;
    }
}