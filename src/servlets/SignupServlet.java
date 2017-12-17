package servlets;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
        rd.forward(req, res);
    }
    
    //TODO: do this with the database connection: see "Datenanbindungen" Script
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String username = req.getParameter("name");
        String password1 = req.getParameter("password");
        String password2 = req.getParameter("password2");
       
       
        if(password1.equals(password2)) {
            //render the signup confirm template if the passwords match
            RequestDispatcher rd =  req.getRequestDispatcher("/WEB-INF/jsp/signupConfirm.jsp");
            
            //create the user object and serialize to file
            User user = new User(username, password1);
            
            req.setAttribute("passwordsMatch", "true");
            req.setAttribute("username", username);
            req.setAttribute("password1", password1);
            req.setAttribute("password2", password2);
            rd.forward(req, res);
            
        } else {
            //return the signup form again b/c the passwords didn't match
            RequestDispatcher rd =  req.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
            String errorMsg = "Your passwords didn't match. Plz try again";
            req.setAttribute("passwordsMatch", "false");
            req.setAttribute("errorMsg", errorMsg);
            rd.forward(req, res);
        }
        
        
    }
}
