package Lab1;

import org.w3c.dom.events.MutationEvent;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class IntegrationServer extends Thread{
    public static final int port = 2437;
    public static final int timeout = 30000;

    private boolean clientConnected = false;
    private final ServerSocket serverSocket;
    IntegrationServerResultGetter getter;

    public IntegrationServer(int port,IntegrationServerResultGetter getter) throws IOException {
        this.getter = getter;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);
    }
    public synchronized boolean getConnectionStatus(){
        return clientConnected;
    }
    public void run() {
        while(true) {
            try {
                clientConnected = false;
                serverSocket.getLocalPort();
                Socket server = serverSocket.accept();
                //server.getRemoteSocketAddress();
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                DataInputStream in = new DataInputStream(server.getInputStream());

                clientConnected = true;
                while (!Globals.getRecsStatus()){
                    sleep(20);
                }
                Globals.setRecsStatus(false);

                StringBuilder outData = new StringBuilder();
                for (int i : Globals.selectedRecs){
                    outData.append(Globals.tableRecs.get(i).toString());
                }
                out.writeUTF(outData.toString());

                var results = new ArrayList<Double>();
                String inData = in.readUTF();

                for (var line : inData.lines().toList()){
                    results.add(Double.parseDouble(line));
                }
                getter.getResult(results.toArray());
            } catch (SocketTimeoutException s) {
                JOptionPane.showMessageDialog(null,"Время сокета истекло!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
