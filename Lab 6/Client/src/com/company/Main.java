package com.company;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class Client{
    private static final String serverName = "localhost";
    private static final int port = 2437;

    private final int threadsCount = 3;

    public void start(){
        try {
            Socket client = new Socket(serverName, port);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            String inData = in.readUTF();
//            while (inData.length() == 0){
//                Thread.sleep(1);
//                inData = in.readUTF();
//            }

            ArrayList<RecIntegral> recs = new ArrayList<>();
            for (var line : inData.lines().toList()){
                recs.add(RecIntegral.fromString(line));
            }

            IntegrationThread[] threads = new IntegrationThread[threadsCount];

            var results = new ArrayList<Double>();

            int processedRowsCount = 0;
            while (processedRowsCount != recs.size()){
                int iterationsCount = Integer.min(threadsCount,recs.size()-processedRowsCount);
                try{
                    for (int i = 0; i < iterationsCount; i++){
                        RecIntegral rec = recs.get(i);
                        threads[i] = new IntegrationThread(rec.lowerEdge,rec.upperEdge,rec.step);
                        threads[i].start();
                    }
                    for (int i = 0; i < iterationsCount; i++){
                        threads[i].join();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return;
                }
                for (int i = 0; i < iterationsCount; i++){
                    results.add(threads[i].getResult());
                }
                processedRowsCount+=iterationsCount;
            }
            StringBuilder outData = new StringBuilder();
            for (double result:results){
                outData.append(result).append("\n");
            }
            out.writeUTF(outData.toString());

        } catch (IOException e) {
            System.out.println("Сервер недоступен");
        } catch (RecIntegralException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Client().start();
    }
}
