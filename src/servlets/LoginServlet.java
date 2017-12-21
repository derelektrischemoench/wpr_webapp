package servlets;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        /*TODO: do the deserialization @ startup and make the arraylist globally available*/
        try {
            InputStream fi = new FileInputStream(usersFilePath);
            InputStream buffer = new BufferedInputStream(fi);
            ObjectInput oi = new ObjectInputStream(buffer);
            
            //deserialize the users Arraylist:
            try {
                ArrayList<User> users = (ArrayList<User>) oi.readObject();
                String inputUsername = req.getParameter("name");
                String inputPassword = req.getParameter("password");
                
                //display it just so we know its working:
                for (User u : users) {
                    System.out.println(u.getUsername());
                    System.out.println(u.getPassword());
                    
                    if (u.getUsername().equals(inputUsername)) { //the user exists in the serialized users file
                        if (u.getPassword().equals(inputPassword)) { //the password is correct
                            Cookie[] cookies = req.getCookies();
                            boolean foundCookie = false;
                            
                            //In case the username is already signed in
                            for (int i = 0; i < cookies.length; i++) {
                                Cookie cookie1 = cookies[i];
                                if (cookie1.getName().equals(u.getUsername())) {
                                    System.out.println(cookie1.getValue());
                                    foundCookie = true;
                                }
                            }
                            
                            //the user is not yet authenticated, give him a cookie
                            if (!foundCookie) {
                                Cookie cookie1 = new Cookie("Username", u.getUsername());
                                cookie1.setMaxAge(24 * 3600); //1 day lifespan
                                res.addCookie(cookie1);
                            }
                            
                            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/loginSuccessful.jsp");
                            rd.forward(req, res);
                        } else {
                            //the password provided is incorrect, render the signin form again
                            String errorMsg = "The password you provided is incorrect";
                            
                            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                            req.setAttribute("errorMsg", errorMsg);
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
