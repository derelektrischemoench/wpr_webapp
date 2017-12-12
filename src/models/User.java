package models;

import resources.gson.*;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.io.*;

public class User implements java.io.Serializable {
    private String username;
    private String password;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    private File f;
    
    
    public User() {
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    public void serializeUser(User u) {
        //use gson to serialize ze user to json for persistence
        try {
            f = new File(absFilePath);
            
            if (f.createNewFile()) {
                System.out.println("File successfully created");
                
                try {
                    FileOutputStream foS = new FileOutputStream(absFilePath);
                    ObjectOutputStream ooS = new ObjectOutputStream(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        //write the users to the json
        try {
            FileOutputStream foS = new FileOutputStream(absFilePath);
            ObjectOutputStream ooS = new ObjectOutputStream(f);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
