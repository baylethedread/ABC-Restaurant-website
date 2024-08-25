package com.abc.controllers;

public class ReportServlet {

}
package com.abc.controllers;

import com.abc.dao.ReportDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportDAO reportDAO;

    public ReportServlet() {
        this.reportDAO = new ReportDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Example code to generate a report
        reportDAO.generateReport();
        response.sendRedirect("report.jsp");
    }
}
