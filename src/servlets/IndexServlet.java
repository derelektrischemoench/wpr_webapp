package servlets;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

import static models.User.deserializeAllUsers;

public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // deserialize all users to ram on the first visit to the site to make them available in the arraylist
        deserializeAllUsers();
        
        //TODO:The deserialization that happens in User needs to be called in This servlet, which as of now doesn't yet get called, fix
        
        
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        //rd.forward(request, response);
    }
}
