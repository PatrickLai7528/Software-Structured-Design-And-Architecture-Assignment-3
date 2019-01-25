package controller;

import logic.logicmodel.User;
import model.BookEntity;
import util.BookImageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in index");
        int defaultActiveUserId = 1;
        request.getRequestDispatcher("/ShowBook?userId="+defaultActiveUserId).forward(request, response);
    }
}
