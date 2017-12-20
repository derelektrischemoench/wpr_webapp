package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateChapterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/createChapterForm.jsp");
        rd.forward(req, res);
    }
    
    //TODO: serialize the chapters
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //RequestDispatcher rd = req.getRequestDispatcher();
        String chapterName = req.getParameter("name");
        String chapterDescription = req.getParameter("chapterform");
    
        System.out.println(chapterName + "\n" + chapterDescription);
        
    }
}
