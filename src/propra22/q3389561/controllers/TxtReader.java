package propra22.q3389561.controllers;

import propra22.q3389561.models.CPArrayList;
import propra22.q3389561.models.CPoint;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Klasse für einen Controller, mit dem txt-Dateien ausgelesen werden können
 */
public class TxtReader {


    public static CPArrayList getCPListFromFile(String filePath){

        CPArrayList list = new CPArrayList();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            //StringBuffer stringBuffer = new StringBuffer();
            String line;
            while((line = bufferedReader.readLine())!=null)
            {
               list.add(CPoint.cpointFromString(line));
            }
            bufferedReader.close();
            return list;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }

    }


}
