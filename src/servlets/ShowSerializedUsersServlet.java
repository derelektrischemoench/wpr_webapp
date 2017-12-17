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
import java.io.*;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class ShowSerializedUsersServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //deserialize the users file:
        try {
            InputStream file = new FileInputStream("serializedUsers.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
    
            System.out.println("first try-block \n");
            System.out.println("first try-block \n");
            
            try {
                List<User> deserializedUsers = (List<User>) input.readObject();
    
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showSerializedUsers.jsp");
                req.setAttribute("deserializedUsers", deserializedUsers);
                rd.forward(req, resp);
                
                System.out.println("second try-block \n");

                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
