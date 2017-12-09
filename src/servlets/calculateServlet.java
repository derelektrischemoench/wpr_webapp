package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

public class calculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String height = request.getParameter("height");
        final String weight = request.getParameter("weight");
        final String sex = request.getParameter("sex");
        String resultMsg = "";
        String contextPath = "";
        
        double heightCm = Double.parseDouble(height);
        double weightKg = Double.parseDouble(weight);
        double bmi = weightKg / (Math.pow(heightCm/100,2));
        
        if(bmi<16) {
            resultMsg = "You are severly underweight";
        } else if (bmi>=16 && bmi<17) {
            resultMsg = "You are moderately underweight";
        } else if (bmi>=17 && bmi<18.5) {
            resultMsg = "You are slightly underweight";
        } else if (bmi>=18.5 && bmi<25) {
            resultMsg = "You are of normal weight";
        } else if (bmi>=25 && bmi<30) {
            resultMsg = "You are overweight";
        } else if (bmi>=30 && bmi<35) {
            resultMsg = "Adipositas I";
        } else if (bmi>=35 && bmi<40) {
            resultMsg = "Adipositas II";
        } else if (bmi>=40) {
            resultMsg = "Adipositas III";
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location", "adipositas1.jsp");
        }
        
        //pack result of function into request attrs:
        request.setAttribute("sex", sex);
        request.setAttribute("height", heightCm);
        request.setAttribute("weight", weightKg);
        request.setAttribute("resultMsg", resultMsg);
        
        //render that biatch
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/resultsBmi.jsp");
        rd.include(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "i am a variable called message in calculateServlet.java";
        
        //request.setAttribute("message", message);

        //argumentst to getRequestDispatcher beginning with / are read relative to the current context root
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        rd.forward(request, response);
    }
}
