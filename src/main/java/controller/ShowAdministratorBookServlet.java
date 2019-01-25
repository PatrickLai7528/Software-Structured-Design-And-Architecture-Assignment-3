package controller;

import logic.logicmodel.Administrator;
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
import java.util.List;

@WebServlet("/ShowAdminBook")
public class ShowAdministratorBookServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Administrator administrator = new Administrator(1); // now only have 1 admin
        List<BookEntity> bookList = administrator.getBookList();
        HttpSession session = request.getSession(true);
        session.setAttribute("admin", administrator);
        session.setAttribute("bookList", bookList);
        session.setAttribute("randomBookCoverList", BookImageUtils.getBookImageListRandomly(bookList.size()));
        request.getRequestDispatcher("/home/AdminHome.jsp").forward(request, response);

    }
}
