package models;

import com.sun.media.sound.SoftLowFrequencyOscillator;
import org.jcp.xml.dsig.internal.SignerOutputStream;
import resources.gson.*;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.io.*;

public class User implements Serializable {
    private String username;
    private String password;
    private static final long SerialVersionUID = 1L;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    private File f;
    
    
    public User() {
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        
        serializeUser(this);
    }
    
    public void serializeUser(User u) {
        
        ObjectOutputStream oos = null;
        FileOutputStream fos;
        
        try {
            fos = new FileOutputStream(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser", true);
            OutputStream buffer = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
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
