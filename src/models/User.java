package models;

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
    private static int UserDeserializationCounter = 0;
    
    
    public User() {
    }
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        
        //add to users List
        allUsers.add(this);
        
        //re-serialize the list to file
        serializeAllUsers(allUsers);
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void addUsers(User u) {
        //This adds users to the arraylist and checks beforehand if a username is already taken
        
    }
    
    public void serializeAllUsers(ArrayList<User> userlist) {
        /*each time a new user is created this method serializes the classvariable allUsers to file*/
        
        ObjectOutputStream oos = null;
        FileOutputStream fos;
        
        try {
            fos = new FileOutputStream(filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser", false);
            OutputStream buffer = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allUsers);
            
            for (User u : userlist) {
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
    
    public static void deserializeAllUsers() {
        /*deserializes the users file and stores it in the ram; this gets called on the first visit to /*/
        /*TODO: this doesn't work anymore, fix me*/
        System.out.println("calling user deserialization method");
        ObjectInputStream ois = null;
        FileInputStream fis;
        
        if (UserDeserializationCounter == 0) {
            System.out.println("counter = 0, start condition met, users deserialized");
            try {
                try {
                    fis = new FileInputStream(absFilePath);
                    ois = new ObjectInputStream(fis);
                    allUsers = (ArrayList<User>) ois.readObject();
                    
                    //display the deserialized users:
                    for (User u : allUsers) {
                        System.out.println(u.getUsername());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found when trying to deserialize users");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("IOEx");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                    e.printStackTrace();
                }
                
                UserDeserializationCounter = 1;
            } catch (Exception e) {
                System.out.println("User deserialization failed, counter not decremented");
                e.printStackTrace();
            }
        } else {
            System.out.println("Users are already deserialized, runcondition not met.");
        }
        
        
    }
    
    public static ArrayList<User> getAllUsers() {
        //returns the class variable allUsers which is an arrayList holing all available users
        return allUsers;
    }
    
}
