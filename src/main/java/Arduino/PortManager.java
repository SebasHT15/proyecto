package Arduino;

import com.fazecast.jSerialComm.SerialPort;
import interactive_windows.WindowReproductor;

import java.io.IOException;
import java.util.Scanner;

public class PortManager extends Thread{
    private static PortManager instance;
    private SerialPort port = SerialPort.getCommPort("COM3");

    public static PortManager getInstance(){
        if(instance == null){
            instance = new PortManager();
        }
        return instance;
    }


    @Override
    public void run(){
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        /*try {
            GetData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void SendData(String string) throws IOException {
        port.getOutputStream().write(string.getBytes());
        port.getOutputStream().flush();
    }

    public int GetData() throws IOException {
        Scanner data = new Scanner(port.getInputStream());
        int value = 0;

        while(data.hasNextLine()){
            try{value = Integer.parseInt(data.nextLine());}
            catch(Exception e){

            }
            //System.out.println(value);
        }
        return value;
    }
}
