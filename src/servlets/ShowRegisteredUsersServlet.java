package servlets;

import com.sun.xml.wss.saml.internal.saml11.jaxb10.Object;
import models.User;
import org.omg.CosNaming.IstringHelper;
import resources.gson.internal.bind.util.ISO8601Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class ShowRegisteredUsersServlet extends HttpServlet implements Serializable {
    private static long SerialVersionUID = 1L;
    private static final String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    private static final String absFilePath = filePath + "/IdeaProjects/wprLernplatform/src/models/serializedUsers.ser";
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //deserialize the users file:
        
        User deserializedUser = null;
        
        try {
            FileInputStream file = new FileInputStream(absFilePath);
            ObjectInputStream ois = new ObjectInputStream(file);
            
            deserializedUser = (User) ois.readObject();
            ois.close();
            file.close();
            
            String userName = deserializedUser.getUsername();
            String userPass = deserializedUser.getPassword();
            
            
            
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showRegisteredUsers.jsp");
            req.setAttribute("userName", userName);
            req.setAttribute("userPass", userPass);
            
            rd.forward(req, resp);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Read didnt work");
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
