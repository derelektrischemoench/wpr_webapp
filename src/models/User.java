package models;
import resources.gson.*;

import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String username;
    private String password;
    
    
    public User() {}
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    public void serializeUser(User u) {
        //use gson to serialize ze user to json for persistence
        Gson gsonSerializer = new Gson();
        String jsonString = gsonSerializer.toJson(u);
    
        System.out.println(jsonString);
        
        //dump that suckah to file yo
        //TODO: note; to view stdout output start the server in debug mode and enjoy log values under the glassfish log section in "debug"
        try {
            FileWriter fw = new FileWriter("serializedUsers.json");
            fw.write(jsonString);
            fw.close();
        } catch (IOException e) {
            System.out.println("fml");
        }
    }
}
