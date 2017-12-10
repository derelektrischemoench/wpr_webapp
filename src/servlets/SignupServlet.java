package servlets;

import com.sun.corba.ee.spi.protocol.RequestDispatcherDefault;
import org.apache.catalina.HttpResponse;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

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
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd =  req.getRequestDispatcher("/WEB-INF/jsp/signupConfirm.jsp");
        
        String username = req.getParameter("name");
        String password1 = req.getParameter("password");
        String password2 = req.getParameter("password2");
        
        
        if(password1.equals(password2)) {
            //req.setAttribute("passwordsMatch", true);
            req.setAttribute("username", username);
            req.setAttribute("password1", password1);
            req.setAttribute("password2", password2);
            rd.forward(req, res);
        } else {
            //req.setAttribute("passwordsMatch", false);
            rd.forward(req, res);
        }
        
        
    }
}
