package controller;


import logic.logicmodel.User;
import model.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/OnlineReadBook")
public class OnlineReadBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User currentUser = (User) session.getAttribute("currentUser");
        System.out.println("CURRENT USER: " + currentUser);
        int selectBookId = Integer.parseInt(request.getParameter("bookId"));
        List<BookEntity> bookList = (List<BookEntity>) session.getAttribute("bookList");
        BookEntity selectedBook = null;
        String format = request.getParameter("format");
        if (null == format) // for default
            format = "Word";
        for (BookEntity book : bookList) {
            if (book.getBid() == selectBookId) {
                selectedBook = book;
            }
        }
        System.out.println("SELECTED BOOK: " + selectedBook);
        String readingContent = currentUser.readOnline(selectedBook, format);
        session.setAttribute("readingContent", readingContent);
        session.setAttribute("selectedBook", selectedBook);
        request.getRequestDispatcher("/book/OnlineReading.jsp").forward(request, response);
    }
}
