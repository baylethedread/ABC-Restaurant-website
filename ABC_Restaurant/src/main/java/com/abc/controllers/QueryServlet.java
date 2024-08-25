package com.abc.controllers;

import com.abc.dao.QueryDAO;
import com.abc.models.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QueryDAO queryDAO;

    public QueryServlet() {
        this.queryDAO = new QueryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String queryText = request.getParameter("queryText");

        Query query = new Query(0, userId, queryText, "Pending");
        queryDAO.saveQuery(query);

        response.sendRedirect("query.jsp");
    }
}
