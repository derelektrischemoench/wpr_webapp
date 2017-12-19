package servlets;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/*This servlet handles the login credentials sent by the form @ /jsp -> it looks up the username in the file, checks the password and does the auth*/

public class LoginServlet extends HttpServlet implements Serializable {
    private static long SerialVersionUID = 1L;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String savedUsername;
        String savedPassword;
        String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        String usersFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
        
        //deserialize the users file
        /*TODO: make the deserialization @ startup and make the arraylist globally available*/
        try {
            InputStream fi = new FileInputStream(usersFilePath);
            InputStream buffer = new BufferedInputStream(fi);
            ObjectInput oi = new ObjectInputStream(buffer);
            
            //deserialize the users Arraylist:
            try {
                ArrayList<User> users = (ArrayList<User>)oi.readObject();
                String inputUsername = req.getParameter("name");
                String inputPassword = req.getParameter("password");
                
                //display it just so we know its working:
                System.out.println("Input username: " + inputUsername);
                System.out.println("Input password: " + inputPassword);
                System.out.println("registered users:");
                for(User u : users) {
                    System.out.println(u.getUsername());
                    System.out.println(u.getPassword());
                    
                    if (u.getUsername().equals(inputUsername)){ //the user exists in the serialized users file
                        System.out.println("The user exists");
                        if (u.getPassword().equals(inputPassword)) { //the password is correct
                            System.out.println("the password is correct");
                            //todo: create session and set cookie
                            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/loginSuccessful.jsp");
                            rd.forward(req, res);
                        }
                    }
                }
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException fnf) {
            System.out.println("File could not be opened");
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
