package servlets;

import com.sun.corba.se.spi.orbutil.fsm.InputImpl;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowRegisteredUsersServlet extends HttpServlet implements Serializable {
    private static long SerialVersionUID = 1L;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //create users file if ! exist to prevent fuckery
        File SerializedUsers = new File(absFilePath);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showRegisteredUsers.jsp");
        
        if (!SerializedUsers.exists()) {
            SerializedUsers.createNewFile();
        }
    
        
        /*todo: this has to be in accordance w/ the deserialization loop inhibitor in User -> on every new user add the ArrayList<User> allUsers has to be repopulated*/
        
        ArrayList<User> deserializedUsers = User.getAllUsers();
        
        req.setAttribute("deserializedUsers", deserializedUsers);
        rd.forward(req, resp);
    }
}
