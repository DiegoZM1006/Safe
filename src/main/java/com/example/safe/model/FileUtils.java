package com.example.safe.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static String readFile(String path){
        StringBuilder output = new StringBuilder();
        File f = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String line;
            while( (line = reader.readLine()) != null ){
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(output.substring(0, 6));
        return output.toString();
    }

    public static void fillDB() {

        String content = FileOpenerData.getInstance().getPassword().getPassword() +
                FileOpenerData.getInstance().getPassword().getContentUser();
        try {
            FileOutputStream fos = new FileOutputStream(new File("data.txt"));
            byte[] contentInBytes = content.getBytes();
            fos.write(contentInBytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}