package Arduino;

import com.fazecast.jSerialComm.SerialPort;

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

        Scanner data = new Scanner(port.getInputStream());
        int value = 0;

        while(data.hasNextLine()){
            try{value = Integer.parseInt(data.nextLine());}
            catch(Exception e){

            }
            System.out.println(value);
        }
    }

    public void SendData(String string) throws IOException {
        port.getOutputStream().write(string.getBytes());
        port.getOutputStream().flush();
    }

    public Integer GetData() throws IOException {
        port.getInputStream().read();
        port.getInputStream().reset();
        int Arduino = port.getInputStream().read();
        return Arduino;
    }
}
