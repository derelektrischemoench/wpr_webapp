package models;

import com.sun.media.sound.SoftLowFrequencyOscillator;
import org.jcp.xml.dsig.internal.SignerOutputStream;
import resources.gson.*;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String password;
    private static final long SerialVersionUID = 1L;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    private File f;
    private static ArrayList<User> allUsers = new ArrayList<User>(); //class variable to hold all users; this gets serialized
    
    
    public User() {
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        
        //add to users List
        allUsers.add(this);
    
        System.out.println(allUsers);
        //re-serialize the list to file
        serializeAllUsers(allUsers);

    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void serializeAllUsers(ArrayList<User> userlist) {
        /*each time a new user is created this method serializes the classvariable allUsers to file*/
        
        ObjectOutputStream oos = null;
        FileOutputStream fos;
        
        try {
            fos = new FileOutputStream(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser", false);
            OutputStream buffer = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allUsers.size());
            
            for (User u : userlist ) {
                oos.writeObject(u);
            }
            
        } catch (Exception e) {
            System.out.println("OhNoes");
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    System.out.println("Failure on closing oos");
                    e.printStackTrace();
                }
            }
        }
    }
    
}
