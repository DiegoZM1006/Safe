package com.example.safe.model;

import java.io.*;

public class FileOpenerData {

    // Formato del singleton
    private static FileOpenerData instance;

    private FileOpenerData(){
        password = new Password("","");
    }

    public static FileOpenerData getInstance(){
        if(instance == null){
            instance = new FileOpenerData();
            String completeText = FileUtils.readFile("data.txt");
            // System.out.println(completeText.substring(0, 6));
            // System.out.println(completeText.substring(6, completeText.length() - 1));
            Password myPassword = new Password(completeText.substring(0, 6), completeText.substring(6, completeText.length() - 1));
            instance.setPassword(myPassword);
        }
        return instance;
    }

    // Los atributos de la clase
    public Password password;

    public Password getPassword(){
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
        FileUtils.fillDB();
    }

}
