package models;

import resources.gson.*;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String username;
    private String password;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    
    
    public User() {
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    public void serializeUser(User u) {
        //use gson to serialize ze user to json for persistence
        Gson gsonSerializer = new Gson();
        String jsonString = gsonSerializer.toJson(u);
        String initialJsonContent = "{\"users\": [\n" +
                                            "  {\"username\": \"a\", \"password\": \"b\"},\n" +
                                            "  {\"username\": \"c\", \"password\": \"d\"}\n" +
                                            "]}";
       
        
        //create the serializedusers.json if it doesnt exist yet and prepopulate with the initial json structure
        try {
            File f = new File(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.json");
            
            if (f.createNewFile()) {
                //write the initial json structure:
                
                try {
                    FileWriter fw = new FileWriter(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.json", true);
                    fw.write(initialJsonContent);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("File successfully created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        //write the users to the json
        try {
            FileWriter fw = new FileWriter(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.json", true);
            fw.write(jsonString);
            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
