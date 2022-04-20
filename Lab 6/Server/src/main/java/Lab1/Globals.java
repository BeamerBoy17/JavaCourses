/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;
import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 *
 * @author Mike Lane
 */
public class Globals {
    public static final int CalculationThreadsCount = 3;
    public static IntegrationServer server = null;
    public static int[] selectedRecs = null;
    public static ArrayList<RecIntegral> tableRecs = new ArrayList<>();
    public static ArrayList<RecIntegral> tableRecsFromFile(FileInputStream stream) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));

        ArrayList<RecIntegral> tableRecs = new ArrayList<>();
        String line;
        try{
            while ((line = br.readLine()) != null) {
                tableRecs.add(RecIntegral.fromString(line));
            }
        }catch (IOException e){
            throw e;
        }

        return tableRecs;
    }

    private static boolean recsStatus = false;
    public static synchronized void setRecsStatus(boolean value){
        recsStatus = value;
    }

    public static synchronized boolean getRecsStatus(){
        return recsStatus;
    }
}
