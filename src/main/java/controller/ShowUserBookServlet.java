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
import java.util.List;

@WebServlet("/ShowBook")
public class ShowUserBookServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User currentUser = new User(userId);
        List<BookEntity> bookList = currentUser.getBookList();
        HttpSession session = request.getSession(true);
        session.setAttribute("currentUser", currentUser);
        session.setAttribute("bookList", bookList);
        session.setAttribute("randomBookCoverList", BookImageUtils.getBookImageListRandomly(bookList.size()));
        request.getRequestDispatcher("/home/UserHome.jsp").forward(request, response);
    }
}
