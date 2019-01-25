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

@WebServlet("/BorrowBook")
public class BorrowBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Borrowing Bool...");
        int selectedBookId = Integer.parseInt(request.getParameter("bookId"));
        HttpSession session = request.getSession(false);
        List<BookEntity> bookList = (List<BookEntity>) session.getAttribute("bookList");
        User currentUser = (User) session.getAttribute("currentUser");
        BookEntity selectedBook = null;
        for (BookEntity bookEntity : bookList) {
            if (bookEntity.getBid() == selectedBookId) {
                selectedBook = bookEntity;
            }
        }
        int resultCode = currentUser.borrowBook(selectedBook);
        String resultMessage = null;
        switch (resultCode) {
            case 0:
                resultMessage = "You have borrowed this book successfully :)";
                break;
            case 1:
                resultMessage = "You have reached the maximum limit :(";
                break;
            case 2:
                resultMessage = "This book has no inventory now :(";
                break;
            default:
                System.out.println("Should not run to here");
        }
        session.setAttribute("resultMessage", resultMessage);
        session.setAttribute("borrowedBook", selectedBook);
        System.out.println("RESULT MESSAGE: " + resultMessage);
        System.out.println("SELECTED BOOK: " + selectedBook);
        request.getRequestDispatcher("/book/BorrowResult.jsp").forward(request, response);
    }
}
