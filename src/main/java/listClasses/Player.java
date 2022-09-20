package listClasses;
import javax.sound.sampled.*;

public class Player {
    public float previousVolume = 0;
    public float currentVolume = 0;
    FloatControl fc;
    boolean mute = false;

    public void start_fc(Clip clip){
        fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
    }

    public void play_song(Clip clip) {
        clip.start();
    }
    public void reset_song(Clip clip){
        clip.setFramePosition(0);
    }
    public int duration(Clip clip){ return clip.getFrameLength();}
    public int framePosition(Clip clip){return clip.getFramePosition();}

    public void stop_song(Clip clip) {
        clip.stop();
    }

    public void volumeUpTest(Clip clip) {
        fc.setValue(1.0f);
        System.out.println(fc);
        //fc.setValue(currentVolume);
    }

    public void volumeUp(Clip clip) {
        currentVolume += 1.0f;
        if (currentVolume > 6.0f) {
            currentVolume = 6.0f;
        }
        fc.setValue(currentVolume);
    }

    public void volumeDown(Clip clip) {
        currentVolume -= 10.0f;
        if (currentVolume < -80.0f) {
            currentVolume = -80.0f;
        }
        fc.setValue(currentVolume);
    }

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
}